package com.example.androidtest.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompatExtras;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.androidtest.AndroidNotificationAct;
import com.example.androidtest.R;
import com.example.androidtest.main.BaseActivity;

/**
 * 
 *  Class Name: NotificationActivity.java
 *  Function:
 *  
 *  @author liuzheng
 *  @version 1.0 
 *  @created 2015��2��11�� ����10:57:11
 *  @Copyright http://liuz.me
 *  http://www.eoeandroid.com/thread-562932-1-1.html
 *  http://blog.csdn.net/zywisdoml/article/details/42966193#t2
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
		
		//��֪ͨ��δ������ ��ʾ  ͼƬ ���� 
		mNotification = new Notification(R.drawable.fenzu_list_radio_select, "Notification", System.currentTimeMillis());
		mNotification.defaults = Notification.DEFAULT_LIGHTS; 
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.notification_simple:// ��֪ͨ
			// FLAG_ONLY_ALERT_ONCE �������cancle
			mNotification.flags = Notification.FLAG_AUTO_CANCEL;
//			mNotification.defaults = Notification.DEFAULT_ALL; // Ĭ������ ��  �ƹ�
//			mNotification.sound=Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.mm); // �Զ������� 
			mNotification.setLatestEventInfo(this, "֪ͨ������", "֪ͨ������...��֪ͨ", null);
			mNotificationManager.notify(NotificationConst.MAIN_DEFAULT_ID, mNotification);
			break;
		case R.id.notification_always_show:// ��פ֪ͨ
			// FLAG_NO_CLEAR ֪ͨ��û�� ��� ��ť ���ǿ��Գ������
			// FLAG_ONGOING_EVENT �ظ���ʾ
			mNotification.flags = Notification.FLAG_NO_CLEAR;
			mNotification.setLatestEventInfo(this, "��פ֪ͨ", "��פ֪ͨ����", null);
			mNotificationManager.notify(NotificationConst.MAIN_NO_CLEAR, mNotification);
			break;
		case R.id.notification_clear_one:// ���ĳһ��֪ͨ
			mNotificationManager.cancel(NotificationConst.MAIN_DEFAULT_ID);
			break;
		case R.id.notification_clear_all:// �������֪ͨ
			mNotificationManager.cancelAll(); // ���������  ����
			break;
		case R.id.notification_click_intent:// �ɵ��֪ͨ  ��֪ͨ����ӵ���¼�  һ���������¼� 1.����activity  2.����service  3.���͹㲥broastcast 
			mNotification.flags = Notification.FLAG_ONLY_ALERT_ONCE; // �������֪ͨ��  ������ʧ
			mPendingIntent = PendingIntent.getActivity(this, 1001, new Intent(this, AndroidNotificationAct.class), PendingIntent.FLAG_UPDATE_CURRENT); // �¼�Intent
			mNotification.setLatestEventInfo(this, "�Զ���֪ͨ����", "�Զ���֪ͨ����", mPendingIntent);
			mNotificationManager.notify(NotificationConst.MAIN_DEFAULT_ID, mNotification);
			break;
		case R.id.notification_customer:// �Զ���֪ͨ
			startActivity(new Intent(this, NotificationCustomAct.class));
			break;
		case R.id.notification_progress:// �Զ��������֪ͨ
			startActivity(new Intent(this, NotificationProgressAct.class));
			break;
		}
	}
	
}
