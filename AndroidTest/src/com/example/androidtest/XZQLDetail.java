package com.example.androidtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class XZQLDetail extends Activity {

	private LinearLayout topLayout, centerLayout, bottomLayout;

	private LayoutInflater inflater;

	// ///
	private LinearLayout zfcgLayout;
	private LinearLayout infoTechProLayout;
	private LinearLayout meetPathLayoutNotByOfficeLayout;
	private LinearLayout officialAdmitNotLogistLayout;
	
	// ///
	private TextView zfcgUseUnit, zfcgByYear, zfcgFee;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.xzql_detail);

		inflater = LayoutInflater.from(this);

		topLayout = (LinearLayout) findViewById(R.id.table_lay1);
		centerLayout = (LinearLayout) findViewById(R.id.table_lay2);
		bottomLayout = (LinearLayout) findViewById(R.id.table_lay3);

		// initZFCGLayout();
		// initInfoTechProLayout();
		// initMeetPathNotByOfficeLayout();
		initOfficialAdmitNotByLogisticsLayout();

		// if (zfcgLayout!=null) {
		// centerLayout.removeAllViews();
		// centerLayout.addView(zfcgLayout);
		//
		// zfcgUseUnit.setText("��ɳ�е�˰����Ϣ����");
		// zfcgByYear.setText("2014��");
		// zfcgFee.setText("186500Ԫ");
		//
		// zfcgFee.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// startActivity(new Intent(XZQLDetail.this, ZFCGDetail.class));
		// }
		// });
		// }

		removeAddView(officialAdmitNotLogistLayout);
	}

	private void removeAddView(LinearLayout layout) {
		if (layout != null) {
			centerLayout.removeAllViews();
			centerLayout.addView(layout);
		}
	}

	// ��Ϣ����������
	private void initInfoTechProLayout() {
		infoTechProLayout = (LinearLayout) inflater.inflate(R.layout.info_tech_pro_desc, null);
	}

	// �����ɹ�
	private void initZFCGLayout() {
		zfcgLayout = (LinearLayout) inflater.inflate(R.layout.zfcg_desc, null);

		zfcgUseUnit = (TextView) zfcgLayout.findViewById(R.id.zfcg_user_unit_tv);
		zfcgByYear = (TextView) zfcgLayout.findViewById(R.id.zfcg_by_year_tv);
		zfcgFee = (TextView) zfcgLayout.findViewById(R.id.zfcg_fee_tv);
	}

	// �����������(�ǰ칫�ҷ���)
	private void initMeetPathNotByOfficeLayout() {
		meetPathLayoutNotByOfficeLayout = (LinearLayout) inflater.inflate(R.layout.meet_path_n_office_desc, null);
	}

	// ����Ӵ�����(�Ǻ��ڷ���)
	private void initOfficialAdmitNotByLogisticsLayout() {
		officialAdmitNotLogistLayout = (LinearLayout) inflater.inflate(R.layout.official_admit_n_logist_desc, null);
	}
}
