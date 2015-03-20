package com.example.androidtest.recycle_cardview;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.ClipData.Item;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidtest.R;
import com.example.androidtest.main.BaseActivity;

public class RecyclerCardViewActivity extends BaseActivity {
	
	private CardView cardView;
	private RecyclerView recyclerView;
	private MyAdapter mAdapter;
	private List<RecyclerItemObj> objs = new ArrayList<RecyclerCardViewActivity.RecyclerItemObj>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recycler_view_layout);
		
		for (int i = 0; i < 10; i++) {
			RecyclerItemObj obj = new RecyclerItemObj();
			obj.setTitleVal("2015��3��9�� ��������");
			obj.setDescsVal("ժ¼�ˡ�������Ҫ����Ѱ���������磬ȴ��˲��ò��뿪���ʱ��֧�ֻ�����ֹ�ã��������Ƽ�������������Щ��Ȥ�����ġ���Ԥ�ԡ�������������� 90 ����ѧ��Ӣ���������Ϊά��������й�������ʲô���飿����������ƽ���ܴ���ȥ�ĺ�����ʲô�Ƽ���������ʧ���Ĺ����֣��������֡�Ш�����ֵȣ��������α�����ģ����ȷ�����ĵ���ȷ�ԣ�������������Ů��������Щ�����Ʒ�ʣ����������Ѹ�Ⱦ�˰��̲�����˫����ĸ����֪������ĸ�ƻ���ô�죿���������µ�32����");
			obj.setImageUrls("card_image");
			
			objs.add(obj);
		}
		
		recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		// ���ò��ֹ���  ���� LinearLayoutManager ע��recycler ������Ϊ LinearLayout
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		// ����Item����
		recyclerView.setItemAnimator(new DefaultItemAnimator());
//		// 
//		recyclerView.setHasFixedSize(true);
		// 
		mAdapter = new MyAdapter(this, objs);
		recyclerView.setAdapter(mAdapter);
		// recycle ��ӵ���¼�  ����   
		recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnRecyclerItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				showShortToast("position...." + position);
				
			}
		}));
	}
	
	class RecyclerItemObj {
		private String titleVal;
		private String descsVal;
		private String imageUrls;
		public String getTitleVal() {
			return titleVal;
		}
		public void setTitleVal(String titleVal) {
			this.titleVal = titleVal;
		}
		public String getDescsVal() {
			return descsVal;
		}
		public void setDescsVal(String descsVal) {
			this.descsVal = descsVal;
		}
		public String getImageUrls() {
			return imageUrls;
		}
		public void setImageUrls(String imageUrls) {
			this.imageUrls = imageUrls;
		}
	}
	
	/**
	 * 
	 *  Class Name: RecyclerViewAct.java
	 *  Function:
	 *  
	 *  @author liuzheng
	 *  @version 1.0 
	 *  @created 2015��3��9�� ����11:10:07
	 *  @Copyright http://liuz.me
	 */
	class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

		private Context mContext;
		private List<RecyclerItemObj> mObjs;
		
		public MyAdapter(Context context, List<RecyclerItemObj> objs) {
			this.mContext = context;
			this.mObjs = objs;
		}
		
		@Override
		public int getItemCount() {
			return mObjs == null ? 0 : mObjs.size();
		}

		@Override
		public ViewHolder onCreateViewHolder(ViewGroup vg, int i) {
			View v = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item, vg, false);
			return new ViewHolder(v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder viewHolder, int location) {
			RecyclerItemObj obj = mObjs.get(location);
			
			viewHolder.titleTv.setText(obj.getTitleVal());
			viewHolder.descsTv.setText(obj.getDescsVal());
//			viewHolder.usrImages.setImageURI(Uri.parse(obj.imageUrls));
			viewHolder.usrImages.setImageResource(R.drawable.card_image);
		}

		class ViewHolder extends RecyclerView.ViewHolder{
			private TextView titleTv;
			private TextView descsTv;
			private ImageView usrImages;
			
			public ViewHolder(View v) {
				super(v);
				titleTv = (TextView) v.findViewById(R.id.title_tv);
				descsTv = (TextView) v.findViewById(R.id.desc_tv);
				usrImages = (ImageView) v.findViewById(R.id.usrs_image);
			}
		}
	}
}
