package com.example.androidtest.notification;

import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompatExtras;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.androidtest.R;
import com.example.androidtest.main.BaseActivity;

/**
 * 
 * @author Administrator
 *http://www.eoeandroid.com/thread-562932-1-1.html
 *http://blog.csdn.net/zywisdoml/article/details/42966193#t2
 */
public class NotificationActivity extends BaseActivity implements OnClickListener {

	private int[] notificationIds = { R.id.notification_simple, R.id.notification_always_show, R.id.notification_clear_one, R.id.notification_clear_all, 
			R.id.notification_customer, R.id.notification_progress };

	private Button[] btns = new Button[notificationIds.length];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification_layout);
		
		initView();
	}

	private void initView() {
		for (int i = 0; i < notificationIds.length; i++) {
			btns[i] = (Button) findViewById(notificationIds[i]);
			btns[i].setOnClickListener(this);
		}
		
		mNotification = new Notification(R.drawable.ic_launcher, "", System.currentTimeMillis());
		mNotification.defaults = Notification.DEFAULT_LIGHTS;
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.notification_simple:// ��֪ͨ
			mNotification.flags = Notification.FLAG_AUTO_CANCEL;
			mNotification.setLatestEventInfo(this, "֪ͨ������", "֪ͨ������............", null);
			mNotificationManager.notify(NotificationConst.MAIN_DEFAULT_ID, mNotification);
			break;
		case R.id.notification_always_show:// ��פ֪ͨ
			
			break;
		case R.id.notification_clear_one:// ���ĳһ��֪ͨ
			
			break;
		case R.id.notification_clear_all:// �������֪ͨ (��פ�ĳ���)
			
			break;
		case R.id.notification_customer:// �Զ���֪ͨ
			
			break;
		case R.id.notification_progress:// �Զ��������֪ͨ
			
			break;
		}
	}
}
