package com.jh.hello;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SayHello extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_say_hello);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.say_hello, menu);
		return true;
	}

}