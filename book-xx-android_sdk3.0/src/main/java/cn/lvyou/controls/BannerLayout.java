package cn.lvyou.controls;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

/**
 * 
 * @author hesiming
 * 
 */
public class BannerLayout extends ViewGroup {

	private Scroller scroller;
	private float mLastMotionX;

	private OnItemClickListener onItemClickListener;

	private int currentScreenIndex = 0;

	private boolean moving = false;

	private boolean autoScroll = false;

	private int scrollTime = 6 * 1000;

	private int currentWhat = 0;

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (autoScroll && currentWhat == msg.what) {
				if (getChildCount() != 0) {

					currentScreenIndex = (currentScreenIndex + 1) % getChildCount();
				}
				scrollToScreen(currentScreenIndex);

				if (autoScroll)
					handler.sendEmptyMessageDelayed(currentWhat, scrollTime);
			}
		}
	};
	private OnCircleClickListener OnCircleClickListener;

	public BannerLayout(Context context) {
		super(context);

		initView(context);
	}

	public BannerLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView(context);
	}

	public BannerLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	private void initView(final Context context) {
		this.scroller = new Scroller(context, new DecelerateInterpolator(1.1f));// OvershootInterpolator(1.1f)
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		int maxHeight = -1;

		final int count = getChildCount();
		for (int i = 0; i < count; i++) {
			getChildAt(i).measure(widthMeasureSpec, heightMeasureSpec);

			maxHeight = Math.max(maxHeight, getChildAt(i).getMeasuredHeight());

		}
		maxHeight = Math.min(maxHeight, MeasureSpec.getSize(heightMeasureSpec));

		// Log.e("TAG","onMeasure Height:"+maxHeight);

		setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), maxHeight);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

		final int count = getChildCount();

		int cLeft = 0;

		for (int i = 0; i < count; i++) {
			View child = getChildAt(i);
			if (child.getVisibility() == View.GONE)
				continue;

			child.setVisibility(View.VISIBLE);
			final int childWidth = child.getMeasuredWidth();
			child.layout(cLeft, 0, cLeft + childWidth, child.getMeasuredHeight());

			cLeft += childWidth;
		}
	}

	@Override
	public void computeScroll() {
		if (scroller.computeScrollOffset()) {
			scrollTo(scroller.getCurrX(), 0);
			postInvalidate();
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		if (getChildCount() == 0)
			return false;
		final int action = ev.getAction();
		final float x = ev.getX();
		switch (action) {
		case MotionEvent.ACTION_DOWN:

			autoScroll = false;

			currentWhat++;

			mLastMotionX = x;
			if (!scroller.isFinished()) {
				scroller.abortAnimation();
			}

			moving = false;
			// Log.i("TAG","ACTION_DOWN");

			return true;

		case MotionEvent.ACTION_MOVE:
			final int deltaX = (int) (mLastMotionX - x);
			boolean xMoved = Math.abs(deltaX) > 4;
			if (!moving && !xMoved)
				break;
			mLastMotionX = x;

			if ((0 == currentScreenIndex && deltaX < 0) || (getChildCount() - 1 == currentScreenIndex && deltaX > 0))
				scrollBy(deltaX / 4, 0);
			else
				scrollBy(deltaX * 2, 0);// 手动切图的灵敏度,x值越大速度越快.

			moving = true;

			{
				final int screenWidth = getWidth();
				currentScreenIndex = (getScrollX() + (screenWidth / 2)) / screenWidth;
			}

			return true;
		case MotionEvent.ACTION_UP:
			snapToDestination();

			if (!autoScroll) {
				startScroll();
			}
			if (!moving && null != onItemClickListener) {
				final int screenWidth = getWidth();
				int index = (int) ((getScrollX() + x) / screenWidth);
				onItemClickListener.onClick(index, getChildAt(index));
			}

			break;
		case MotionEvent.ACTION_CANCEL:
			snapToDestination();
			if (!autoScroll) {
				startScroll();
			}

		}
		return false;
	}

	private void scrollToScreen(int whichScreen) {
		if (whichScreen >= getChildCount())
			whichScreen = getChildCount() - 1;

		int delta = 0;

		delta = whichScreen * getWidth() - getScrollX();

		scroller.startScroll(getScrollX(), 0, delta, 0, 1500);
		invalidate();

		currentScreenIndex = whichScreen;
		// 小球跟着图片的indext变换
		OnCircleClickListener.OnCircle(currentScreenIndex, getChildAt(currentScreenIndex));
	}

	private void snapToDestination() {
		final int x = getScrollX();//
		final int screenWidth = getWidth();

		scrollToScreen((x + (screenWidth / 2)) / screenWidth);
	}

	public int getCurrentScreenIndex() {
		return currentScreenIndex;
	}

	public void startScroll() {

		autoScroll = true;
		handler.sendEmptyMessageDelayed(currentWhat, scrollTime);
	}

	public boolean isScrolling() {
		return autoScroll;
	}

	public void stopScroll() {
		autoScroll = false;
		currentWhat++;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		this.onItemClickListener = onItemClickListener;
	}

	public interface OnItemClickListener {
		public void onClick(int index, View childview);
	}

	public OnCircleClickListener getOnCircleClickListener() {
		return OnCircleClickListener;
	}

	public void setOnCircleClickListener(OnCircleClickListener OnCircleClickListener) {
		this.OnCircleClickListener = OnCircleClickListener;
	}

	public interface OnCircleClickListener {
		public void OnCircle(int index, View childview);
	}
}
