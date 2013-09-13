package com.jh.andoriddemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class Demo extends Activity implements OnClickListener {

	final static String ACTION_DEMO = "android.intent.action.DEMO";
	final static String CATEGORY_DEMO = "android.intent.category.DEMO";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.demo, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		Intent intent = new Intent();
		/*ComponentName component = new ComponentName(this, SecondActivity.class);
		intent.setComponent(component);*/
		intent.setAction(ACTION_DEMO);
//		intent.addCategory(CATEGORY_DEMO);
		
		Intent.createChooser(intent, "dialogTitle");
		startActivity(intent);
	}

}
