package com.example.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class FixTextViewAct extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		String text = "FixTextViewActFixT�����·�����extViewActFi������xTextViewActFixText��˹�ٷ�ViewActFixTextViewA��������ctFixTextViewActFi�����·�����xTextViewActFixTextVi��˹�ٷҵ���ewActFixTextViewActFixTad������extViewActFixTextViewActFixTextV��˹�ٷ�iewActFixTex����ɫ��tViewActFix ��˹�ٷ�TextViewActFixTextViewAct";
		
//		TextView textView = new TextView(this);
		FixTextView textView = new FixTextView(this);
		textView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));

		
		text = ToDBC(text);
		
		textView.setText(text);
		setContentView(textView);

	}

	/**
	 * ���ת��Ϊȫ��
	 * 
	 * @param input
	 * @return
	 */
	public static String ToDBC(String input) {
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 12288) {
				c[i] = (char) 32;
				continue;
			}
			if (c[i] > 65280 && c[i] < 65375)
				c[i] = (char) (c[i] - 65248);
		}
		return new String(c);
	}
}
