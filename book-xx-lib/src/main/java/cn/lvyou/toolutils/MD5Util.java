package cn.lvyou.toolutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
  private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
  private static MessageDigest messageDigest = null;

  static {
    try {
      messageDigest = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }

  public static String getMD5String(String str) {
    return getMD5String(str.getBytes());
  }

  public static String getMD5String(byte[] bytes) {
    messageDigest.update(bytes);
    return bytesToHex(messageDigest.digest());
  }

  public static String bytesToHex(byte bytes[]) {
    return bytesToHex(bytes, 0, bytes.length);
  }

  public static String bytesToHex(byte bytes[], int start, int end) {
    StringBuilder sb = new StringBuilder();

    for (int i = start; i < start + end; i++) {
      sb.append(byteToHex(bytes[i]));
    }

    return sb.toString();
  }

  public static String byteToHex(byte bt) {
    return HEX_DIGITS[(bt & 0xf0) >> 4] + "" + HEX_DIGITS[bt & 0xf];
  }

  /**
   * 计算文件的MD5
   * 
   * @param fileName
   *          文件的绝对路径
   * @return
   * @throws IOException
   */
  public String getFileMD5String(String fileName) throws IOException {
    File f = new File(fileName);
    return getFileMD5String(f);
  }

  /**
   * 计算文件的MD5，重载方法
   * 
   * @param file
   *          文件对象
   * @return
   * @throws IOException
   */
  public String getFileMD5String(File file) throws IOException {
    FileInputStream in = new FileInputStream(file);
    FileChannel ch = in.getChannel();
    MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
    messageDigest.update(byteBuffer);
    in.close();
    in = null;
    return bytesToHex(messageDigest.digest());
  }
}
