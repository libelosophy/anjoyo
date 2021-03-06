package com.jh.andoriddemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SimpleAdapterDEMO extends Activity {

	private static final String NAME = "NAME";
	private static final String ICON = "ICON";
	private static final String BTN = "SUBMIT";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adapter_layout_all);
		
		Button btn = new Button(this);
		btn = (Button)findViewById(R.id.ok_Btn);
		
		// 
		ArrayList<Map<String,Object>>  data = new ArrayList<Map<String,Object>>();
		
		for(int i = 0; i < 20 ; i++){
			Map<String,Object > map = new HashMap<String, Object>();
			map.put(ICON, R.drawable.ic_launcher);
			map.put(NAME, "name " + i );
			map.put(BTN, btn);
			data.add(map);			
		}
		
		
		String[] from = {
				NAME,
				ICON,
				BTN				
		};
		int[] to = {
				R.id.name_Tv,
				R.id.icon_Iv,
				R.id.ok_Btn
		};
		
		// An easy adapter to map static data to views defined in an XML file
		SimpleAdapter adapter = new SimpleAdapter(this, 
				data,
				R.layout.activity_simple_adapter_demo,
				from, 
				to
				);
		ListView listView = new ListView(this);
		listView = (ListView)findViewById(R.id.listview);
		listView.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.simple_adapter_demo, menu);
		return true;
	}

}
