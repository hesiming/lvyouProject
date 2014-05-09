package cn.lvyou.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import cn.lvyou.domainbean_model.login.LoginNetRequestBean;
import cn.lvyou.domainbean_model.login.LoginNetRespondBean;
import cn.lvyou.domainbean_model.register.RegisterNetRequestBean;
import cn.lvyou.domainbean_model.register.RegisterNetRespondBean;
import cn.lvyou.my_network_engine.IDomainBeanAsyncHttpResponseListenerWithUIControl;
import cn.lvyou.my_network_engine.INetRequestHandle;
import cn.lvyou.my_network_engine.NetRequestHandleNilObject;
import cn.lvyou.my_network_engine.SimpleNetworkEngineSingleton;
import cn.lvyou.my_network_engine.SimpleNetworkEngineSingleton.NetRequestResultEnum;
import cn.lvyou.my_network_engine.net_error_handle.MyNetRequestErrorBean;
import cn.lvyou.toolutils.SimpleProgressDialog;

public class RegisterActivity extends Activity {
  private final String TAG = this.getClass().getSimpleName();
  private INetRequestHandle netRequestHandleForLogin = new NetRequestHandleNilObject();
  private INetRequestHandle netRequestHandleForRegister = new NetRequestHandleNilObject();

  private EditText emailEditText;
  private EditText usernameEditText;
  private EditText passwordEditText;
  private View registerButton;
  private ProgressBar registerLoadingProgressBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_register);

    emailEditText = (EditText) findViewById(R.id.mail_EditText);
    usernameEditText = (EditText) findViewById(R.id.username_EditText);
    passwordEditText = (EditText) findViewById(R.id.password_EditText);

    registerButton = findViewById(R.id.register_Button);
    registerButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        String errorMessage = "";
        final String email = emailEditText.getText().toString().trim();
        final String username = usernameEditText.getText().toString().trim();
        final String password = passwordEditText.getText().toString().trim();
        do {
          if (TextUtils.isEmpty(email)) {
            errorMessage = "请输入您的常用邮箱";
            break;
          }
          if (TextUtils.isEmpty(username)) {
            errorMessage = "请输入您要显示的用户名";
            break;
          }
          if (TextUtils.isEmpty(password)) {
            errorMessage = "请输入密码（不少于6位）";
            break;
          }
          if (username.length() < 6) {
            errorMessage = "帐号不能小于6位";
            break;
          }
          if (password.length() < 6) {
            errorMessage = "密码不能小于6位";
            break;
          }
          requestRegister(email, username, password);
          return;
        } while (false);

        Toast.makeText(RegisterActivity.this, errorMessage, Toast.LENGTH_SHORT).show();

      }
    });

    registerLoadingProgressBar = (ProgressBar) findViewById(R.id.register_loading_ProgressBar);
  }

  private void requestRegister(final String email, final String username, final String password) {
    RegisterNetRequestBean netRequestBean = new RegisterNetRequestBean(email, username, password);
    netRequestHandleForLogin = SimpleNetworkEngineSingleton.getInstance.requestDomainBean(netRequestBean, new IDomainBeanAsyncHttpResponseListenerWithUIControl() {

      @Override
      public void onSuccess(Object respondDomainBean) {
        RegisterNetRespondBean registerNetRespondBean = (RegisterNetRespondBean) respondDomainBean;
        Toast.makeText(RegisterActivity.this, "注册成功, 自动登录中...", Toast.LENGTH_SHORT).show();
        requestLogin(username, password);
      }

      @Override
      public void onFailure(MyNetRequestErrorBean error) {
        Toast.makeText(RegisterActivity.this, "注册失败-->" + error.toString(), Toast.LENGTH_SHORT).show();

      }

      @Override
      public void onEnd(final NetRequestResultEnum resultEnum) {
        SimpleProgressDialog.dismiss(RegisterActivity.this);
      }

      @Override
      public void onBegin() {
        SimpleProgressDialog.show(RegisterActivity.this, new DialogInterface.OnCancelListener() {

          @Override
          public void onCancel(DialogInterface dialog) {
            // 用户取消了本次网络请求
            netRequestHandleForRegister.cancel();
          }
        });

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

  private void requestLogin(final String username, final String password) {
    LoginNetRequestBean netRequestBean = new LoginNetRequestBean.Builder(username, password).builder();
    netRequestHandleForLogin = SimpleNetworkEngineSingleton.getInstance.requestDomainBean(netRequestBean, new IDomainBeanAsyncHttpResponseListenerWithUIControl() {

      @Override
      public void onSuccess(Object respondDomainBean) {
        LoginNetRespondBean loginNetRespondBean = (LoginNetRespondBean) respondDomainBean;

        Toast.makeText(RegisterActivity.this, "注册成功，已登录", Toast.LENGTH_SHORT).show();
        // GlobalDataCacheForMemorySingleton.getInstance.noteSignInSuccessfulInfo(loginNetRespondBean,
        // username, password);

        finishWithLoginBeenSuccessfully();
      }

      @Override
      public void onFailure(MyNetRequestErrorBean error) {
        Toast.makeText(RegisterActivity.this, "登录失败-->" + error.toString(), Toast.LENGTH_SHORT).show();
        finish();
      }

      @Override
      public void onEnd(final NetRequestResultEnum resultEnum) {
        SimpleProgressDialog.dismiss(RegisterActivity.this);
      }

      @Override
      public void onBegin() {
        SimpleProgressDialog.show(RegisterActivity.this, new DialogInterface.OnCancelListener() {

          @Override
          public void onCancel(DialogInterface dialog) {
            // 用户取消了本次网络请求
            netRequestHandleForLogin.cancel();
            finish();
          }
        });

      }
    });

  }

}
