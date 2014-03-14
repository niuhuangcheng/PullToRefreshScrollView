package example;

import com.afeng0007.pulltorefreshscrollview.R;

import lib.PullToRefreshScrollView;
import android.app.Activity;
import android.os.Bundle;

public class ExamplePullToRefresh extends Activity{
	
	private PullToRefreshScrollView mScrollView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_examplepulltorefresh);
		mScrollView = (PullToRefreshScrollView) findViewById(R.id.activity_example_list);
	}
}
