package com.example.androidtest.textview;

import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.util.Log;
import android.widget.TextView;

import com.example.androidtest.R;
import com.example.androidtest.main.BaseActivity;
import com.example.androidtest.main.MyApplication;

public class MyTextViewAct extends BaseActivity {
	
	private TextView textView;
	private String textString = "������: (1890)������������Ҳ����˵���䱩��������Ҫô��Ϊ�Լ����Ķ������˼ӱ���������ȴ����һ�������̫���ˡ�����Ҫôû��ȫ��ֻ���������������˳�ƽ����ֵĴ�Ҳ���ڹ���ͷ�ϡ��ˡ������ˡ�����ģ�����ս��ĥ�����������е����ü�ֱ̫����ʧ����";
	
	private int textViewWid = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_textview_layout);
		
		textView = (TextView) findViewById(R.id.text_view);
		textView.setText(textString);
		
		SpannableString spannableString = new SpannableString(textString);
		
		Log.i("liuz", "line height..." + textView.getLineHeight());
		Log.i("liuz", "width..." + MyApplication.width);
		Log.i("liuz", "height..." + MyApplication.height);
		
		textViewWid = MyApplication.width - 100 - 10;
		
	}
}
