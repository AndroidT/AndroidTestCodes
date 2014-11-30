package com.example.androidtest;

import android.os.Bundle;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

import com.example.androidtest.main.BaseActivity;

public class TextScaleAct extends BaseActivity {
	
	private TextView mTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.text_scale_layout);
		
		mTextView = (TextView) findViewById(R.id.scale_textview);
//		mTextView.setText(getString(R.string.text));
		
		mTextView.setText("��ҵ��������\n ��λ��˰�ˡ����˶�����ҵ��һ���������ι�˾�������ҵ��פ��������걨����˰��Ǽǡ�\n ���������ϡ�\n ��1����˰��ǼǱ����õ�λ��˰�ˣ���1�ݣ�ʵ�й�˰�֡���˰�����ϰ���˰��Ǽ�֤�ģ�Ӧ�ṩ2�ݣ���\n ��2������Ӫҵִ�ջ�������׼ִҵ֤��ԭ������ӡ����\n ��3����֯��������֤�鸱��ԭ������ӡ����\n ��4���йغ�ͬ���³̡�Э���鸴ӡ����\n ��5�����������ˣ������ˣ��������֤���ռ�����֤����ݵĺϷ�֤��ԭ������ӡ����\n ��6����˰�˿��أ��У������ķ�֧��������˰��Ǽ�ʱ��Ӧ�ṩ�ܻ�����˰��Ǽ�֤������ӡ����\n ��7�����������ҵӦ�ṩ�йظ�����Ƶ�����ļ�ԭ������ӡ����\n ��8�����͡���������˰��˰�˻�Ӧ�ṩ�������ϣ�\n ����������ҵ���������\n ��������װ�ü�����·�ߵļ�Ҫ˵����\n ������ҵ������������Ʒ���ơ���Ʒ��׼����;��\n ��9������Ͷ����ҵ��Ӧ�ṩ��������������֤��ԭ������ӡ����\n ��10�������ҵ��פ���������Ӧ�ṩ�������ϣ�\n ����ע���ַ����Ӫ��ַ֤������Ȩ֤������Э�飩ԭ������ӡ������Ϊ���з�����Ӧ�ṩ��Ȩ֤��������Լ�ȺϷ��Ĳ�Ȩ֤��ԭ������ӡ������Ϊ���޵ĳ�����Ӧ�ṩ����Э��ԭ������ӡ����������Ϊ��Ȼ�˵Ļ�Ӧ�ṩ��Ȩ֤����ԭ������ӡ����\n ������ϯ���������ˣ����ջ������Ϸ����֤����ԭ������ӡ����\n ���������ҵ���������������ؾ����ļ������й�����������������������������������ơ���ַ����ϵ��ʽ����ϯ���������ȣ���");
		
		mTextView.setOnTouchListener(new TouchZoomListener());
	}
	
	class TouchZoomListener implements OnTouchListener{
		int mode = 0;  // ������ĸ���
		float oldDist;  
		float textSize = 0; 
		TextView textView = null;
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			textView = (TextView) v;
		    if (textSize == 0) {
		    	textSize = textView.getTextSize();
			}
		    
		    switch (event.getAction() & MotionEvent.ACTION_MASK) {
				case MotionEvent.ACTION_DOWN:// ���㰴��
					mode = 1;
					break;
				case MotionEvent.ACTION_UP:// �����ɿ�
					mode = 0;
					break;
				case MotionEvent.ACTION_POINTER_DOWN:// ��㰴��
					oldDist = spacing(event);
					mode += 1;
					break;
				case MotionEvent.ACTION_POINTER_UP:// ����ɿ�
					mode -= 1;
					break;
				case MotionEvent.ACTION_MOVE:// �ƶ�
					if (mode >= 2) {
						float newDist = spacing(event);
						if (newDist > oldDist + 1) {
							zoom(newDist / oldDist);
							oldDist = newDist;
						}
						
						if (newDist < oldDist - 1) {
							zoom(newDist / oldDist);
							oldDist = newDist;
						}
					}
					break;
				default:
					break;
			}
			return true;
		}
		
		/**
		 * �Ŵ� ��С
		 * @param f
		 */
		private void zoom(float f) {
			textView.setTextSize(textSize *= f);
		}
		
		/**
		 * ��ȡ�ƶ�����
		 * @param event
		 * @return
		 */
		private float spacing(MotionEvent event) {
	        float x = event.getX(0) - event.getX(1);  
	        float y = event.getY(0) - event.getY(1);  
	        return FloatMath.sqrt(x * x + y * y);  
		}
	}
}
