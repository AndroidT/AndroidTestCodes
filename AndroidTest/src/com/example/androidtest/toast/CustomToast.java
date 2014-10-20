package com.example.androidtest.toast;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

/** ���ԭ����Toast��ʾ��ʧ֮ǰ���ٴε���Toast.show()���н����� */
public class CustomToast {
	/** ���ڲ��� */
	private int showCount = 1;
	private Toast toast = null;
	private Context context;
	private Handler handler = null;
	private Runnable toastThread = new Runnable() {
		public void run() {
			// ������count���Եر����ǲ��������µ�Toast.show()�Ľ����
			toast.setText(String.valueOf(showCount++) + "CustomToast");
			toast.show();
			// 3.3����ٶ���������Ϊ4s�Ļ����ῴ��Toast�Ƕ϶���������ʾ�ŵġ�
			handler.postDelayed(toastThread, 3300);
		}
	};

	public CustomToast(Context context) {
		this.context = context;
		handler = new Handler(this.context.getMainLooper());
		toast = Toast.makeText(this.context, "", Toast.LENGTH_LONG);
	}

	public void setText(String text) {
		toast.setText(text);
	}

	public void showToast(final long length) {
		handler.post(toastThread);
		System.out.println("Handler post at:" + System.currentTimeMillis());
		Thread timeThread = new Thread() {
			public void run() {
				System.out.println("TimeThread start at:" + System.currentTimeMillis());
				try {
					Thread.sleep(length);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				CustomToast.this.stopToast();
				System.out.println("Toast canceled at:" + System.currentTimeMillis());
			}
		};
		timeThread.start();
	}

	public void stopToast() {
		// ɾ��Handler�����е��Դ���ȴ�����ϢԪ��ɾ��
		handler.removeCallbacks(toastThread);
		// ����������ʾ��Toast
		toast.cancel();
	}
}