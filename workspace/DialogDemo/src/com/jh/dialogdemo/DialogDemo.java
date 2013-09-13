package com.jh.dialogdemo;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class DialogDemo extends Activity implements View.OnClickListener{
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog_demo);
	}



	@Override
	public void onClick(View v) {
		LayoutInflater inflater = this.getLayoutInflater();
		AlertDialog.Builder builder ;
		switch(v.getId()){
		case R.id.mydialog_trigger_btn:
			builder = new AlertDialog.Builder(this);
			builder.setView(inflater.inflate(R.layout.activity_dialog_demo, null));
			builder.setTitle("My Dialog")
			.setMessage("Hello \n My Dialog!")
			.setNeutralButton("Neutral", new OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Log.i("log","run to here dear");
					Toast.makeText(DialogDemo.this, "My Neutral Button Clicked", 5).show();
				}
			})
			.setNegativeButton("Negative", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(DialogDemo.this, "My Negative Button Clicked", 5).show();
				}
			})
			.setPositiveButton("Positive", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(DialogDemo.this, "My Positive Button Clicked", 5).show();
				}
			}).show();
			
			break;
			
		case R.id.dialog_trigger_btn:
			builder = new AlertDialog.Builder(DialogDemo.this);
			builder.setIcon(R.drawable.ic_launcher)
			.setTitle("Dialog")
			.setMessage("hello Dialog!")
			.setNeutralButton("Neutral", new OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Log.i("log","run to here dear");
					showMSG(DialogDemo.this, "Neutral Button Clicked");
				}
			})
			.setNegativeButton("Negative", new OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					showMSG(DialogDemo.this, "Negative Button Clicked");
				}
			})
			.setPositiveButton("Positive", new OnClickListener(){
				@Override
				public void onClick(DialogInterface dialog, int which) {
					showMSG(DialogDemo.this, "Positive Button Clicked");
				}
			}).show();
			break;
			
		case R.id.progress_trigger_btn:
			ProgressDialog pd = new ProgressDialog(this);
			pd.setCancelable(true);
			pd.setTitle("Downloading...");
			pd.setMessage("...");
			pd.setProgress(BIND_AUTO_CREATE);
			pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pd.setMax(100);
			pd.show();
			break;
			
		case R.id.datepick_trigger_btn:
			DatePickerDialog dpd = new DatePickerDialog(
					this,
					new OnDateSetListener() {
						
						@Override
						public void onDateSet(DatePicker view,
												int year,
												int monthOfYear,
												int dayOfMonth) {
							showMSG(DialogDemo.this, 
									"DateSetListener :" 
									+ year + "-" 
									+ monthOfYear + "-"
									+ dayOfMonth );
						}
					},
					//2007,
					Calendar.getInstance().get(Calendar.YEAR),
					1,
					8
					);
			dpd.show();
			break;
			
			
		default:
			
			break;
		}
	}
	
	private final static int MENU_GROUP_EDIT = 1;
	private static final int MENU_CUT_ID = 1;
	private static final int MENU_PASTE_ID = 2;
	
	private final static int MENU_GROUP_SYS = 2 ;
	private static final int MENU_GO_ID = 1;
	private static final int MENU_BACK_ID = 2;
	
	private static final int MENU_GROUP_SUB = 3;
	private static final int SUBMENU_SUB1_ID = 2;
	private static final int SUBMENU_SUB2_ID = 3;
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dialog_demo, menu);
		
		menu.add(MENU_GROUP_EDIT, MENU_CUT_ID, Menu.NONE, "Cut");
		menu.add(MENU_GROUP_EDIT, MENU_PASTE_ID, Menu.NONE, "Paste");
		menu.add(MENU_GROUP_SYS, MENU_GO_ID, Menu.NONE, "GO");
		menu.add(MENU_GROUP_SYS, MENU_BACK_ID, Menu.NONE, "Back");
		SubMenu subMenu = menu.addSubMenu( "SubMenu");
		subMenu.add(MENU_GROUP_SUB,SUBMENU_SUB1_ID,Menu.NONE,"sub01");
		subMenu.add(MENU_GROUP_SUB,SUBMENU_SUB2_ID,Menu.NONE,"sub02");
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getGroupId()) {
		case MENU_GROUP_EDIT:
			switch (item.getItemId()) {
			case MENU_CUT_ID:
				showMSG(this,"Item cut clicked");
				break;
			case MENU_PASTE_ID:
				showMSG(this,"Item paste checked");
				break;
			default:
				break;
			}
		case MENU_GROUP_SYS:
			switch (item.getItemId()) {
			case MENU_GO_ID:
				showMSG(this,"Item \"GO\" clicked");
				break;

			case MENU_BACK_ID:
				showMSG(this,"Item \" BACK \" clicked");
				break;
			default:
				break;
			}
			break;
		case MENU_GROUP_SUB:
			showMSG(this, "submenu");
			switch (item.getItemId()) {
			case SUBMENU_SUB1_ID:
				showMSG(this, "submenu1 clicked");
				break;
			case SUBMENU_SUB2_ID:
				showMSG( this, "submenu2 clicked");
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	public void showMSG( Context context, String msg ){
		Toast.makeText( this, msg, Toast.LENGTH_SHORT).show();
	}

	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		return super.onMenuItemSelected(featureId, item);
	}
	
	

}
