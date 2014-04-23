package cn.retech.toolutils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.tools.zip.ZipFile;

public final class SimpleZipTools {
	private final String TAG = this.getClass().getSimpleName();

	private SimpleZipTools() {
		// 这是一个工具类
	}

	/**
	 * 设置缓冲值
	 */
	static final int BUFFER = 8192;

	private static final String ALGORITHM = "PBEWithMD5AndDES";

	public static void zip(String zipFileName, String inputFile, String pwd) throws Exception {
		zip(zipFileName, new File(inputFile), pwd);
	}

	/**
	 * 功能描述：压缩指定路径下的所有文件
	 * 
	 * @param zipFileName
	 *            压缩文件名(带有路径)
	 * @param inputFile
	 *            指定压缩文件夹
	 * @return
	 * @throws Exception
	 */
	public static void zip(String zipFileName, String inputFile) throws Exception {
		zip(zipFileName, new File(inputFile), null);
	}

	/**
	 * 功能描述：压缩文件对象
	 * 
	 * @param zipFileName
	 *            压缩文件名(带有路径)
	 * @param inputFile
	 *            文件对象
	 * @return
	 * @throws Exception
	 */
	public static void zip(String zipFileName, File inputFile, String pwd) throws Exception {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
		zip(out, inputFile, "", pwd);
		out.close();
	}

