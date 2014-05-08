package cn.lvyou.controls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.lvyou.activity.R;

public class TitleBar extends LinearLayout {
  private TextView titleTextView;

  public TitleBar(Context context) {
    super(context);
  }

  public TitleBar(Context context, AttributeSet attrs) {
    super(context, attrs);

    LayoutInflater mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    mInflater.inflate(R.layout.control_title_bar, this, true);

  }

  public void setTitleByString(int resid) {
    titleTextView.setBackgroundDrawable(null);
    titleTextView.setText(resid);
  }

  public void setTitleByString(String titleNameString) {
    titleTextView.setBackgroundDrawable(null);
    titleTextView.setText(titleNameString);
  }

  public void setTitleByImage(int resid) {
    titleTextView.setText("");
    titleTextView.setBackgroundResource(resid);
  }
}
