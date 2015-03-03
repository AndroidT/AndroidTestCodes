package com.example.androidtest.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews;

import com.example.androidtest.R;
import com.example.androidtest.main.BaseActivity;

/**
 * 
 *  Class Name: NotificationCustomAct.java
 *  Function:�Զ���֪ͨ����Ϣ
 *  
 *  @author liuzheng
 *  @version 1.0 
 *  @created 2015��2��11�� ����4:28:43
 *  @Copyright http://liuz.me
 *  
 *  http://blog.csdn.net/vipzjyno1/article/details/25248021
 *  
 */
public class NotificationCustomAct extends BaseActivity implements OnClickListener{
	
	private Button btn01, btn02;
	// 
	private PendingIntent lovePendingIntent;
	private PendingIntent prevPendingIntent;
	private PendingIntent playPendingIntent;
	private PendingIntent nextPendingIntent;
	private PendingIntent canclePendingIntent;
	private IntentFilter mIntentFilter;
	
	private BtnReceiver mBtnReceiver;
	private boolean isPlaying = false;
	private boolean isLoveing = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("NotificationCustomAct");
		setContentView(R.layout.notification_custom_layout);

		initView();
		
		doRegisterReceiver();
	}
	
	protected void initView() {
		btn01 = (Button) findViewById(R.id.cus_notify_btn_01);
		btn02 = (Button) findViewById(R.id.cus_notify_btn_02);
		
		btn01.setOnClickListener(this);
		btn02.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.cus_notify_btn_01:
			showCustomNotification();
			break;
		case R.id.cus_notify_btn_02:
			// ��ͬ�汾 ��ͬRemoteView ����    
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) { // >= 16 ����ʹ�� bigContentView   �����Զ���֪ͨ����ʾ�߶�
				showCustomBtnNotification();
			}else { // < 16 ֻ��ʹ�� contentView ��ϵͳĬ��֪ͨ����ʾ�߶� 
				showShortToast("SDK.Version < 16, �Ժ�����......");
			}
			break;
		}
	}
	
	private void doRegisterReceiver() {
		mBtnReceiver = new BtnReceiver();
		mIntentFilter = new IntentFilter();
		mIntentFilter.addAction(NotificationConst.CUSTOM_BTN_ACTION);
		registerReceiver(mBtnReceiver, mIntentFilter);
	}

	/**
	 * 
	 *  Function:�Զ���֪ͨ
	 *  @author liuzheng
	 *  @created 2015��2��12�� ����11:01:14
	 */
	private void showCustomNotification() {
		mRemoteViews = new RemoteViews(getPackageName(), R.layout.cus_notify_layout);
		mRemoteViews.setImageViewResource(R.id.image_notify, R.drawable.ic_launcher);
		mRemoteViews.setTextViewText(R.id.textview_title, "����ͷ��");
		mRemoteViews.setTextViewText(R.id.textview_content, "����ɱ����������app store��ʽ����");
		
		mNotification = new Notification(R.drawable.ic_launcher_01, "...", System.currentTimeMillis());
		mNotification.contentView = mRemoteViews;
		mNotification.defaults = Notification.DEFAULT_ALL;
		mPendingIntent = PendingIntent.getActivity(this, 0, getIntent(), PendingIntent.FLAG_CANCEL_CURRENT);
		mNotification.contentIntent = mPendingIntent;
		mNotification.when = System.currentTimeMillis();
		mNotificationManager.notify(NotificationConst.MAIN_CUS_DEFAULT_ID, mNotification);
	}
	
	
	private int[] cusNotifyImages = {R.drawable.eason, R.drawable.wangfei, R.drawable.gem};
	private String[] cusNotifyTitles = {"ʮ��", "�Ҵ�����", "�������"};
	private String[] cusNotifyDescs = {"����Ѹ - �ڰ׻�", "���� - �Ҵ�����", "G.E.M.������ - �������"};
	
	/**
	 * 
	 *  Function:����ť���Զ���֪ͨ
	 *  @author liuzheng
	 *  @created 2015��2��12�� ����11:01:00
	 */
	private void showCustomBtnNotification() {
		mRemoteViews = new RemoteViews(getPackageName(), R.layout.cus_btn_notify_layout);
		
		// ����֪ͨ������ͼ������
		setRemoteViewData(0);
        
		mIntent = new Intent(NotificationConst.CUSTOM_BTN_ACTION);
		// ϲ��
		mIntent.putExtra(NotificationConst.BTN_KEY, NotificationConst.BTN_ID_LIKE);
		lovePendingIntent = PendingIntent.getBroadcast(this, 1001, mIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		mRemoteViews.setOnClickPendingIntent(R.id.cus_notify_love, lovePendingIntent);
		// ��һ��
		mIntent.putExtra(NotificationConst.BTN_KEY, NotificationConst.BTN_ID_PREV);
		prevPendingIntent = PendingIntent.getBroadcast(this, 1002, mIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		mRemoteViews.setOnClickPendingIntent(R.id.cus_notify_prev, prevPendingIntent);
		// ��ͣ/����
		mIntent.putExtra(NotificationConst.BTN_KEY, NotificationConst.BTN_ID_PLAY);
		playPendingIntent = PendingIntent.getBroadcast(this, 1003, mIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		mRemoteViews.setOnClickPendingIntent(R.id.cus_notify_play, playPendingIntent);
		// ��һ��
		mIntent.putExtra(NotificationConst.BTN_KEY, NotificationConst.BTN_ID_NEXT);
		nextPendingIntent = PendingIntent.getBroadcast(this, 1004, mIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		mRemoteViews.setOnClickPendingIntent(R.id.cus_notify_next, nextPendingIntent);
		// ȡ��
		mIntent.putExtra(NotificationConst.BTN_KEY, NotificationConst.BTN_ID_CANCLE);
		canclePendingIntent = PendingIntent.getBroadcast(this, 1005, mIntent, PendingIntent.FLAG_CANCEL_CURRENT);
		mRemoteViews.setOnClickPendingIntent(R.id.cus_notify_cancle, canclePendingIntent);
		
		mNotification = new Notification(R.drawable.ic_launcher, "���ڲ���...", System.currentTimeMillis());
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 1111, new Intent(), PendingIntent.FLAG_CANCEL_CURRENT);
		mNotification.contentView = mRemoteViews;  	// һ����ʾ(����)
		mNotification.bigContentView = mRemoteViews;// ������ʾ(API 16+ �Ǳ���  ���δ����  ����ʾһ��  ��������ʾ����)
		mNotification.contentIntent = pendingIntent;
		mNotification.flags = Notification.FLAG_ONGOING_EVENT;
		mNotificationManager.notify(NotificationConst.MAIN_CUS_DEFAULT_ID, mNotification);
		
	}

	/**
	 * 
	 *  Function:���� RemoteView
	 *  @author liuzheng
	 *  @created 2015��3��2�� ����3:29:58 
	 *  @param i ģ�����������±�
	 */
	private void setRemoteViewData(int i) {
		if (i > cusNotifyTitles.length) { // ��ֹԽ��
			return;
		}
		
		mRemoteViews.setImageViewResource(R.id.cus_notify_image, cusNotifyImages[i]);
		mRemoteViews.setTextViewText(R.id.cus_notify_title, cusNotifyTitles[i]);
		mRemoteViews.setTextViewText(R.id.cus_notify_desc, cusNotifyDescs[i]);
		
		if (mNotification != null) { // ע�� mRemoteViews �޸�  ��Ҫͬ���޸� mNotification.contentView/bigContentView
			mNotification.contentView = mRemoteViews;  	// һ����ʾ(����)
			mNotification.bigContentView = mRemoteViews;// ������ʾ(API 16+ �Ǳ���  ���δ����  ����ʾһ��  ��������ʾ����)
		}
	}

	/**
	 * 
	 *  Class Name: NotificationCustomAct.java
	 *  Function:�Զ���㲥������  ����֪ͨ����ť����¼�
	 *  
	 *  @author liuzheng
	 *  @version 1.0 
	 *  @created 2015��2��12�� ����11:02:01
	 *  @Copyright http://liuz.me
	 */
	public class BtnReceiver extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (action.equals(NotificationConst.CUSTOM_BTN_ACTION)) {
				int btnId = intent.getIntExtra(NotificationConst.BTN_KEY, 0);
				switch (btnId) {
				case NotificationConst.BTN_ID_LIKE:
					isLoveing = !isLoveing;
					
					if (isLoveing) {
						mRemoteViews.setImageViewResource(R.id.cus_notify_love, R.drawable.note_btn_loved);
					}else{
						mRemoteViews.setImageViewResource(R.id.cus_notify_love, R.drawable.note_btn_love);
					}
					
					showShortToast("ϲ��");
					break;
				case NotificationConst.BTN_ID_PREV:
					showShortToast("��һ��");
					
					// ����֪ͨ������ͼ������
					setRemoteViewData(1);
					
					break;
				case NotificationConst.BTN_ID_PLAY:
					String playStatu = "";
					isPlaying = !isPlaying;
					
					// ����֪ͨ������  
					if (isPlaying) { 
						playStatu = "��ʼ����";
						mRemoteViews.setImageViewResource(R.id.cus_notify_play, R.drawable.note_btn_pause);
					}else {
						mRemoteViews.setImageViewResource(R.id.cus_notify_play, R.drawable.note_btn_play);
						playStatu = "����ͣ";
					}
					
					showShortToast(playStatu);
					break;
				case NotificationConst.BTN_ID_NEXT:
					showShortToast("��һ��");
					
					// ����֪ͨ������ͼ������
					setRemoteViewData(2);
					
					break;
				case NotificationConst.BTN_ID_CANCLE:
					showShortToast("ȡ��");
					mNotificationManager.cancel(NotificationConst.MAIN_CUS_DEFAULT_ID);
					break;
				}
				
				// ��ȡ����   love pre pause/play next ��������Ҫ����֪ͨ����
				if (btnId != NotificationConst.BTN_ID_CANCLE) {
					// ֪ͨ����  ע��idͳһ
					mNotificationManager.notify(NotificationConst.MAIN_CUS_DEFAULT_ID, mNotification);
				}
			}
		}
	}
	
	@Override
	protected void onDestroy() {
		if (mBtnReceiver != null) {
			unregisterReceiver(mBtnReceiver);
		}
		super.onDestroy();
	}
}
