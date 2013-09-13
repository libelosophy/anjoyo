package com.jh.sharepreferencedemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class SharePreferenceDemo extends Activity {

	public static final String PREFS_NAME = "pref_info";
	public static final String NAME = "name";
	public static final String PASSWD = "passwd";
	private TextView showText;
	private EditText userNameEt, passwdEt;
	private Button writeInBtn, readOutBtn;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_share_preference_demo);
	
		showText =(TextView) findViewById(R.id.info);
		userNameEt = (EditText) findViewById(R.id.username);
		passwdEt = (EditText) findViewById(R.id.passwd);
		writeInBtn = (Button) findViewById(R.id.writein_btn);
		readOutBtn = (Button) findViewById(R.id.readout_btn);
		
	
		final SharedPreferences sp = getSharedPreferences(PREFS_NAME, 0);
		
		final SharedPreferences.Editor editor = sp.edit();
		writeInBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name = null , passwd = null; 
				boolean isNameEmpty = userNameEt.getText().toString().trim().equals("");
				boolean	isPasswdEmpty = passwdEt.getText().toString().trim().equals("");
				if(! isNameEmpty && ! isPasswdEmpty ){
					name = userNameEt.getText().toString();
					passwd = passwdEt.getText().toString();
					showMSG(NAME + " " + name + " " + PASSWD + passwd);
					editor.putString(NAME, name).putString(PASSWD, passwd);
					editor.commit();
					
				}else{
					showMSG("Please input info");
				}
			}
		});
			
		readOutBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name = null , passwd = null; 
				name = sp.getString(NAME, "null");
				passwd = sp.getString(PASSWD, "null");
				showText.setText("user: " + name + ", passwd: " + passwd);
			}
		});
	}
	
	
	public void showMSG(String msg) {
		Toast.makeText(SharePreferenceDemo.this,
				msg, 
				Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.share_preference_demo, menu);
		return true;
	}

}
