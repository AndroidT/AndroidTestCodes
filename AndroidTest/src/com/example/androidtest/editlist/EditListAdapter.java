package com.example.androidtest.editlist;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.example.androidtest.R;

public class EditListAdapter extends BaseAdapter {

	private Activity mActivity;
	private ArrayList<String> mDataList;
	private LayoutInflater mInflater;
    //����һ��HashMap���������EditText��ֵ��Key��position  
    private HashMap<Integer, String> hashMap = new HashMap<Integer, String>();  
	
	public EditListAdapter(Activity activity, ArrayList<String> dataList){
		this.mActivity = activity;
		this.mDataList = dataList;
		this.mInflater = LayoutInflater.from(mActivity);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mDataList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mDataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		EditListViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.edit_list_item, null);
			holder = new EditListViewHolder();
			
			holder.editText = (EditText) convertView.findViewById(R.id.editText1);
			convertView.setTag(holder);
		}else {
			holder = (EditListViewHolder) convertView.getTag();
		}
		
//		holder.editText.setTag(mDataList.get(position).toString());
		holder.editText.setText(mDataList.get(position));
//		//ΪeditText����TextChangedListener��ÿ�θı��ֵ���õ�hashMap  
//        //����Ҫ�õ������ֵ����position��ֵ  
//		holder.editText.addTextChangedListener(new TextWatcher() {  
//            @Override  
//            public void onTextChanged(CharSequence s, int start, int before, int count) {}  
//            @Override  
//            public void beforeTextChanged(CharSequence s, int start, int count,int after) {}  
//            @Override  
//            public void afterTextChanged(Editable s) {  
//                //��editText�иı��ֵ���õ�HashMap��  
//                hashMap.put(position, s.toString());  
//            }  
//        });  
//          
//        //���hashMap��Ϊ�գ������õ�editText  
//        if(hashMap.get(position) != null){  
//        	holder.editText.setText(hashMap.get(position));  
//        }  
		return convertView;
	}
	
	class EditListViewHolder{
		EditText editText;
	}
}
