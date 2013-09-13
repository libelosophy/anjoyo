package com.jh.tablehost;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost;
import android.widget.Toast;

public class TableHostDemo extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_table_host_demo);
		
		
		TabHost tabhost = (TabHost)findViewById(android.R.id.tabhost);
		tabhost.setup();
		
		tabhost.addTab(tabhost.newTabSpec("Tab 1")
				.setIndicator("indicator 1")
				.setContent(R.id.tab1));
		
		tabhost.addTab(tabhost.newTabSpec("Tab 2")
				.setIndicator("indicator 2")
				.setContent(R.id.tab2));
		
		tabhost.addTab(tabhost.newTabSpec("Tab 3")
				.setIndicator("indicator 3")
				.setContent(R.id.tab3));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.table_host_demo, menu);
		return true;
	}

	@SuppressLint("ShowToast")
	@Override
	public void onClick(View v) {
		Toast.makeText(this, "Hello tabhost", Toast.LENGTH_SHORT).show();
	}
	

}
