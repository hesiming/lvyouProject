package cn.lvyou.controls;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.lvyou.activity.R;

public class RingletChangeLight extends LinearLayout {
	private int lightTotalNumber;
	private int iconImageID = R.drawable.buy_radio;
	private int iconFocusImageID = R.drawable.buy_radio_b;

	public RingletChangeLight(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setIndicatorCount(int count) {
		this.lightTotalNumber = count;

		Context context = getContext();

		for (int i = 0; i < count; i++) {
			ImageView v = new ImageView(context);
			LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
			layout.setMargins(10, 0, 0, 0);
			v.setLayoutParams(layout);
			addView(v);
		}
	}

	public void setIndicatorImage(int iconImage, int iconFocusImage) {
		iconImageID = iconImage;
		iconFocusImageID = iconFocusImage;
	}

	public void setHightlightIndicator(int index) {
		for (int i = 0; i < lightTotalNumber; i++) {
			ImageView indicatorImageView = (ImageView) getChildAt(i);
			indicatorImageView.setImageResource((i == index) ? iconFocusImageID : iconImageID);
		}
	}
}
