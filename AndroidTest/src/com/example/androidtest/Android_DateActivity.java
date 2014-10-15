package com.example.androidtest;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class Android_DateActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	private Button button;
	private TextView textview;
	private Dialog mdialog;
	private Calendar calendar = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);

		initUi();
		button.setOnClickListener(this);
	}

	public void initUi() {
		button = (Button) findViewById(R.id.button);
		textview = (TextView) findViewById(R.id.TextView01);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		showDialog(0);// ���ڵ�����
		int SDKVersion = Android_DateActivity.this.getSDKVersionNumber();// ��ȡϵͳ�汾
		System.out.println("SDKVersion = " + SDKVersion);
		DatePicker dp = findDatePicker((ViewGroup) mdialog.getWindow()
				.getDecorView());// ���õ���������
		if (dp != null) {
			if (SDKVersion < 11) {
				((ViewGroup) dp.getChildAt(0)).getChildAt(1).setVisibility(
						View.GONE);
			} else if (SDKVersion > 14) {
				((ViewGroup) ((ViewGroup) dp.getChildAt(0)).getChildAt(0))
						.getChildAt(1).setVisibility(View.GONE);
			}
		}

	}

	@Override
	protected Dialog onCreateDialog(int id) { // ��Ӧ�����showDialog(0);//���ڵ�����
		mdialog = null;
		switch (id) {
		case 0:
			calendar = Calendar.getInstance();
			mdialog = new DatePickerDialog(this,
					new DatePickerDialog.OnDateSetListener() {
						@Override
						public void onDateSet(DatePicker view, int year,
								int monthOfYear, int dayOfMonth) {
							textview.setText(year + "-" + (monthOfYear + 1));
						}
					}, calendar.get(Calendar.YEAR),
					calendar.get(Calendar.MONTH),
					calendar.get(Calendar.DAY_OF_MONTH));
			break;
		}
		return mdialog;
	}

	/**
	 * �ӵ�ǰDialog�в���DatePicker�ӿؼ�
	 * 
	 * @param group
	 * @return
	 */
	private DatePicker findDatePicker(ViewGroup group) {
		if (group != null) {
			for (int i = 0, j = group.getChildCount(); i < j; i++) {
				View child = group.getChildAt(i);
				if (child instanceof DatePicker) {
					return (DatePicker) child;
				} else if (child instanceof ViewGroup) {
					DatePicker result = findDatePicker((ViewGroup) child);
					if (result != null)
						return result;
				}
			}
		}
		return null;
	}

	/**
	 * ��ȡϵͳSDK�汾
	 * 
	 * @return
	 */
	public static int getSDKVersionNumber() {
		int sdkVersion;
		try {
			sdkVersion = Integer.valueOf(android.os.Build.VERSION.SDK);
		} catch (NumberFormatException e) {
			sdkVersion = 0;
		}
		return sdkVersion;
	}
}