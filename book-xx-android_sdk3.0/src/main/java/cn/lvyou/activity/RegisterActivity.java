package cn.lvyou.activity;

import android.app.Activity;
import android.os.Bundle;
import cn.lvyou.my_network_engine.INetRequestHandle;
import cn.lvyou.my_network_engine.NetRequestHandleNilObject;

public class RegisterActivity extends Activity {
  private final String TAG = this.getClass().getSimpleName();
  private INetRequestHandle netRequestHandleForLogin = new NetRequestHandleNilObject();
  private INetRequestHandle netRequestHandleForRegister = new NetRequestHandleNilObject();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_register);

  }
}
