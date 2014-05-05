package cn.lvyou.activity;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.retech.toolutils.SimpleBitmapTools;
import cn.retech.toolutils.ToolsFunctionForThisProgect;

public class SplashActivity extends Activity {

  private Timer timer = new Timer();
  private TimerTask timerTaskForGotoMainActivity = new TimerTask() {

    @Override
    public void run() {
      Intent intent = new Intent(SplashActivity.this, MainActivity.class);
      startActivity(intent);
      finish();
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    // TODO : 检测是否需要显示渠道icon和渠道名称
    // 渠道icon
    if (ToolsFunctionForThisProgect.hasChannelIcon()) {
      ImageView iv = (ImageView) findViewById(R.id.channel_icon_ImageView);
      iv.setImageBitmap(SimpleBitmapTools.getBitmapFromAssetsDirectory(ToolsFunctionForThisProgect.getUmengChannel() + ".png"));
      iv.setVisibility(View.VISIBLE);
    }
    // 渠道name
    ((TextView) findViewById(R.id.channel_name_TextView)).setText(ToolsFunctionForThisProgect.getChannelText());

    // 延迟一段时间后, 进入主界面
    timer.schedule(timerTaskForGotoMainActivity, 3 * 1000);
  }

}
