package cn.lvyou.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import cn.lvyou.domainbean_model.login.LoginNetRequestBean;
import cn.lvyou.domainbean_model.login.LoginNetRespondBean;
import cn.lvyou.global_data_cache.GlobalDataCacheForMemorySingleton;
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

  private static enum IntentRequestCodeEnum {
    TO_REGISTER_ACTIVITY
  };

  private INetRequestHandle netRequestHandleForLogin = new NetRequestHandleNilObject();

  private EditText qiongyouAccountUsername;
  private EditText qiongyouAccountPassword;
  private View loginButton, registerButton;
  private ProgressBar loginProgressBar;
  private Button sinaTwitterLoginButton, qqLoginButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_login);

    qiongyouAccountUsername = (EditText) findViewById(R.id.qiongyou_account_username);
    qiongyouAccountPassword = (EditText) findViewById(R.id.qiongyou_account_password);
    loginButton = findViewById(R.id.login_Button);
    loginButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        String errorMessage = "";
        final String username = qiongyouAccountUsername.getText().toString().trim();
        final String password = qiongyouAccountPassword.getText().toString().trim();
        do {
          if (TextUtils.isEmpty(username)) {
            errorMessage = "用户名不能为空";
            break;
          }
          if (TextUtils.isEmpty(password)) {
            errorMessage = "密码不能为空";
            break;
          }

          requestLogin(username, password);
          return;
        } while (false);

        Toast.makeText(LoginActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
      }
    });
    registerButton = findViewById(R.id.register_Button);
    registerButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        gotoRegisterActivity();
      }

    });
    loginProgressBar = (ProgressBar) findViewById(R.id.login_ProgressBar);
    sinaTwitterLoginButton = (Button) findViewById(R.id.sina_twitter_login_Button);
    sinaTwitterLoginButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        // TODO Auto-generated method stub

      }
    });
    qqLoginButton = (Button) findViewById(R.id.qq_login_Button);
    qqLoginButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        // TODO Auto-generated method stub

      }
    });
  }

  private void requestLogin(final String username, final String password) {
    LoginNetRequestBean netRequestBean = new LoginNetRequestBean.Builder(username, password).builder();
    netRequestHandleForLogin = SimpleNetworkEngineSingleton.getInstance.requestDomainBean(netRequestBean, new IDomainBeanAsyncHttpResponseListenerWithUIControl() {

      @Override
      public void onSuccess(Object respondDomainBean) {
        LoginNetRespondBean loginNetRespondBean = (LoginNetRespondBean) respondDomainBean;

        //GlobalDataCacheForMemorySingleton.getInstance.noteSignInSuccessfulInfo(loginNetRespondBean, username, password);

        finishWithLoginBeenSuccessfully();
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

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    DebugLog.i(TAG, "onActivityResult");

    if (requestCode == IntentRequestCodeEnum.TO_REGISTER_ACTIVITY.ordinal()) {
      if (resultCode == Activity.RESULT_OK) {
        // 注册成功, 登录成功, 返回上层界面
        finishWithLoginBeenSuccessfully();
      }
    }
  }

  /**
   * 在登录已成功的状态下, 返回上层界面
   */
  private void finishWithLoginBeenSuccessfully() {
    setResult(Activity.RESULT_OK);
    finish();
  }

  private void gotoRegisterActivity() {
    Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
    startActivityForResult(intent, IntentRequestCodeEnum.TO_REGISTER_ACTIVITY.ordinal());
  }
}
