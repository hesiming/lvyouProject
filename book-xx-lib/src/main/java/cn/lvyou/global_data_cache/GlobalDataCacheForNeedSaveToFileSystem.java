package cn.lvyou.global_data_cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.lvyou.domainbean_model.login.LoginNetRespondBean;
import cn.lvyou.toolutils.DebugLog;

/**
 * 这里序列化对象的保存目录是 : /data/data/<包名>/files/ , 这个目录会在用户在 "应用程序管理" 中点击 "清理数据" 按钮后被清理
 * 
 * @author computer
 * 
 */
public final class GlobalDataCacheForNeedSaveToFileSystem {
  private final static String TAG = GlobalDataCacheForNeedSaveToFileSystem.class.getSimpleName();

  private GlobalDataCacheForNeedSaveToFileSystem() {

  }

  private enum CacheDataNameForSaveToFile {
    // 当前app版本号, 用了防止升级app时, 本地缓存的序列化数据恢复出错.
    LocalAppVersion,
    // 用户是否是首次启动App
    FirstStartApp,
    // 用户是否已经登录了
    IsLogged,
    // 用户最后一次成功登录时的用户名/密码
    UsernameForLastSuccessfulLogon,
    //
    PasswordForLastSuccessfulLogon,
    //
    LatestLogonNetRespondBean

  };

  public static synchronized void readAppConfingInfo() {
    //
    DebugLog.i(TAG, "start loading --> isFirstStartApp");
    SharedPreferences sharedPreferences = GlobalDataCacheForMemorySingleton.getInstance.getApplication().getSharedPreferences(GlobalConstant.APP_GLOBAL_SHARED_PREFERENCES, Context.MODE_PRIVATE);
    GlobalDataCacheForMemorySingleton.getInstance.setFirstStartApp(sharedPreferences.getBoolean(CacheDataNameForSaveToFile.FirstStartApp.name(), true));
  }

  /**
   * 读取本地缓存的 用户登录信息
   */
  public static void readUserLoginInfoToGlobalDataCacheForMemorySingleton() {
    // 用户登录相关信息
    DebugLog.i(TAG, "start loading --> 用户登录信息");
    SharedPreferences sharedPreferences = GlobalDataCacheForMemorySingleton.getInstance.getApplication().getSharedPreferences(GlobalConstant.APP_GLOBAL_SHARED_PREFERENCES, Context.MODE_PRIVATE);
    boolean isLogged = sharedPreferences.getBoolean(CacheDataNameForSaveToFile.IsLogged.name(), false);
    if (isLogged) {
      String usernameForLastSuccessfulLogon = sharedPreferences.getString(CacheDataNameForSaveToFile.UsernameForLastSuccessfulLogon.name(), null);
      String passwordForLastSuccessfulLogon = sharedPreferences.getString(CacheDataNameForSaveToFile.PasswordForLastSuccessfulLogon.name(), null);
      LoginNetRespondBean latestLogonNetRespondBean = (LoginNetRespondBean) deserializeObjectFromDeviceFileSystem(CacheDataNameForSaveToFile.LatestLogonNetRespondBean.name());
      GlobalDataCacheForMemorySingleton.getInstance.noteSignInSuccessfulInfo(latestLogonNetRespondBean, usernameForLastSuccessfulLogon, passwordForLastSuccessfulLogon);
    }
  }

  public static void readAllCacheData() {
    // 读取App配置信息
    readAppConfingInfo();
    // 读取本地缓存的 "用户登录信息"
    readUserLoginInfoToGlobalDataCacheForMemorySingleton();
  }

  // ///////////////////////////////////////////////////////////////////////////
  // ///////////////////////////////////////////////////////////////////////////
  // ///////////////////////////////////////////////////////////////////////////
  // ///////////////////////////////////////////////////////////////////////////
  // ///////////////////////////////////////////////////////////////////////////
  // ///////////////////////////////////////////////////////////////////////////
  // ///////////////////////////////////////////////////////////////////////////
  public static synchronized void writeAppConfigInfo() {
    //
    final boolean isFirstStartApp = GlobalDataCacheForMemorySingleton.getInstance.isFirstStartApp();
    SharedPreferences sharedPreferences = GlobalDataCacheForMemorySingleton.getInstance.getApplication().getSharedPreferences(GlobalConstant.APP_GLOBAL_SHARED_PREFERENCES, Context.MODE_PRIVATE);
    Editor editor = sharedPreferences.edit();
    editor.putBoolean(CacheDataNameForSaveToFile.FirstStartApp.name(), isFirstStartApp);
    editor.commit();
  }

