package cn.retech.toolutils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.text.TextUtils;
import cn.retech.global_data_cache.GlobalDataCacheForMemorySingleton;
import cn.retech.global_data_cache.GlobalDataCacheForNeedSaveToFileSystem;

/**
 * 这里只放置, 在当前项目中会被用到的方法
 * 
 * @author zhihua.tang
 */
@SuppressLint("SimpleDateFormat")
public final class ToolsFunctionForThisProgect {

  private ToolsFunctionForThisProgect() {

  }

  public static synchronized void stopServiceWithThisApp() {
    // Intent intent = new Intent(MyApplication.getApplication(),
    // PreLoadedDataService.class);
    // MyApplication.getApplication().stopService(intent);
  }

  public static synchronized void quitApp(final Activity activity) {
    activity.finish();

    // 停止和当前App相关的所有服务
    ToolsFunctionForThisProgect.stopServiceWithThisApp();

    // 在这里保存数据
    GlobalDataCacheForNeedSaveToFileSystem.writeAllCacheData();

    // 杀死当前app进程
    int nPid = android.os.Process.myPid();
    android.os.Process.killProcess(nPid);
  }

  // 获取当前设备的UA信息
  public static synchronized String getUserAgent() {
    // app名称 : DreamBook
    String bundleName = "DreamBook";
    // app当前版本号 : 1.1.2
    String version = getVersionName();
    // 当前设备型号
    String platFormHardware = Build.MODEL + Build.VERSION.RELEASE;
    String platFormOSversion = "Android" + Build.VERSION.RELEASE;
    // DreamBook_1.1.0-SNAPSHOT_MI 2S4.1.1_Android4.1.1
    String userAgent = bundleName + "_" + version + "_" + platFormHardware + "_" + platFormOSversion;
    return userAgent;
  }

  /**
   * 获取本机IP
   * 
   */
  public static String getDeviceIP() {
    String ipaddress = "";
    try {
      for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
        NetworkInterface intf = en.nextElement();
        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
          InetAddress inetAddress = enumIpAddr.nextElement();
          if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress()) {
            ipaddress = inetAddress.getHostAddress().toString();
            break;
          }
        }

        if (!TextUtils.isEmpty(ipaddress)) {
          break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ipaddress;
  }

  /**
   * byte(字节)根据长度转成kb(千字节)和mb(兆字节)
   * 
   * @param bytes
   * @return
   */
  public static String bytesToKbOrMb(long bytes) {
    BigDecimal filesize = new BigDecimal(bytes);
    BigDecimal megabyte = new BigDecimal(1024 * 1024);
    float returnValue = filesize.divide(megabyte, 2, BigDecimal.ROUND_UP).floatValue();
    if (returnValue > 1)
      return (returnValue + "MB");
    BigDecimal kilobyte = new BigDecimal(1024);
    returnValue = filesize.divide(kilobyte, 2, BigDecimal.ROUND_UP).floatValue();
    return (returnValue + "KB");
  }

  /**
   * 获取版本的android:versionName
   * 
   * @return
   * @throws Exception
   */
  public static String getVersionName() {
    // 获取packagemanager的实例
    PackageManager packageManager = GlobalDataCacheForMemorySingleton.getInstance.getApplication().getPackageManager();
    // getPackageName()是你当前类的包名，0代表是获取版本信息
    PackageInfo packInfo = null;
    try {
      packInfo = packageManager.getPackageInfo(GlobalDataCacheForMemorySingleton.getInstance.getApplication().getPackageName(), 0);
    } catch (NameNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    String version = packInfo.versionName;
    return version;
  }

  /**
   * 获取友盟渠道标识
   * 
   * @return
   */
  public static String getUmengChannel() {
    ApplicationInfo appInfo = null;
    try {
      appInfo = GlobalDataCacheForMemorySingleton.getInstance.getApplication().getPackageManager()
          .getApplicationInfo(GlobalDataCacheForMemorySingleton.getInstance.getApplication().getPackageName(), PackageManager.GET_META_DATA);
    } catch (NameNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    String msg = appInfo.metaData.getString("UMENG_CHANNEL");
    return msg;
  }

  /**
   * 用来判断服务是否运行.
   * 
   * @param context
   * @param className
   *          判断的服务名字
   * @return true 在运行 false 不在运行
   */
  public static boolean isServiceRunning(Context mContext, String className) {
    boolean isRunning = false;
    ActivityManager activityManager = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
    List<ActivityManager.RunningServiceInfo> serviceList = activityManager.getRunningServices(99);
    if (!(serviceList.size() > 0)) {
      return false;
    }
    for (int i = 0; i < serviceList.size(); i++) {
      if (serviceList.get(i).service.getClassName().equals(className) == true) {

        isRunning = true;
        break;
      }
    }
    return isRunning;
  }

  // 统计目录大小的方法
  public static long getDirSize(File file) {
    long size = 0;
    if (file.isFile()) {
      // 如果是文件，获取文件大小累加
      size += file.length();
    } else if (file.isDirectory()) {
      // 获取目录中的文件及子目录信息
      File[] f1 = file.listFiles();
      for (int i = 0; i < f1.length; i++) {
        // 调用递归遍历f1数组中的每一个对象
        size += getDirSize(f1[i]);
      }
    }
    return size;
  }

  /**
   * 拷贝assets下的文件到指定路径(只限于单独文件)
   * 
   * @param context
   * @param fileNameString
   *          assets中的文件名
   * @param strOutFileName
   *          输出路径
   */
  public static void copyBigDataToSD(Context context, String fileNameString, String strOutFileName) {
    InputStream myInput;
    try {

      OutputStream myOutput = new FileOutputStream(strOutFileName);
      myInput = context.getAssets().open(fileNameString);
      byte[] buffer = new byte[1024];
      int length = myInput.read(buffer);
      while (length > 0) {
        myOutput.write(buffer, 0, length);
        length = myInput.read(buffer);
      }

      myOutput.flush();
      myInput.close();
      myOutput.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 获取Qyer登陆加密串
   * 
   * @param username
   * @param pwd
   * @return
   */
  public static String getAccountS(String username, String pwd) {
    String temp = username.substring(0, 2) + pwd.substring(0, 2) + username.substring(username.length() - 2, username.length()) + pwd.substring(pwd.length() - 2, pwd.length());
    DebugLog.d("", "getAccountS :  " + temp);
    DebugLog.d("", "getAccountS MD5 :  " + MD5Util.getMD5String(MD5Util.getMD5String(temp).toLowerCase()).toLowerCase());

    return MD5Util.getMD5String(MD5Util.getMD5String(temp).toLowerCase()).toLowerCase();
  }

  public static boolean hasChannelIcon() {
    ArrayList<String> channels = new ArrayList<String>();
    channels.add("taobao");

    return channels.contains(getUmengChannel());
  }

  public static String getChannelText() {
    HashMap<String, String> hm = new HashMap<String, String>();
    hm.put("taobao", "淘宝手机助手独家首发");
    return hm.get(getUmengChannel());
  }
}
