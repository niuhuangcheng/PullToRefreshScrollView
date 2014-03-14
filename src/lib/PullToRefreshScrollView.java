package lib;

import android.R.integer;
import android.R.interpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.widget.ScrollView;
import android.widget.Scroller;

public class PullToRefreshScrollView extends ScrollView{
	
	
	private Scroller mScroller = null;
	private AccelerateInterpolator mInterpolator = null;
	
	public PullToRefreshScrollView(Context context){
		super(context);
		initWithContext(context);
	}
	
	public PullToRefreshScrollView(Context context, AttributeSet attrs){
		super(context, attrs);
		initWithContext(context);
	}
	
	public PullToRefreshScrollView(Context context, AttributeSet attrs, int defStyle){
		super(context, attrs, defStyle);
		initWithContext(context);
	}

	private void initWithContext(Context context){
		mInterpolator = new AccelerateInterpolator();
		mScroller = new Scroller(context, mInterpolator);
	}
	
	
}
