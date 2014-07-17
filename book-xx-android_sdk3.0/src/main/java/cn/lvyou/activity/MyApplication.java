package cn.lvyou.activity;

import java.io.File;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap.CompressFormat;
import cn.lvyou.global_data_cache.GlobalDataCacheForMemorySingleton;
import cn.lvyou.global_data_cache.GlobalDataCacheForNeedSaveToFileSystem;
import cn.lvyou.global_data_cache.LocalCacheDataPathConstant;
import cn.lvyou.image_loader.MyImageDownloader;
import cn.lvyou.toolutils.DebugLog;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

// 在Android中启用断言的方法： adb shell setprop debug.assert 1 
// mac系统配置 adb
// 一、终端中输入 cd ~
// 二、输入 touch .bash_profile 回车
// 三、输入 open -e .bash_profile
// 输入 : export PATH=$PATH:/Applications/developer/android-sdk-macosx/tools:/Applications/developer/android-sdk-macosx/platform-tools
/**
 * 自定义 Application
 * 
 * @author hesiming
 * 
 */
public class MyApplication extends Application {
  private final String TAG = this.getClass().getSimpleName();

  // Application 类对外的接口
  private static MyApplication self;

  public static Application getApplication() {
    assert false : "MyApplication 还未初始化完成, 不能调用Application.getApplication()方法.";
    return self;
  }

  @Override
  public void onCreate() {

    DebugLog.i(TAG, "onCreate");
    super.onCreate();

    // 缓存MyApplication实例对象(必须在第一行调用)
    cacheMyApplicationInstance(this);

    // 创建本地缓存目录
    LocalCacheDataPathConstant.createLocalCacheDirectories();
    // 配置图片墙模块ImageLoader
    configImageLoaderLibrary();

    // 读取本地缓存的重要数据
    GlobalDataCacheForNeedSaveToFileSystem.readAllCacheData();

    // 启动 "预加载数据" 服务, 用于在后台加载那些不是必须在app一启动就需要使用到的懒数据
    startPreLoadedDataService();
  }

  @Override
  public void onTerminate() {
    DebugLog.d(TAG, "onTerminate");
    // 父类方法, 必须调用
    super.onTerminate();
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    DebugLog.i(TAG, "onConfigurationChanged");
    super.onConfigurationChanged(newConfig);
  }

  @Override
  public void onLowMemory() {
    DebugLog.i(TAG, "onLowMemory");
    super.onLowMemory();
  }

  /**
   * 缓存MyApplication实例对象
   * 
   * @param instance
   */
  private void cacheMyApplicationInstance(MyApplication instance) {
    assert MyApplication.self == null : "cacheMyApplicationInstance() 方法不应该重复调用.";
    //
    MyApplication.self = instance;

    // 缓存Application实例, 以供lib层调用(Application 最重要的是可以提供上下文 Context)
    GlobalDataCacheForMemorySingleton.getInstance.setApplication(instance);
  }

  /**
   * 配置图片墙模块ImageLoader
   */
  private void configImageLoaderLibrary() {
    DisplayImageOptions optionsOfDisplayImageOptions = new DisplayImageOptions.Builder().cacheInMemory(true) // default
        .cacheOnDisc(true) // default
        .build();

    // 图片缓存目录(Returns application cache directory. Cache directory will be
    // created on SD card)
    // ImageLoader 提供的方法
    // File imageCacheDir =
    // StorageUtils.getCacheDirectory(getApplicationContext());
    // 我们自己定义的方法
    File imageCacheDir = LocalCacheDataPathConstant.thumbnailCachePathInDevice();
    DebugLog.i(TAG, "ImageLoaderLibrary 的图片缓存目录-->" + imageCacheDir.toString());
    ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).memoryCacheExtraOptions(480, 800)
    // default: device screen dimensions
        .discCacheExtraOptions(480, 800, CompressFormat.JPEG, 75, null).threadPoolSize(1)
        // default
        .threadPriority(Thread.NORM_PRIORITY - 1)
        // default
        .tasksProcessingOrder(QueueProcessingType.FIFO)
        // default
        .denyCacheImageMultipleSizesInMemory().memoryCache(new LruMemoryCache(2 * 1024 * 1024)).memoryCacheSize(2 * 1024 * 1024).memoryCacheSizePercentage(13) // default
        .discCache(new UnlimitedDiscCache(imageCacheDir)) // default
        .discCacheSize(50 * 1024 * 1024).discCacheFileCount(100).discCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
        .defaultDisplayImageOptions(optionsOfDisplayImageOptions) // default
        .writeDebugLogs().imageDownloader(new MyImageDownloader(getApplicationContext())).build();
    ImageLoader.getInstance().init(config);
  }

  /**
   * 启动 "预加载数据" 服务, 用于在后台加载那些不是必须在app一启动就需要使用到的懒数据
   */
  private void startPreLoadedDataService() {
    // 启动一个服务, 用于预加载相关数据
    Intent intent = new Intent(this, PreLoadedDataService.class);
    // 采用 startService() 启动的服务, 必须主动调用 stopService() 来主动停止
    startService(intent);
  }
}