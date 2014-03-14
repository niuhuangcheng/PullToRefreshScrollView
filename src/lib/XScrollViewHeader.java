package lib;

import com.afeng0007.pulltorefreshscrollview.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class XScrollViewHeader extends RelativeLayout {

	public static final int STATE_NORMAL = 0;
	public static final int STATE_READY = 1;
	public static final int STATE_REFRESHING = 2;
	
	private RelativeLayout mContainer = null;
	private TextView	 mHintTextView = null;
	private TextView	 mlastUpdateTime = null;
	private ImageView	 mArrowImageView = null;
	private ProgressBar	 mProgressBar = null;
	private RotateAnimation mRotateUpAnimation = null;
	private RotateAnimation mRotateDownAnimation = null;
	private int			mState = STATE_NORMAL;
	
	
	
	public XScrollViewHeader(Context context) {
		super(context);
		initWithContext(context);
	}
	
	public XScrollViewHeader(Context context, AttributeSet attrs){
		super(context, attrs);
		initWithContext(context);
	}
	
	public XScrollViewHeader(Context context, AttributeSet attrs, int defstyle){
		super(context, attrs, defstyle);
		initWithContext(context);
	}
	
	private void initWithContext(Context context){
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 0);
		mContainer = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.view_xscrollviewheader, null);
		addView(mContainer, params);
		setGravity(Gravity.BOTTOM);
		
		mlastUpdateTime = (TextView) findViewById(R.id.view_xscrollheader_updatetime);
		mArrowImageView = (ImageView) findViewById(R.id.view_xscrollviewheader_image);
		mProgressBar = (ProgressBar) findViewById(R.id.view_xscrollviewheader_progress);
		
		mRotateUpAnimation = new RotateAnimation(0.0f, 180.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

		mRotateUpAnimation.setDuration(360);
		mRotateUpAnimation.setFillAfter(true);
		mRotateDownAnimation =  new RotateAnimation(-180f, 0.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		
		mRotateDownAnimation.setDuration(360);
		mRotateDownAnimation.setFillAfter(true);
	}
	
	/**
	* @Title: setState
	* @Description: set state: normal, refresh, ready
	* @param @param state
	* @return void
	* @throws
	*/
	public void setState(int state){
		if (mState == state)
			return;
		if (state == STATE_REFRESHING){
			mArrowImageView.clearAnimation();
			mArrowImageView.setVisibility(View.INVISIBLE);
			mProgressBar.setVisibility(VISIBLE);
		}else{
			mArrowImageView.setVisibility(View.VISIBLE);;
			mProgressBar.setVisibility(INVISIBLE);
		}
		switch (state) {
		case STATE_NORMAL:
			if (mState == STATE_READY){
				mArrowImageView.startAnimation(mRotateDownAnimation);
			}
			
			if (mState == STATE_REFRESHING){
				mArrowImageView.clearAnimation();
			}
			mHintTextView.setText("松开刷新数据...");
			break;
		case STATE_READY:
			mArrowImageView.clearAnimation();
			mArrowImageView.startAnimation(mRotateUpAnimation);
			mHintTextView.setText("数据加载完成");
			break;
		case STATE_REFRESHING:
			mHintTextView.setText("正在加载...");
			break;
		default:
			break;
		}
	}
	
	/**
	* @Title: setVisiableHeight
	* @Description: set visiable height
	* @param @param height
	* @return void
	* @throws
	*/
	public void setVisiableHeight(int height){
		if (height < 0){
			height = 0;
		}
		RelativeLayout.LayoutParams lParams = (android.widget.RelativeLayout.LayoutParams) mContainer.getLayoutParams();
		lParams.height = height;
		mContainer.setLayoutParams(lParams);
	}
	
	/**
	* @Title: getVisiableHeight
	* @Description: get header visiable height
	* @param @return
	* @return int
	* @throws
	*/
	public int getVisiableHeight(){
		return mContainer.getHeight();
	}
	
	/**
	* @Title: setUpdateTime
	* @Description: set the update time
	* @param @param strupdateTime
	* @return void
	* @throws
	*/
	public void setUpdateTime(String strupdateTime){
		mlastUpdateTime.setText(strupdateTime);
	}
}