  /**
   * 保存用户登录信息到设备文件系统中
   */
  public static void writeUserLoginInfoToFileSystem() {
    SharedPreferences sharedPreferences = GlobalDataCacheForMemorySingleton.getInstance.getApplication().getSharedPreferences(GlobalConstant.APP_GLOBAL_SHARED_PREFERENCES, Context.MODE_PRIVATE);
    Editor editor = sharedPreferences.edit();
    editor.putBoolean(CacheDataNameForSaveToFile.IsLogged.name(), GlobalDataCacheForMemorySingleton.getInstance.isLogged());
    if (GlobalDataCacheForMemorySingleton.getInstance.isLogged()) {
      editor.putString(CacheDataNameForSaveToFile.UsernameForLastSuccessfulLogon.name(), GlobalDataCacheForMemorySingleton.getInstance.getUsernameForLastSuccessfulLogon());
      editor.putString(CacheDataNameForSaveToFile.PasswordForLastSuccessfulLogon.name(), GlobalDataCacheForMemorySingleton.getInstance.getPasswordForLastSuccessfulLogon());
      serializeObjectToDeviceFileSystem(CacheDataNameForSaveToFile.LatestLogonNetRespondBean.name(), GlobalDataCacheForMemorySingleton.getInstance.getLatestLogonNetRespondBean());
    } else {
      editor.remove(CacheDataNameForSaveToFile.UsernameForLastSuccessfulLogon.name());
      editor.remove(CacheDataNameForSaveToFile.PasswordForLastSuccessfulLogon.name());
      serializeObjectToDeviceFileSystem(CacheDataNameForSaveToFile.LatestLogonNetRespondBean.name(), null);
    }

    editor.commit();
  }

  public static void writeAllCacheData() {
    // 保存 "app 配置信息"
    writeAppConfigInfo();
    // 保存 "用户登录信息"
    writeUserLoginInfoToFileSystem();
  }

  // ///////////////////////////////////////////////////////////////////////////
  // ///////////////////////////////////////////////////////////////////////////
  // ///////////////////////////////////////////////////////////////////////////
  // ///////////////////////////////////////////////////////////////////////////
  // ///////////////////////////////////////////////////////////////////////////
  // ///////////////////////////////////////////////////////////////////////////
  // ///////////////////////////////////////////////////////////////////////////

  private static void serializeObjectToSDCard(final String fileName, final String directoryPath, final Object object) {
    File file = new File(directoryPath + "/" + fileName);
    if (file.exists()) {
      file.delete();
    }
    try {
      serializeObjectToFile(object, new FileOutputStream(file));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

  private static void serializeObjectToDeviceFileSystem(final String fileName, final Object object) {
    File file = new File(GlobalDataCacheForMemorySingleton.getInstance.getApplication().getFilesDir() + "/" + fileName);
    if (file.exists()) {
      file.delete();
    }
    try {
      serializeObjectToFile(object, GlobalDataCacheForMemorySingleton.getInstance.getApplication().openFileOutput(fileName, Context.MODE_PRIVATE));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static void serializeObjectToFile(final Object object, final FileOutputStream fileOutputStream) {
    ObjectOutputStream objectOutputStream = null;
    try {

      do {
        if (fileOutputStream == null) {
          assert false : "入参为空!";
          break;
        }
        if (object == null) {
          break;
        }

        objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);

      } while (false);

    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      try {
        if (objectOutputStream != null) {
          objectOutputStream.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

      try {
        if (fileOutputStream != null) {
          fileOutputStream.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

  private static Object deserializeObjectFromDeviceFileSystem(final String fileName) {
    Object object = null;
    try {
      object = deserializeObjectFromFile(GlobalDataCacheForMemorySingleton.getInstance.getApplication().openFileInput(fileName));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return object;
  }

  private static Object deserializeObjectFromSDCard(final String fileName, final String directoryPath) {
    Object object = null;
    try {
      object = deserializeObjectFromFile(new FileInputStream(new File(directoryPath + "/" + fileName)));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return object;
  }

  private static Object deserializeObjectFromFile(FileInputStream fileInputStream) {
    Object object = null;
    ObjectInputStream objectInputStream = null;

    try {
      objectInputStream = new ObjectInputStream(fileInputStream);
      object = objectInputStream.readObject();
    } catch (Exception ex) {
      object = null;
      ex.printStackTrace();
    } finally {
      try {
        if (objectInputStream != null) {
          objectInputStream.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

      try {
        if (fileInputStream != null) {
          fileInputStream.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return object;
  }

}
