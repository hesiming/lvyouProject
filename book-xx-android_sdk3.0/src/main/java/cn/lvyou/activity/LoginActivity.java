package cn.lvyou.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import cn.retech.domainbean_model.login.LoginNetRequestBean;
import cn.retech.domainbean_model.login.LoginNetRespondBean;
import cn.retech.my_network_engine.IDomainBeanAsyncHttpResponseListenerWithUIControl;
import cn.retech.my_network_engine.INetRequestHandle;
import cn.retech.my_network_engine.NetRequestHandleNilObject;
import cn.retech.my_network_engine.SimpleNetworkEngineSingleton;
import cn.retech.my_network_engine.SimpleNetworkEngineSingleton.NetRequestResultEnum;
import cn.retech.my_network_engine.net_error_handle.MyNetRequestErrorBean;
import cn.retech.toolutils.DebugLog;
import cn.retech.toolutils.SimpleProgressDialog;

import com.umeng.analytics.MobclickAgent;

public class LoginActivity extends Activity {
  private final String TAG = this.getClass().getSimpleName();
  private INetRequestHandle netRequestHandleForLogin = new NetRequestHandleNilObject();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // 获取标识位，用来设置是否支持屏幕翻转(手机不支持屏幕翻转)
    if (!getResources().getBoolean(R.bool.isLarge)) {
      setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    setContentView(R.layout.activity_login);

    Button button = (Button) findViewById(R.id.button1);
    button.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        requestLogin("飞翔的熊猫", "198321");

      }
    });
  }

  private void requestLogin(final String username, final String password) {
    LoginNetRequestBean netRequestBean = new LoginNetRequestBean.Builder(username, password).builder();
    netRequestHandleForLogin = SimpleNetworkEngineSingleton.getInstance.requestDomainBean(netRequestBean, new IDomainBeanAsyncHttpResponseListenerWithUIControl() {

      @Override
      public void onSuccess(Object respondDomainBean) {
        LoginNetRespondBean loginNetRespondBean = (LoginNetRespondBean) respondDomainBean;

        Toast.makeText(LoginActivity.this, "登录成功-->" + loginNetRespondBean.toString(), Toast.LENGTH_SHORT).show();

      }

      @Override
      public void onFailure(MyNetRequestErrorBean error) {
        Toast.makeText(LoginActivity.this, "登录失败-->" + error.toString(), Toast.LENGTH_SHORT).show();

      }

      @Override
      public void onEnd(final NetRequestResultEnum resultEnum) {
        SimpleProgressDialog.dismiss(LoginActivity.this);
      }

      @Override
      public void onBegin() {
        SimpleProgressDialog.show(LoginActivity.this, new DialogInterface.OnCancelListener() {

          @Override
          public void onCancel(DialogInterface dialog) {
            // 用户取消了本次网络请求
            netRequestHandleForLogin.cancel();
          }
        });

      }
    });

  }

  @Override
  protected void onDestroy() {
    DebugLog.i(TAG, "onDestroy");
    super.onDestroy();
  }

  @Override
  protected void onPause() {
    DebugLog.i(TAG, "onPause");
    super.onPause();
    MobclickAgent.onPause(this);
  }

  @Override
  protected void onRestart() {
    DebugLog.i(TAG, "onRestart");
    super.onRestart();
  }

  @Override
  protected void onResume() {
    DebugLog.i(TAG, "onResume");
    super.onResume();
    
    //sdfsdf
    MobclickAgent.onResume(this);
  }

  @Override
  protected void onStart() {
    DebugLog.i(TAG, "onStart");
    super.onStart();
  }

  @Override
  protected void onStop() {
    DebugLog.i(TAG, "onStop");
    super.onStop();
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK) {
      return true;
    }
    return super.onKeyDown(keyCode, event);
  }

}