	/**
	 * 
	 * @param out
	 *            压缩输出流对象
	 * @param file
	 * @param base
	 * @throws Exception
	 */
	public static void zip(ZipOutputStream outputStream, File file, String base, String pwd) throws Exception {
		if (file.isDirectory()) {
			File[] fl = file.listFiles();
			outputStream.putNextEntry(new ZipEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				zip(outputStream, fl[i], base + fl[i].getName(), pwd);
			}
		} else {
			outputStream.putNextEntry(new ZipEntry(base));
			FileInputStream inputStream = new FileInputStream(file);
			// 普通压缩文件
			if (pwd == null || pwd.trim().equals("")) {
				int b;
				while ((b = inputStream.read()) != -1) {
					outputStream.write(b);
				}
				inputStream.close();
			}
			// 给压缩文件加密
			else {
				PBEKeySpec keySpec = new PBEKeySpec(pwd.toCharArray());
				SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
				SecretKey passwordKey = keyFactory.generateSecret(keySpec);
				byte[] salt = new byte[8];
				Random rnd = new Random();
				rnd.nextBytes(salt);
				int iterations = 100;
				PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, iterations);
				Cipher cipher = Cipher.getInstance(ALGORITHM);
				cipher.init(Cipher.ENCRYPT_MODE, passwordKey, parameterSpec);
				outputStream.write(salt);
				byte[] input = new byte[64];
				int bytesRead;
				while ((bytesRead = inputStream.read(input)) != -1) {
					byte[] output = cipher.update(input, 0, bytesRead);
					if (output != null) {
						outputStream.write(output);
					}
				}
				byte[] output = cipher.doFinal();
				if (output != null) {
					outputStream.write(output);
				}
				inputStream.close();
				outputStream.flush();
				outputStream.close();
			}
		}
		file.delete();
	}

	public static void unzip(String zipFileName, String outputDirectory) throws Exception {
		/*
		 * ZipInputStream inputStream = new ZipInputStream(new FileInputStream(zipFileName)); unzip(inputStream, outputDirectory, null);
		 */
		long startTime = System.currentTimeMillis();
		try {
			ZipInputStream Zin = new ZipInputStream(new FileInputStream(zipFileName));// 输入源zip路径
			BufferedInputStream Bin = new BufferedInputStream(Zin);
			String Parent = outputDirectory; // 输出路径（文件夹目录）
			File Fout = null;
			ZipEntry entry;
			try {

				while ((entry = Zin.getNextEntry()) != null && !entry.isDirectory()) {
					Fout = new File(Parent, entry.getName());
					if (!Fout.exists()) {
						(new File(Fout.getParent())).mkdirs();
					}
					FileOutputStream out = new FileOutputStream(Fout);
					BufferedOutputStream Bout = new BufferedOutputStream(out);
					int b;
					while ((b = Bin.read()) != -1) {
						Bout.write(b);
					}
					Bout.close();
					out.close();
					System.out.println(Fout + "解压成功");
				}
				Bin.close();
				Zin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("耗费时间： " + (endTime - startTime) + " ms");
	}

	public static void unzipInputStream(ZipInputStream Zin, String outputDirectory) throws Exception {
		/*
		 * ZipInputStream inputStream = new ZipInputStream(new FileInputStream(zipFileName)); unzip(inputStream, outputDirectory, null);
		 */
		long startTime = System.currentTimeMillis();
		// ZipInputStream Zin = new ZipInputStream(new FileInputStream(zipFileName));// 输入源zip路径
		BufferedInputStream Bin = new BufferedInputStream(Zin);
		String Parent = outputDirectory; // 输出路径（文件夹目录）
		File Fout = null;
		ZipEntry entry;
		try {
			while ((entry = Zin.getNextEntry()) != null && !entry.isDirectory()) {
				Fout = new File(Parent, entry.getName());
				if (!Fout.exists()) {
					(new File(Fout.getParent())).mkdirs();
				}
				FileOutputStream out = new FileOutputStream(Fout);
				BufferedOutputStream Bout = new BufferedOutputStream(out);
				int b;
				while ((b = Bin.read()) != -1) {
					Bout.write(b);
				}
				Bout.close();
				out.close();
				System.out.println(Fout + "解压成功");
			}
			Bin.close();
			Zin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("耗费时间： " + (endTime - startTime) + " ms");
	}

	/**
	 * 功能描述：将压缩文件解压到指定的文件目录下
	 * 
	 * @param zipFileName
	 *            压缩文件名称(带路径)
	 * @param outputDirectory
	 *            指定解压目录
	 * @return
	 * @throws Exception
	 */
	public static boolean unzip(String zipFileName, String outputDirectory, String pwd) throws Exception {
		ZipInputStream inputStream = new ZipInputStream(new FileInputStream(zipFileName));
		return unzip(inputStream, outputDirectory, pwd);
	}

	public static boolean unzip(File zipFile, String outputDirectory, String pwd) throws Exception {
		ZipInputStream inputStream = new ZipInputStream(new FileInputStream(zipFile));
		return unzip(inputStream, outputDirectory, pwd);
	}

	public static boolean unzip(ZipInputStream inputStream, String outputDirectory, String pwd) throws Exception {
		long startTime = System.currentTimeMillis();
		boolean state = true;
		ZipEntry zipEntry = null;
		FileOutputStream outputStream = null;
		try {
			while ((zipEntry = inputStream.getNextEntry()) != null) {
				if (zipEntry.isDirectory()) {
					String name = zipEntry.getName();
					name = name.substring(0, name.length() - 1);
					File file = new File(outputDirectory + File.separator + name);
					file.mkdir();
				} else {
					File file = new File(outputDirectory + File.separator + zipEntry.getName());
					file.createNewFile();
					outputStream = new FileOutputStream(file);
					// 普通解压缩文件
					if (pwd == null || pwd.trim().equals("")) {
						int b;
						while ((b = inputStream.read()) != -1) {
							outputStream.write(b);
						}
						outputStream.close();
					}
					// 解压缩加密文件
					else {
						PBEKeySpec keySpec = new PBEKeySpec(pwd.toCharArray());
						SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
						SecretKey passwordKey = keyFactory.generateSecret(keySpec);
						byte[] salt = new byte[8];
						inputStream.read(salt);
						int iterations = 100;
						PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, iterations);
						Cipher cipher = Cipher.getInstance(ALGORITHM);
						cipher.init(Cipher.DECRYPT_MODE, passwordKey, parameterSpec);
						byte[] input = new byte[64];
						int bytesRead;
						while ((bytesRead = inputStream.read(input)) != -1) {
							byte[] output = cipher.update(input, 0, bytesRead);
							if (output != null) {
								outputStream.write(output);
							}
						}
						byte[] output = cipher.doFinal();
						if (output != null) {
							outputStream.write(output);
						}
						outputStream.flush();
						outputStream.close();
					}
				}
			}
			inputStream.close();
		} catch (IOException ex) {

			state = false;
			throw new Exception("解压读取文件失败");
		} catch (Exception ex) {
			state = false;
			throw new Exception("解压文件密码不正确");
		} finally {
			inputStream.close();
			outputStream.flush();
			outputStream.close();
			System.out.println("解压成功");
			state = true;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("耗费时间： " + (endTime - startTime) + " ms");
		return state;
	}

	/**
	 * 解压到指定目录
	 * 
	 * @param zipPath
	 * @param descDir
	 */
	public static boolean unZipFiles(String zipPath, String descDir) throws IOException {
		return unZipFiles(new File(zipPath), descDir);
	}

	/**
	 * 解压文件到指定目录
	 * 
	 * @param zipFile
	 * @param descDir
	 */
	@SuppressWarnings("rawtypes")
	public static boolean unZipFiles(File zipFile, String descDir) {
		boolean state = true;
		File pathFile = new File(descDir);
		if (!pathFile.exists()) {
			pathFile.mkdirs();
		}
		try {
			ZipFile zip = new ZipFile(zipFile);

			for (Enumeration entries = zip.getEntries(); entries.hasMoreElements();) {
				org.apache.tools.zip.ZipEntry entry = (org.apache.tools.zip.ZipEntry) entries.nextElement();
				String zipEntryName = entry.getName();
				InputStream in = zip.getInputStream(entry);
				String outPath = (descDir + "/" + zipEntryName).replaceAll("\\*", "/");
				// 判断路径是否存在,不存在则创建文件路径
				File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
				if (!file.exists()) {
					file.mkdirs();
				}
				// 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
				if (new File(outPath).isDirectory()) {
					continue;
				}
				// 输出文件路径信息
				DebugLog.e("SimpleZipTools.unZipFiles", outPath);

				OutputStream out = new FileOutputStream(outPath);
				byte[] buf1 = new byte[1024];
				int len;
				while ((len = in.read(buf1)) > 0) {
					out.write(buf1, 0, len);
				}
				in.close();
				out.close();
			}
		} catch (IOException e) {
			state = false;
			e.printStackTrace();
		}

		System.out.println("******************解压完毕********************");
		return state;
	}
}
