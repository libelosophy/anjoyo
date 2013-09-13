package com.jh.androiddemo;

import android.app.Activity;
import android.content.Intent;
import android.drm.DrmStore.Action;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class SayHello extends Activity  {

	static final String TAG_TEST = "Activity";
	static final int RETURN_CODE = 2 ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent_demo);
		Log.i(TAG_TEST, "SayHello onCreate");
		
		// 被调用者返回数据 
		Intent intent = new Intent();
		intent.setData(Uri.parse("http://www.baidu.com"));
		setResult(RESULT_OK, intent); //设置返回码， 有三个常量
		
	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.intent_demo, menu);
		return true;
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(TAG_TEST, "SayHello onStart");
	}
	
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i(TAG_TEST, "SayHello onRestart");
	}
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(TAG_TEST, "SayHello onPause");
	}
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG_TEST, "SayHello onResume");
	}
	
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(TAG_TEST, "Lanucher onStop");
	}
	
	
	// 
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG_TEST, "SayHello onDestroy");
		finish();
	}



}
