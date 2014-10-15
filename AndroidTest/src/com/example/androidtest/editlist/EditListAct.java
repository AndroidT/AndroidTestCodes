package com.example.androidtest.editlist;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.androidtest.R;

public class EditListAct extends Activity {

	private ListView editLisView;
	private EditListAdapter adapter;
	private ArrayList<String> dataList = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_list_lay);
		
		for (int i = 0; i < 5; i++) {
			dataList.add("����ʡ˰���"+i);
			dataList.add("��ɳ��˰���"+i);
			dataList.add("������˰���"+i);
			dataList.add("��Ϣ����"+i);
			dataList.add("���ܰ칫��Ŀ��"+i);
		}
		
		adapter = new EditListAdapter(this, dataList);
		editLisView = (ListView) findViewById(R.id.edit_list_view);
		editLisView.setAdapter(adapter);
		
		editLisView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
			}
		});
	}
}
