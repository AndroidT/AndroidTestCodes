package com.example.androidtest;

import java.util.Arrays;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.widget.TextView;

public class FixTextView extends TextView {

	public FixTextView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
//		super.onDraw(canvas);
		Paint mPaint = getPaint();
	    FontMetrics fm = mPaint.getFontMetrics();  
        
	    float baseline = fm.descent - fm.ascent;   
	    float x = 0;  
	    float y =  baseline;  //����ϵͳ��������ĵײ��������ı���������Ҫ��������ĸ߶ȡ�  
	          
	    String txt = getText().toString();
	          
	    //�ı��Զ�����  
	    String[] texts = autoSplit(txt, mPaint, getWidth());  
	          
	    System.out.printf("line indexs: %s\n", Arrays.toString(texts));  
	          
	    for(String text : texts) {   
	        canvas.drawText(text, x, y, mPaint);  //�����Կؼ����Ͻ�Ϊԭ��  
	        y += baseline + fm.leading; //��������м��  
	    } 
	}
	
    /** 
     * �Զ��ָ��ı� 
     * @param content ��Ҫ�ָ���ı� 
     * @param p  ���ʣ�����������������ı��Ŀ�� 
     * @param width ���Ŀ���ʾ���أ�һ��Ϊ�ؼ��Ŀ�ȣ� 
     * @return һ���ַ������飬����ÿ�е��ı� 
     */  
    private String[] autoSplit(String content, Paint p, float width) {  
        int length = content.length();  
        float textWidth = p.measureText(content);  
        if(textWidth <= width) {  
            return new String[]{content};  
        }  
              
        int start = 0, end = 1, i = 0;  
        int lines = (int) Math.ceil(textWidth / width); //��������  
        String[] lineTexts = new String[lines];  
        while(start < length) {  
            if(p.measureText(content, start, end) > width) { //�ı���ȳ����ؼ����ʱ  
                lineTexts[i++] = (String) content.subSequence(start, end);  
                start = end;  
            }  
            if(end == length) { //����һ�е��ı�  
                lineTexts[i] = (String) content.subSequence(start, end);  
                break;  
            }  
            end += 1;  
        }  
        return lineTexts;  
    }  

}
