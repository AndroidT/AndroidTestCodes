package com.example.androidtest;

import android.app.Activity;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;

/**
 * ����ѡ����
 */
public class LongClickSelCopyAct extends Activity {
	
	private TextView textView;
	private MyCopyTextView textView2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.long_click_copy);
		
		textView = (TextView) findViewById(R.id.textView1);
		textView.setText("�ȸ�I/O��Ὺʼ�ˣ����Ȳ��ŵ���һ����Ƶ���ֳ��ĳ������κ�����ͷ��װ�ã��������ع�����û���ˡ�" +
				"�ȸ�I/O��Ὺʼ�ˣ����Ȳ��ŵ���һ����Ƶ���ֳ��ĳ������κ�����ͷ��װ�ã��������ع�����û���ˡ�");
		
		
		textView2 = (MyCopyTextView) findViewById(R.id.myCopyTextView1);
		textView2.setText("ƻ������16GB������iPod Touch������iSight����ͷ���ۼ�199��Ԫ | ƻ�������Ƴ����������16GB�汾�ĵ����iPod Touch������500����iSight����ͷ���ۼ�199��Ԫ��" +
				"ƻ������16GB������iPod Touch������iSight����ͷ���ۼ�199��Ԫ | ƻ�������Ƴ����������16GB�汾�ĵ����iPod Touch������500����iSight����ͷ���ۼ�199��Ԫ��");
		
		
		
	}
	
}
