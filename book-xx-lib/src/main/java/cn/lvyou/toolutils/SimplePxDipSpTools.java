package cn.lvyou.toolutils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import cn.lvyou.global_data_cache.GlobalDataCacheForMemorySingleton;

public final class SimplePxDipSpTools {

  private SimplePxDipSpTools() {
  }

  /**
   * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
   */
  public static int dipToPx(float dpValue) {
    final float scale = GlobalDataCacheForMemorySingleton.getInstance.getApplication().getResources().getDisplayMetrics().density;
    return (int) (dpValue * scale + 0.5f);
  }

  /**
   * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
   */
  public static int pxToDip(float pxValue) {
    final float scale = GlobalDataCacheForMemorySingleton.getInstance.getApplication().getResources().getDisplayMetrics().density;
    return (int) (pxValue / scale + 0.5f);
  }

  /**
   * 获取当前分辨率下指定单位对应的像素大小（根据设备信息） px,dip,sp -> px
   * 
   * Paint.setTextSize()单位为px
   * 
   * 代码摘自：TextView.setTextSize()
   * 
   * @param unit
   *          TypedValue.COMPLEX_UNIT_*
   * @param size
   * @return
   */
  public static float getRawSize(int unit, float size) {
    Context c = GlobalDataCacheForMemorySingleton.getInstance.getApplication();
    Resources r;

    if (c == null)
      r = Resources.getSystem();
    else
      r = c.getResources();

    return TypedValue.applyDimension(unit, size, r.getDisplayMetrics());
  }
}
