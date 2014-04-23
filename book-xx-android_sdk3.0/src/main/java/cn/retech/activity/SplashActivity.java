package cn.retech.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends Activity {

  private static int START_ACT_MAIN = 1;

  private Handler handler = new Handler() {
    public void handleMessage(android.os.Message msg) {
      if (msg.what == START_ACT_MAIN) {
        //startMainTabsActivity();
        finish();
      }
    };
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//    setContentView(R.layout.activity_splash);
//
//    handler.sendEmptyMessageDelayed(START_ACT_MAIN, 1000);
//
//    if (QyerApplication.hasChannelIcon()) {
//      ImageView iv = (ImageView) findViewById(R.id.imageView1);
//      iv.setImageBitmap(getImageFromAssetsFile(QyerApplication.getChannelName() + ".png"));
//      iv.setVisibility(View.VISIBLE);
//    }
//
//    ((TextView) findViewById(R.id.textView1)).setText(QyerApplication.getChannelText());
  }

//  private void startMainTabsActivity() {
//    Intent intent = MainActivity.newInstance(this, MainActivity.FRAGMENT_MAIN_DEAL);
//    startActivity(intent);
//  }

}
