package com.example.androidtest;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class JsonParseAct extends Activity {
	private static final ArrayList list = new ArrayList();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView textView = new TextView(this);
		try {
			JSONObject jsonObject = new JSONObject("{\"content\": \"��������е�һ����ʽ�������죬���Է�дһ�����飬������ͺ�Ʒ��ں����ֱ����һ�죬���ǳ�������Ҫ����ʱ������һ��򿪺��ӣ����Ե���һ����\r\n�ƣ�ȥ��ͬ�Ľ��䣬���ź�ƣ����Է���ʱд�����飬��������ʱ�Ƿ����ۣ�����˴�֮����Ƿݸ��顣��������ֻ���������ž�������о���<br />\"}");
			
			String text = jsonObject.getString("content");
			
			textView.setText(text);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		setContentView(textView);
		
		jsonParseToList();
		
	}

	private ArrayList jsonParseToList() {
		try {
			JSONObject jsonObject = new JSONObject("{\"allcount\": \"6\",\"record\": [{\"money\": \"6.00\",\"fens\": \"2\",\"time\": \"2005-03-18 09:58:31\"}],\"jscount\": 2 }");
			
			String allcount  = jsonObject.getString("allcount");
			
			JSONArray jsonArray = jsonObject.getJSONArray("record");
			int num = jsonArray.length();
			for (int i = 0; i < num; i++) {
				JSONObject recordObject = jsonArray.getJSONObject(i);
				Record record = new Record();
				record.setMoney(recordObject.getString("money"));
				// .....
			
				// list to add record 
				list.add(record);
			}
			String jscount  = jsonObject.getString("jscount");
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	class Record{
		private String money;
		private String fens;
		private String times;
		
		public String getMoney() {
			return money;
		}
		public void setMoney(String money) {
			this.money = money;
		}
		public String getFens() {
			return fens;
		}
		public void setFens(String fens) {
			this.fens = fens;
		}
		public String getTimes() {
			return times;
		}
		public void setTimes(String times) {
			this.times = times;
		}
	}
	
	
}
