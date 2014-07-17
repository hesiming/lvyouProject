package cn.lvyou.activity;

import android.app.Activity;
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
import cn.lvyou.ioc_view.ViewUtils;
import cn.lvyou.ioc_view.annotation.ViewInject;
import cn.lvyou.ioc_view.annotation.event.OnClick;
import cn.lvyou.my_network_engine.IDomainBeanAsyncHttpResponseListenerWithUIControl;
import cn.lvyou.my_network_engine.INetRequestHandle;
import cn.lvyou.my_network_engine.NetRequestHandleNilObject;
import cn.lvyou.my_network_engine.SimpleNetworkEngineSingleton;
import cn.lvyou.my_network_engine.net_error_handle.MyNetRequestErrorBean;
import cn.lvyou.toolutils.DebugLog;

public class LoginActivity extends Activity {
  private final String TAG = this.getClass().getSimpleName();

  private static enum IntentRequestCodeEnum {
    TO_REGISTER_ACTIVITY
  };

  private INetRequestHandle netRequestHandleForLogin = new NetRequestHandleNilObject();

  @ViewInject(R.id.qiongyou_account_username)
  private EditText qiongyouAccountUsername;

  @ViewInject(R.id.qiongyou_account_password)
  private EditText qiongyouAccountPassword;

  @ViewInject(R.id.login_Button)
  private View loginButton;

  @ViewInject(R.id.register_Button)
  private View registerButton;

  @ViewInject(R.id.login_loading_ProgressBar)
  private ProgressBar loginLoadingProgressBar;

  @ViewInject(R.id.sina_twitter_login_Button)
  private Button sinaTwitterLoginButton;

  @ViewInject(R.id.qq_login_Button)
  private Button qqLoginButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    ViewUtils.inject(this);

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

    if (netRequestHandleForLogin != null) {
      netRequestHandleForLogin.cancel();
    }
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

  @OnClick(R.id.login_Button)
  public void loginButtonOnClick(View v) {
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

  @OnClick(R.id.register_Button)
  public void registerButtonOnClick(View v) {
    gotoRegisterActivity();
  }

  @OnClick(R.id.sina_twitter_login_Button)
  public void sinaTwitterLoginButtonOnClick(View v) {
    // TODO 新浪微博登录

  }

  @OnClick(R.id.qq_login_Button)
  public void qqLoginButtonOnClick(View v) {
    // TODO QQ账号登录

  }

  /**
   * 控制登录按钮是否可用(不能重复发起登录请求)
   * 
   * @param enabled
   */
  private void enableLoginButton(boolean enabled) {
    if (enabled) {
      loginLoadingProgressBar.setVisibility(View.INVISIBLE);
      loginButton.setEnabled(true);
    } else {
      loginLoadingProgressBar.setVisibility(View.VISIBLE);
      loginButton.setEnabled(false);
    }
  }

  private void requestLogin(final String username, final String password) {
    LoginNetRequestBean netRequestBean = new LoginNetRequestBean.Builder(username, password).builder();
    netRequestHandleForLogin = SimpleNetworkEngineSingleton.getInstance.requestDomainBean(netRequestBean, new IDomainBeanAsyncHttpResponseListenerWithUIControl() {

      @Override
      public void onSuccess(Object respondDomainBean) {
        LoginNetRespondBean loginNetRespondBean = (LoginNetRespondBean) respondDomainBean;

        GlobalDataCacheForMemorySingleton.getInstance.noteSignInSuccessfulInfo(loginNetRespondBean, username, password);

        finishWithLoginBeenSuccessfully();
      }

      @Override
      public void onFailure(MyNetRequestErrorBean error) {
        Toast.makeText(LoginActivity.this, "登录失败-->" + error.toString(), Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onEnd() {
        enableLoginButton(true);
      }

      @Override
      public void onBegin() {
        enableLoginButton(false);
      }
    });
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
