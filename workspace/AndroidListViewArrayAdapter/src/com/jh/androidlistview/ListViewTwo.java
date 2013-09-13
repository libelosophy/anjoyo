package com.jh.androidlistview;


import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewTwo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);
        
        List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("hello");
		list.add("hello");
		
		ListView listView = new ListView(this);
		listView = (ListView)findViewById(R.id.listview);

		
		// 1. 三个参数的构造参数
		//	  resource layout 布局文件里 只有一个单独的 TextView
		// 2. 四个参数的构造参数可以显示更加多的内容，但是 只能够设置 TextView 的内容
		//	  第二个参数指定layout，这个布局里可以有其他的控件，再通过第三个参数指定 
		//	  该布局（？ 或者其他布局的）TextView
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this,
//				android.R.layout.simple_list_item_1,  
				R.layout.activity_list_view_two,
				R.id.text,  // 
				list
				);
		listView.setAdapter(adapter);
		registerForContextMenu(listView);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_view_two, menu);
        return true;
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
    		ContextMenuInfo menuInfo) {
    	// TODO Auto-generated method stub
    	menu.add(0, 1, 0, "显示一条通知");
    	menu.add(0, 2, 0, "Title2");
    	super.onCreateContextMenu(menu, v, menuInfo);
    }
    
    @SuppressLint("NewApi")
	@Override
    public boolean onContextItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	switch (item.getItemId()) {
		case 1:
			NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
			builder.setSmallIcon(R.drawable.ic_launcher);
			builder.setContentText("hello content Text!");
			builder.setContentTitle("Context Title");
//			Bitmap largeIcon = BitmapFactory.decodeResource(getResources(),R.drawable.fire);
			
			
			Intent resultIntent = new Intent(this, ListViewTwo.class);

			// The stack builder object will contain an artificial back stack for the
			// started Activity.
			// This ensures that navigating backward from the Activity leads out of
			// your application to the Home screen.
			TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
			// Adds the back stack for the Intent (but not the Intent itself)
			stackBuilder.addParentStack(ListViewTwo.class);
			// Adds the Intent that starts the Activity to the top of the stack
			stackBuilder.addNextIntent(resultIntent);
			PendingIntent resultPendingIntent =
			        stackBuilder.getPendingIntent(
			            0,
			            PendingIntent.FLAG_ONE_SHOT
			        );
			builder.setContentIntent(resultPendingIntent);
			
			NotificationManager mNotificationManager =
				    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
			mNotificationManager.notify(1, builder.build());

			break;
			
		case 2:
			
			break;
			
			
		default:
			break;
		}
    	
    	
    	return super.onContextItemSelected(item);
    }
    
    
}