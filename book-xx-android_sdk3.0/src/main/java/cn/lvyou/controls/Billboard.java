package cn.lvyou.controls;

import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import cn.lvyou.activity.R;
import cn.lvyou.controls.BannerLayout.OnCircleClickListener;
import cn.lvyou.controls.BannerLayout.OnItemClickListener;

import com.nostra13.universalimageloader.core.ImageLoader;

public class Billboard extends RelativeLayout {

	private Context mContext;
	private BannerLayout bannerLayout;
	private RingletChangeLight ringlet;
	private onBillboardClickListener onClickListener;

	public static enum ControlType {
		BUTTON, IMAGE_VIEW,
	}

	public Billboard(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
		initView();
	}

	private void initView() {

		final LayoutInflater inflater = LayoutInflater.from(mContext);
		View view = inflater.inflate(R.layout.billboard, this, true);

		bannerLayout = (BannerLayout) view.findViewById(R.id.bannerLayout);
		ringlet = (RingletChangeLight) view.findViewById(R.id.ringlet);

		/**
		 * 图片的点击回调类型(IMAGE_VIEW)
		 */
		bannerLayout.setOnItemClickListener(new OnItemClickListener() {
			// index 为当前滚动图片的标示
			@Override
			public void onClick(int index, View childview) {
				if (onClickListener != null) {
					onClickListener.onClickListener(index + "");
				}
			}
		});
		/**
		 * 小圆圈根据图片的角标显示
		 */
		bannerLayout.setOnCircleClickListener(new OnCircleClickListener() {

			@Override
			public void OnCircle(int index, View childview) {
				ringlet.setHightlightIndicator(index);
			}
		});
		bannerLayout.startScroll();// 应用启动时候广告牌的自动滚动
	}

	/**
	 * 用于控件的事件回调
	 * @author hesiming
	 * 
	 */
	public interface onBillboardClickListener {
		public void onClickListener(String id);

	}

	public void onBillboardClickListener(onBillboardClickListener onClickListener) {
		this.onClickListener = onClickListener;
	}

	/**
	 * 设置广告牌上显示的条目
	 * 
	 * @param billboards
	 */

	public void setbillboards(List<String> billboards) {
		ringlet.setIndicatorCount(billboards.size());
		ringlet.setHightlightIndicator(0);
		for (int i = 0; i < billboards.size(); i++) {
			ImageView imageView = new ImageView(mContext);
			ImageLoader.getInstance().displayImage(billboards.get(i), imageView);
			bannerLayout.addView(imageView);
		}

	}
}
