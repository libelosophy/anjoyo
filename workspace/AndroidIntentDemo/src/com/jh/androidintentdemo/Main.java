package com.jh.androidintentdemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class Main extends Activity {

	final static String ACTION_DEMO = "android.intent.action.DEMO";
	final static String CATEGORY_DEMO = "android.intent.category.DEMO";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public void startSecondActivity(View v) {
		
		Intent intent = new Intent();
		/*ComponentName component = new ComponentName(this, SecondActivity.class);
		intent.setComponent(component);*/
		intent.setAction(ACTION_DEMO);
		intent.addCategory(CATEGORY_DEMO);
		startActivity(intent);
		
	}
}
