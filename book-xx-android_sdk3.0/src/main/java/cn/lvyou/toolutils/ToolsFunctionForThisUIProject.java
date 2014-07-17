package cn.lvyou.toolutils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import cn.lvyou.activity.MyApplication;
import cn.lvyou.activity.PreLoadedDataService;

public final class ToolsFunctionForThisUIProject {

  public ToolsFunctionForThisUIProject() {
    // TODO Auto-generated constructor stub
  }

  private static synchronized void stopServiceWithThisApp() {

    Intent intent = new Intent(MyApplication.getApplication(), PreLoadedDataService.class);
    MyApplication.getApplication().stopService(intent);
  }

  public static synchronized void showDialogForQuiteApp(final Activity activity) {
    AlertDialog.Builder builder = new Builder(activity);
    builder.setTitle("提示");
    builder.setMessage("是否退出应用");
    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        dialog.cancel();

        // 暂停当前app自己创建的所有服务
        stopServiceWithThisApp();
        // 退出应用
        ToolsFunctionForThisProgect.quitApp(activity);
      }
    });
    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        dialog.cancel();
      }
    });
    AlertDialog dialog = builder.create();
    dialog.show();
  }

}
