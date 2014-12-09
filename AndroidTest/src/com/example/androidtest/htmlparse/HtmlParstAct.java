package com.example.androidtest.htmlparse;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;

import com.example.androidtest.R;
import com.example.androidtest.main.BaseActivity;

/**
 * 
 *  Class Name: HtmlParstAct.java
 *  Function:
 *  
 *  @author liuzheng
 *  @version 1.0 
 *  @created 2014-11-25 ����11:16:46
 */
public class HtmlParstAct extends BaseActivity {
	
	private ListView htmlListView;
	private ArrayList<HtmlParseBean> htmlParseBeans = new ArrayList<HtmlParseBean>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.html_parse_layout);
		
		htmlListView = (ListView) findViewById(R.id.html_listView);
		
//		setData();
//
//		for (int i = 0; i < titles.length; i++) {
//			HtmlParseBean htmlParseBean = new HtmlParseBean();
//			htmlParseBean.setHtmlId(""+(i+1));
//			htmlParseBean.setHtmlTitle(titles[i]);
//			htmlParseBean.setHtmlDesc(descs[0]);
//			htmlParseBean.setHtmlType(types[i]);
//			htmlParseBean.setHtmlTime(times[i]);
//			
//			htmlParseBeans.add(htmlParseBean);
//		}
//		htmlListView.setAdapter(new HtmlParseAdapter(this, htmlParseBeans));
		///////////////////////////////////////////////////////////////////
		
		showProgressDialog();
		
		new Thread(){
			public void run() {
				
				KanZhiHuParse.getContentHtml();
				htmlParseBeans = KanZhiHuParse.getHtmlParseBeans();
				
				handler.sendEmptyMessage(0);
			};
		}.start();
		
	}
	
	Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			htmlListView.setAdapter(new HtmlParseAdapter(HtmlParstAct.this, htmlParseBeans));
			dismissProgressDialog();
		};
	};
	
	
	private String[] titles, descs, types, times;
	private void setData() {
		titles = new String[]{"2014��11��25�� ��������", "2014��11��25�� ��������", "2014��11��25�� ��ʷ����", "2014��11��24�� ��������", "2014��11��24�� ��������", "2014��11��24�� ��ʷ����"};
		descs = new String[]{"ժ¼�� [���ĸ�˲��������롮��һֱ������ȥ��á���]��[����˵�Ļ������Ҷ��Ƿϻ������ٿռ䷢�ӹ��ķ��ӵ�˵��]��[adjfhajkhfak�ռ�����ظ��ɼ�����]��[�����򾩹����ɺϷ��ֿ��Ͱ���෢d]��[����˵���ͷ��䰮���ǶԷ������ҵ绰����]"};
		types = new String[]{"��������", "��������", "��ʷ����", "��������", "��������", "��ʷ����"};
		times = new String[]{"2014-11-25 11:46:33", "2014-11-25 11:46:33", "2014-11-25 11:46:33", "2014-11-24 11:46:33", "2014-11-24 11:46:33", "2014-11-24 11:46:33"};
	}
}
