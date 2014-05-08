package cn.lvyou.global_data_cache;

import static com.google.common.collect.Lists.newArrayList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.os.Environment;
import cn.lvyou.toolutils.DebugLog;
import cn.lvyou.toolutils.ToolsFunctionForThisProgect;

public final class LocalCacheDataPathConstant {
  private static final String TAG = "LocalCacheDataPathConstant";
  public static final String kAppLocalCacheDirectory = "DreamBook";

  // app 本地缓存根目录
  public static File localCacheDirectoryRootPathInSDCard() {
    File pathFile = new File(Environment.getExternalStorageDirectory() + "/" + kAppLocalCacheDirectory);
    return pathFile;
  }

  // 项目中 "缩略图" 缓存目录 (在设备存储中, 可以被清除)
  // 对于 "今日书院" 项目, 因为会处于长时间下载书籍到SD卡中的操作, 所以其他的数据就不能及时的保存到SD卡中了, 因为SD卡的IO通道被霸占了
  // 所以我们对于其他的数据, 直接保存到设备本身的存储中, 来优化缓存数据的速度
  public static File thumbnailCachePathInDevice() {
    File pathFile = new File(GlobalDataCacheForMemorySingleton.getInstance.getApplication().getCacheDir().getPath() + "/" + "ThumbnailCachePath");
    return pathFile;
  }

  // 书籍共享目录(在SD卡中, 可以直接拖拽书籍安装包到共享目录中, app会在启动时识别这个目录下面的书籍安装包)
  public static File sharedDirectoryPathInSDCard() {
    File pathFile = new File(LocalCacheDataPathConstant.localCacheDirectoryRootPathInSDCard() + "/" + "SharedDirectory");
    return pathFile;
  }

  // 本地书籍保存目录(在SD卡中)
  public static File localBookCachePathInSDCard() {
    File pathFile = new File(LocalCacheDataPathConstant.localCacheDirectoryRootPathInSDCard() + "/" + "LocalBookDir");
    return pathFile;
  }

  // 主题包保存路径
  public static File themeCachePathInDevice() {
    File pathFile = new File(GlobalDataCacheForMemorySingleton.getInstance.getApplication().getCacheDir().getPath() + "/" + "Theme");
    return pathFile;
  }

  // 返回能被用户清空的文件目录数组(可以从这里获取用户可以直接清空的文件夹路径数组)
  public static List<File> directoriesCanBeClearByTheUser() {
    List<File> list = new ArrayList<File>();
    File file = thumbnailCachePathInDevice();
    list.add(file);
    return list;
  }

  public static long getLocalCacheDataSize() {
    long size = 0;
    for (File file : directoriesCanBeClearByTheUser()) {
      size += ToolsFunctionForThisProgect.getDirSize(file);
    }
    return size;
  }

  // 创建本地数据缓存目录(一次性全部创建, 不会重复创建)
  public static void createLocalCacheDirectories() {
    List<File> directories = newArrayList();
    // 根目录必须在首位
    directories.add(localCacheDirectoryRootPathInSDCard());
    // 以下是根目录下面的子目录
    directories.add(thumbnailCachePathInDevice());
    directories.add(sharedDirectoryPathInSDCard());
    directories.add(localBookCachePathInSDCard());
    directories.add(themeCachePathInDevice());

    for (File directoryPath : directories) {
      if (!directoryPath.exists()) {
        if (!directoryPath.mkdir()) {
          DebugLog.e(TAG, "创建重要的本地缓存目录失败, 目录路径是-->" + directoryPath.getPath());
        }
      }
    }
  }
}
