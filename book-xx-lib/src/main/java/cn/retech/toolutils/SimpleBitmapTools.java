package cn.retech.toolutils;

import java.io.IOException;
import java.io.InputStream;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import cn.retech.global_data_cache.GlobalDataCacheForMemorySingleton;

public final class SimpleBitmapTools {
  private SimpleBitmapTools() {

  }

  public static Bitmap zoomBitmap(Bitmap srcBitmap, float destWidth, float destHeigth) {
    if (srcBitmap == null || destWidth <= 0 || destWidth >= Float.MAX_VALUE || destHeigth <= 0 || destHeigth >= Float.MAX_VALUE) {
      return null;
    }

    int w = srcBitmap.getWidth();// 源文件的大小
    int h = srcBitmap.getHeight();
    // calculate the scale - in this case = 0.4f
    float scaleWidth = destWidth / w;// 宽度缩小比例
    float scaleHeight = destHeigth / h;// 高度缩小比例
    Matrix matrix = new Matrix();// 矩阵
    matrix.postScale(scaleWidth, scaleHeight);// 设置矩阵比例
    Bitmap newBitmap = Bitmap.createBitmap(srcBitmap, 0, 0, w, h, matrix, true);// 直接按照矩阵的比例把源文件画入进行
    return newBitmap;
  }

  /**
   * 从Assets目录中读取图片
   * 
   * @param fileName
   * @return
   */
  public static Bitmap getBitmapFromAssetsDirectory(String fileName) {
    Bitmap image = null;
    AssetManager am = GlobalDataCacheForMemorySingleton.getInstance.getApplication().getResources().getAssets();
    try {
      InputStream is = am.open(fileName);
      image = BitmapFactory.decodeStream(is);
      is.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return image;

  }
}
