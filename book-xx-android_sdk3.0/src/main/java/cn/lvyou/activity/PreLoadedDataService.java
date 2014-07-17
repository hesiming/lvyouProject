package cn.lvyou.activity;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import cn.lvyou.my_network_engine.INetRequestHandle;
import cn.lvyou.my_network_engine.NetRequestHandleNilObject;
import cn.lvyou.toolutils.DebugLog;

/**
 * 启动App后, 就会激活当前服务, 当前服务的功能就是加载一些耗时的资源
 * 
 * @author skyduck
 * 
 */
// 如果先采用startService()方法启动服务,然后调用bindService()方法绑定到服务，
// 再调用unbindService()方法解除绑定，最后调用bindService()方法再次绑定到服务，
// 触发的生命周期方法如下：
// onCreate()onStart()onBind()onUnbind()[重载后的方法需返回true]onRebind()
public class PreLoadedDataService extends Service {
  private final String TAG = this.getClass().getSimpleName();

  // 推送消息
  private INetRequestHandle netRequestHandleForPushMessage = new NetRequestHandleNilObject();

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    DebugLog.i(TAG, "onConfigurationChanged");
    super.onConfigurationChanged(newConfig);
  }

  // onCreate()该方法在服务被创建时调用，该方法只会被调用一次，
  // 无论调用多少次startService()或bindService()方法，服务也只被创建一次。
  @Override
  public void onCreate() {
    super.onCreate();
    DebugLog.i(TAG, "onCreate");

  }

  // onStart() 只有采用Context.startService()方法启动服务时才会回调该方法。
  // 该方法在服务开始运行时被调用。多次调用startService()方法尽管不会多次创建服务，
  // 但onStart() 方法会被多次调用。
  @Override
  public void onStart(Intent intent, int startId) {
    DebugLog.i(TAG, "onStart");
    super.onStart(intent, startId);
  }

  // onDestroy()该方法在服务被终止时调用。
  @Override
  public void onDestroy() {
    DebugLog.i(TAG, "onDestroy");
    netRequestHandleForPushMessage.cancel();
    super.onDestroy();
  }

  @Override
  public void onLowMemory() {
    DebugLog.i(TAG, "onLowMemory");
    super.onLowMemory();
  }

  @Override
  public void onRebind(Intent intent) {
    DebugLog.i(TAG, "onRebind");
    super.onRebind(intent);
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    DebugLog.i(TAG, "onStartCommand");
    return super.onStartCommand(intent, flags, startId);
  }

  // onBind()只有采用Context.bindService()方法启动服务时才会回调该方法。
  // 该方法在调用者与服务绑定时被调用，当调用者与服务已经绑定，
  // 多次调用Context.bindService()方法并不会导致该方法被多次调用。
  @Override
  public IBinder onBind(Intent arg0) {
    DebugLog.i(TAG, "onBind");
    return null;
  }

  // onUnbind()只有采用Context.bindService()方法启动服务时才会回调该方法。
  // 该方法在调用者与服务解除绑定时被调用。
  @Override
  public boolean onUnbind(Intent intent) {
    DebugLog.i(TAG, "onUnbind");
    return super.onUnbind(intent);
  }

}
