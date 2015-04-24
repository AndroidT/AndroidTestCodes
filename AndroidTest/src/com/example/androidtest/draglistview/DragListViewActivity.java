package com.example.androidtest.draglistview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.androidtest.R;
import com.example.androidtest.draglistview.DragSortGridView.OnReorderingListener;
import com.example.androidtest.main.BaseActivity;

/**
 * 
 *  Class Name: DragListViewActivity.java
 *  Function: ���϶� listview �� gridview 
 *  
 *  @author liuzheng
 *  @version 1.0 
 *  @created 2015��4��22�� ����2:07:07
 *  @Copyright http://liuz.me 
 *  @url http://blog.csdn.net/vipzjyno1/article/details/25005851
 */
public class DragListViewActivity extends BaseActivity {
	
	private DragSortGridView dGridView;
	private ColorsAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drag_listview_layout);
		
		dGridView = (DragSortGridView) findViewById(R.id.dragSortGridView);
		
		int[] colors = new int[10]; // ����gridview item����
		Random random = new Random();
		// �����������ͬ��ɫ
		for (int i = 0; i < colors.length; i++) {
			colors[i] = Color.rgb(random.nextInt(0xff), random.nextInt(0xff), random.nextInt(0xff));
		}
		
		adapter = new ColorsAdapter(this, colors);
		dGridView.setAdapter(adapter);
		// �ƶ����������   
		dGridView.setOnReorderingListener(new OnReorderingListener() {
			@Override
			public void onReordering(int fromPosition, int toPosition) {
				Log.i("liuz", "fromPosition..." + fromPosition + "####" + "toPosition..." + toPosition);
				if (adapter != null) {
					adapter.reorder(fromPosition, toPosition);
				}else{
					
				}
			}
		});
	}
	
	
	class ColorsAdapter extends BaseAdapter{
		// ��ɫ��λ�� ����
		private List<Integer> colors;
		private List<Integer> positions;
		private Context mContext;
		
		public ColorsAdapter(Context context, int[] colors) {
			this.colors = new ArrayList<Integer>();
			this.positions = new ArrayList<Integer>();
			this.mContext = context;
			
			// 
			for (int color : colors) {
				this.colors.add(color);
				this.positions.add(positions.size());
			}
		}
		
		/**
		 * 
		 *  Function: ��������
		 *  @author liuzheng
		 *  @created 2015��4��22�� ����2:51:27 
		 *  @param from ��ʼ����
		 *  @param to   Ŀ������
		 */
		public void reorder(int from, int to){
			if (from != to) {
				int color = colors.remove(from); // ��ȡѡ���Ƴ��� item
				colors.add(to, color);	// ���Ƴ��� item ��ӵ�ָ����λ�� to 
				
				int position = positions.remove(from); // ͬ��
				positions.add(to, position);
				
				notifyDataSetChanged();
			}
		}
		
		@Override
		public int getCount() {
			return colors.size();
		}

		@Override
		public Object getItem(int position) {
			return colors.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// ��ʼ����ʾ�ؼ�
			TextView textView = (TextView) convertView;
			
			if (textView == null) {
				textView = new TextView(mContext);
				textView.setBackgroundColor(colors.get(position)); // ���ñ�����ɫ 
				textView.setText(Integer.toString(positions.get(position))); // �����ı�
				textView.setGravity(Gravity.CENTER); // �����ı�����
				textView.setPadding(5, 5, 5, 5); // ���ñ߾�
				textView.setMinHeight(100); // ��С�߶�
				
			}else{
				textView.setBackgroundColor(colors.get(position));
				textView.setText(Integer.toString(positions.get(position)));
			}
			
			return textView;
		}
	}
}
