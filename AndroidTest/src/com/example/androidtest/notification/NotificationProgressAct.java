package com.example.androidtest.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;

import com.example.androidtest.R;
import com.example.androidtest.main.BaseActivity;

/**
 * 
 * Class Name: NotificationProgressAct.java Function: �Զ���֪ͨ��������
 * 
 * @author liuzheng
 * @version 1.0
 * @created 2015��3��2�� ����4:00:20
 * @Copyright http://liuz.me
 */
public class NotificationProgressAct extends BaseActivity {

	private IntentFilter mIntentFilter;
	private ClearBroadcast mClearBroadcast;
	
	private int mCurrentProgress = 0;
	private int mLastProgress = 0;
	private boolean mIsPause = false;
	private DownloadThread mDownloadThread;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("NotificationProgressAct");
		setContentView(R.layout.notification_progress_layout);
		// ע����֪ͨ�������㲥
		doRegisterReceiver();
	}

	/**
	 * 
	 *  Function: ע���Զ���㲥
	 *  @author liuzheng
	 *  @created 2015��3��2�� ����4:31:00
	 */
	public void doRegisterReceiver() {
		mIntentFilter = new IntentFilter();
		mIntentFilter.addAction(NotificationConst.CLEAR_BROADCAST_ACTION);
		mClearBroadcast = new ClearBroadcast();
		registerReceiver(mClearBroadcast, mIntentFilter);
	}
	
	
	@Override
	protected void onDestroy() {
		if (mClearBroadcast != null) {
			unregisterReceiver(mClearBroadcast);
		}
		super.onDestroy();
	}
	
	/**
	 * 
	 *  Class Name: NotificationProgressAct.java
	 *  Function: �Զ���㲥����
	 *  
	 *  @author liuzheng
	 *  @version 1.0 
	 *  @created 2015��3��2�� ����4:32:39
	 *  @Copyright http://liuz.me
	 */
	public class ClearBroadcast extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			Log.i("liuz", "action..." + intent.getAction());
			if (intent.getAction().equals(NotificationConst.CLEAR_BROADCAST_ACTION)) {
				showShortToast("����������֪ͨ...");
			}
		}
	}
	
	/**
	 * 
	 *  Function:Ĭ�Ͻ�����֪ͨ
	 *  @author liuzheng
	 *  @created 2015��3��2�� ����4:42:25
	 */
	private void showDefaultProgressNotify(boolean indeterminate) {
		// ��ʼ��֪ͨ����
		mNotification = new Notification();
		// ����֪ͨ��������ʾ����
		mRemoteViews = new RemoteViews(getPackageName(), R.layout.notification_progress_default_layout);
		mRemoteViews.setTextViewText(R.id.notification_default_text, "Ĭ�Ͻ�������������...");
		mRemoteViews.setProgressBar(R.id.notification_default_progress, 100, 50, indeterminate);// indeterminate �Ƿ񲻶���  t �ж�̬Ч�� f ��
		// ����֪ͨ��������ʾ
		mNotification.contentView = mRemoteViews;
		mNotification.icon = R.drawable.ic_launcher;
		mNotification.tickerText = "Ĭ�Ͻ�������������...";
		mNotification.defaults = Notification.DEFAULT_VIBRATE; // Ĭ��֪ͨ ��
		
		// ���֪ͨʱ����
		mIntent = new Intent(NotificationConst.CLEAR_BROADCAST_ACTION);
		mPendingIntent = PendingIntent.getBroadcast(this, 0, mIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		mNotification.deleteIntent = mPendingIntent;
		
		// ����֪ͨ
		mNotificationManager.notify(NotificationConst.MAIN_PROGRESS_DEFAULT_ID, mNotification);
	}
	
	/**
	 * 
	 *  Function:��Ĭ�Ͻ�����
	 *  @author liuzheng
	 *  @created 2015��3��3�� ����10:44:16
	 */
	private void showNonDedaultProgressNotify(boolean indeterminate) {
		// ��ʼ��֪ͨ����
		mNotification = new Notification();
		// ����֪ͨ��������ʾ����
		mRemoteViews = new RemoteViews(getPackageName(), R.layout.notification_progress_nondefault_layout);
		mRemoteViews.setTextViewText(R.id.notification_nondefault_text, "��Ĭ�Ͻ�������������...");
		mRemoteViews.setProgressBar(R.id.notification_nondefault_progress, 100, 50, indeterminate); 
		// ����֪ͨ��������ʾ
		mNotification.contentView = mRemoteViews;
		mNotification.icon = R.drawable.ic_launcher_01;
		mNotification.tickerText = "��Ĭ�Ͻ�������������...";
		mNotification.defaults = Notification.DEFAULT_VIBRATE; // Ĭ��֪ͨ ��

		// ���֪ͨʱ����
		mIntent = new Intent(NotificationConst.CLEAR_BROADCAST_ACTION);
		mPendingIntent = PendingIntent.getBroadcast(this, 0, mIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		mNotification.deleteIntent = mPendingIntent;

		// ����֪ͨ
		mNotificationManager.notify(NotificationConst.MAIN_PROGRESS_DEFAULT_ID, mNotification);
	}
	
	/**
	 * 
	 *  Function:�Զ��������
	 *  @author liuzheng
	 *  @created 2015��3��3�� ����4:18:11 
	 *  @param indeterminate
	 */
	private void showCusProgressNotify(boolean indeterminate, String title) {
		mNotification = new Notification();
		
		mRemoteViews = new RemoteViews(getPackageName(), R.layout.notification_progress_cus_layout);
		mRemoteViews.setTextViewText(R.id.notification_progress_cus_text, title);
		
		if (mCurrentProgress >= 100 || mDownloadThread == null) { // �������
			mRemoteViews.setProgressBar(R.id.notification_progress_cus_progressbar, 0, 0, indeterminate);
			mRemoteViews.setViewVisibility(R.id.notification_progress_cus_progressbar, View.GONE);
		}else{ // ��������...
			mRemoteViews.setViewVisibility(R.id.notification_progress_cus_progressbar, View.VISIBLE);
			mRemoteViews.setProgressBar(R.id.notification_progress_cus_progressbar, 100, mLastProgress, indeterminate);
		}
		
		mNotification.contentView = mRemoteViews;
		mNotification.defaults = Notification.DEFAULT_VIBRATE;
		mNotification.icon = R.drawable.ic_launcher_02;
		mNotification.tickerText = "downloading......";
		
		mNotificationManager.notify(NotificationConst.MAIN_PROGRESS_DEFAULT_ID, mNotification);
		
	}
	
	/**
	 * 
	 *  Class Name: NotificationProgressAct.java
	 *  Function: �����߳�
	 *  
	 *  @author liuzheng
	 *  @version 1.0 
	 *  @created 2015��3��3�� ����10:14:00
	 *  @Copyright http://liuz.me
	 */
	class DownloadThread extends Thread{
		@Override
		public void run() {
			
		}
	}
	
	/**
	 * ��ť�¼�
	 */
	@Override
	public void click_listener(View v) {
		switch (v.getId()) {
		case R.id.notification_customer_progress_01:
			showShortToast("show default progress notify");
			mDownloadThread = null;
			showDefaultProgressNotify(true);
			break;
		case R.id.notification_customer_progress_02:
			showShortToast("show non-default progress notify");
			mDownloadThread = null;
			showNonDedaultProgressNotify(true);
			break;
		case R.id.notification_customer_progress_03:
			showShortToast("show cus progress notify");
			mDownloadThread = null;
			showCusProgressNotify(false, "wait for download......");
			break;
		case R.id.notification_customer_progress_04:
			showShortToast("start download notify");
			break;
		case R.id.notification_customer_progress_05:
			showShortToast("pause download notify");
			break;
		case R.id.notification_customer_progress_06:
			showShortToast("cancle download notify");
			break;
		default:
			break;
		}
	}

}
