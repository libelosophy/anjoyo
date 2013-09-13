package com.jh.androiddemo;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;

public class InnerIntentDemo extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_inner_intent_demo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inner_intent_demo, menu);
		return true;
	}
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
         
		switch(v.getId()){
		case R.id.call :
			 intent.setAction(Intent.ACTION_CALL);
			 intent.setData(Uri.parse("tel:5556"));
			 break;
			 
		case R.id.dail:
			intent.setAction(Intent.ACTION_CALL);
			 intent.setData(Uri.parse("tel:5556"));
			 break;
			 
		case R.id.http:
			 intent.setAction(Intent.ACTION_VIEW);
			 intent.setData(Uri.parse("http://www.baidu.com"));
			 break;
			 
		case R.id.image:
			 intent.setAction(Intent.ACTION_VIEW);
			 intent.setData(Uri.parse("http://h.hiphotos.baidu.com/album/h%3D900%3Bcrop%3D0%2C0%2C1440%2C900/sign=2225e4ef3bf33a87816d0c1af667734a/f7246b600c3387441ce448a3500fd9f9d62aa0c8.jpg"));
			 break;
			 
		case R.id.mail:
			intent.setAction(Intent.ACTION_SENDTO);
			 intent.setData(Uri.parse("mailto:j.ghang@hotmail.com"));
			 break;
			 
		case R.id.sms:
			intent.setAction(Intent.ACTION_SENDTO);
			intent.setData(Uri.parse("smsto:5556"));
			break;
			
		default:	
			break;
		}
		startActivity(intent);

	}

}
