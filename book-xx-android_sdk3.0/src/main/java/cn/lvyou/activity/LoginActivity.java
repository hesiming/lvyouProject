package cn.lvyou.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import cn.lvyou.domainbean_model.login.LoginNetRequestBean;
import cn.lvyou.domainbean_model.login.LoginNetRespondBean;
import cn.lvyou.my_network_engine.IDomainBeanAsyncHttpResponseListenerWithUIControl;
import cn.lvyou.my_network_engine.INetRequestHandle;
import cn.lvyou.my_network_engine.NetRequestHandleNilObject;
import cn.lvyou.my_network_engine.SimpleNetworkEngineSingleton;
import cn.lvyou.my_network_engine.SimpleNetworkEngineSingleton.NetRequestResultEnum;
import cn.lvyou.my_network_engine.net_error_handle.MyNetRequestErrorBean;
import cn.lvyou.toolutils.DebugLog;
import cn.lvyou.toolutils.SimpleProgressDialog;

public class LoginActivity extends Activity {
  private final String TAG = this.getClass().getSimpleName();
  private INetRequestHandle netRequestHandleForLogin = new NetRequestHandleNilObject();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_login);

     
  }

  private void requestLogin(final String username, final String password) {
    LoginNetRequestBean netRequestBean = new LoginNetRequestBean.Builder(username, password).builder();
    netRequestHandleForLogin = SimpleNetworkEngineSingleton.getInstance.requestDomainBean(netRequestBean, new IDomainBeanAsyncHttpResponseListenerWithUIControl() {

      @Override
      public void onSuccess(Object respondDomainBean) {
        LoginNetRespondBean loginNetRespondBean = (LoginNetRespondBean) respondDomainBean;

        Toast.makeText(LoginActivity.this, "登录成功-->" + loginNetRespondBean.toString(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

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

}
