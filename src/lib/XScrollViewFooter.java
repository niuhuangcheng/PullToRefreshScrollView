package lib;

import com.afeng0007.pulltorefreshscrollview.R;

import android.R.integer;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class XScrollViewFooter extends RelativeLayout{

	public final static int STATE_NORMAL = 0;
	public final static int STATE_READY = 1;
	public final static int STATE_LOADING = 2;
	
	private RelativeLayout mContainer = null;
	
	public XScrollViewFooter(Context context) {
		super(context);
		initView(context);
	}
	
	public XScrollViewFooter(Context context, AttributeSet attrs){
		super(context, attrs);
		initView(context);
	}
	
	public XScrollViewFooter(Context context, AttributeSet attrs, int defstyle){
		super(context, attrs, defstyle);
		initView(context);
	}
	
	private void initView(Context context){
		RelativeLayout.LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, 0);
		mContainer = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.view_xscrollviewfooter, null);
		
		addView(mContainer, lp);
		setGravity(Gravity.TOP);
		
		
	}
}
