package com.example.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * TextView ��ʾ html ����
 */
public class HtmlTextViewAct extends Activity implements OnClickListener {

	// String htmlString =
	// \"  <div id=\\"main\\">    <form id=\\"taxlawDetail\\" name=\\"taxlawDetail\\" action=\\"/taxlawDetail.action\\" method=\\"post\\">     <h2>������ ����˰���ֹܾ��ڶԿ��е�λȡ�õļ���ת����������Ӫҵ˰��֪ͨ</h2>     <h3>��1994����˰�ֵ�10��</h3>     <dl>      <span id=\\"lawyxx\\">����ʧЧ</span>&nbsp;&nbsp;�������ڣ�1994-06-03      <br /> ���壺      <a href=\\"javascript:changeFontSize(1);\\">����</a> &nbsp;      <a href=\\"javascript:changeFontSize(0);\\">���С�</a> &nbsp;      <a href=\\"javascript:changeFontSize(-1);\\">��С��</a>     </dl>     <div id=\\"content\\">      <div class=\\"TextContentDuanLuo\\">       &nbsp;&nbsp;&nbsp;&nbsp;���ݹ���Ժ�������о���˰���Ƹĸ﷽����̨���й�����Ļ����Ҫ�������ġ�1994��42���ļ����ľ������־ͼ���ת������Ӫҵ˰����֪ͨ���£�      </div>      <div class=\\"TextContentDuanLuo\\">       &nbsp;&nbsp;&nbsp;&nbsp;һ��Ϊ�˹��������������ƹ㣬�Կ��е�λȡ�õļ���ת����������Ӫҵ˰��      </div>      <div class=\\"TextContentDuanLuo\\">       &nbsp;&nbsp;&nbsp;&nbsp;������֪ͨ��˵�ļ���ת�ã���ָ�г�ת��ר����ר������������Ȩ��ʹ��Ȩ����Ϊ��      </div>      <div class=\\"TextContentDuanLuo\\">       &nbsp;&nbsp;&nbsp;&nbsp;�������е�λת�ü�����Ӧ�ָ�����ί�����г�����������ߵļ�����ͬ�϶��Ǽ�֤����������˰�����������롣������˰����������׼�󣬷�����������Ӫҵ˰�չˡ�      </div>      <div class=\\"TextContentDuanLuo\\">
	// &nbsp;&nbsp;&nbsp;&nbsp;�ġ����涨��1994��1��1����ִ�С������·�֮ǰ�����յ�Ӫҵ˰�˻������е�λ�� </div>
	// <br /> </div> </form> </div> \";
	// String htmlString =
	// \"<div id=\\"content\\">      <div class=\\"TextContentDuanLuo\\">       &nbsp;&nbsp;&nbsp;&nbsp;���ݹ���Ժ�������о���˰���Ƹĸ﷽����̨���й�����Ļ����Ҫ�������ġ�1994��42���ļ����ľ������־ͼ���ת������Ӫҵ˰����֪ͨ���£�      </div>      <div class=\\"TextContentDuanLuo\\">       &nbsp;&nbsp;&nbsp;&nbsp;һ��Ϊ�˹��������������ƹ㣬�Կ��е�λȡ�õļ���ת����������Ӫҵ˰��      </div>      <div class=\\"TextContentDuanLuo\\">       &nbsp;&nbsp;&nbsp;&nbsp;������֪ͨ��˵�ļ���ת�ã���ָ�г�ת��ר����ר������������Ȩ��ʹ��Ȩ����Ϊ��      </div>      <div class=\\"TextContentDuanLuo\\">       &nbsp;&nbsp;&nbsp;&nbsp;�������е�λת�ü�����Ӧ�ָ�����ί�����г�����������ߵļ�����ͬ�϶��Ǽ�֤����������˰�����������롣������˰����������׼�󣬷�����������Ӫҵ˰�չˡ�      </div>      <div class=\\"TextContentDuanLuo\\">
	// &nbsp;&nbsp;&nbsp;&nbsp;�ġ����涨��1994��1��1����ִ�С������·�֮ǰ�����յ�Ӫҵ˰�˻������е�λ�� </div>
	// \";
	
	String htmlString = "&#60;div id=\"content\"&#62;      &#60;div class=\"TextContentDuanLuo\"&#62;       &nbsp;&nbsp;&nbsp;&nbsp;���ݹ���Ժ&#174;�����о���˰���Ƹĸ﷽����̨���й�����Ļ����Ҫ&#175;�����ġ�1994��42���ļ����ľ������־ͼ���ת������Ӫҵ˰����֪ͨ���£�      &#60;&#47;div&#62;      &#60;div class=\"TextContentDuanLuo\"&#62;       &nbsp;&nbsp;&nbsp;&nbsp;һ��Ϊ�˹��������������ƹ㣬�Կ��е�λȡ�õļ���ת����������Ӫҵ˰��      &#60;&#47;div&#62;      &#60;div class=\"TextContentDuanLuo\"&#62;       &nbsp;&nbsp;&nbsp;&nbsp;������֪ͨ��˵�ļ���ת�ã���ָ�г�ת��ר����ר������������Ȩ��ʹ��Ȩ����Ϊ��      &#60;&#47;div&#62;      &#60;div class=\"TextContentDuanLuo\"&#62;       &nbsp;&nbsp;&nbsp;&nbsp;�������е�λת�ü�����Ӧ�ָ�����ί�����г�����������ߵļ�����ͬ�϶��Ǽ�֤����������˰�����������롣������˰����������׼�󣬷�����������Ӫҵ˰�չˡ�      &#60;&#47;div&#62;      &#60;div class=\"TextContentDuanLuo\"&#62;       &nbsp;&nbsp;&nbsp;&nbsp;�ġ����涨��1994��1��1����ִ�С������·�֮ǰ�����յ�Ӫҵ˰�˻������е�λ��      &#60;&#47;div&#62; ";
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		ScrollView scrollView = new ScrollView(this);
		scrollView.setLayoutParams(new ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.FILL_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT));

		LinearLayout layout = new LinearLayout(this);
		layout.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));
		layout.setOrientation(LinearLayout.VERTICAL);

		LinearLayout btnLayout = new LinearLayout(this);
		btnLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));
		Button button1 = new Button(this);
		button1.setId(1);
		button1.setText("��");
		button1.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
		button1.setOnClickListener(this);
		btnLayout.addView(button1);

		Button button2 = new Button(this);
		button2.setId(2);
		button2.setText("��");
		button2.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
		button2.setOnClickListener(this);
		btnLayout.addView(button2);

		Button button3 = new Button(this);
		button3.setId(3);
		button3.setText("С");
		button3.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
		button3.setOnClickListener(this);
		btnLayout.addView(button3);

		layout.addView(btnLayout);

		textView = new TextView(this);
		textView.setLayoutParams(new ViewGroup.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

		textView.setText(Html.fromHtml("<div id=\"content\"><div class=\"TextContentDuanLuo\">       &nbsp;&nbsp;&nbsp;&nbsp;���ݹ���Ժ�������о���˰���Ƹĸ﷽����̨���й�����Ļ����Ҫ�������ġ�1994��42���ļ����ľ������־ͼ���ת������Ӫҵ˰����֪ͨ���£�</div>   <div class=\"TextContentDuanLuo\">  	&nbsp;&nbsp;&nbsp;&nbsp;һ��Ϊ�˹��������������ƹ㣬�Կ��е�λȡ�õļ���ת����������Ӫҵ˰��  	</div>   <div class=\"TextContentDuanLuo\"> &nbsp;&nbsp;&nbsp;&nbsp;������֪ͨ��˵�ļ���ת�ã���ָ�г�ת��ר����ר������������Ȩ��ʹ��Ȩ����Ϊ��  	</div>   <div class=\"TextContentDuanLuo\">&nbsp;&nbsp;&nbsp;&nbsp;�������е�λת�ü�����Ӧ�ָ�����ί�����г�����������ߵļ�����ͬ�϶��Ǽ�֤����������˰�����������롣������˰����������׼�󣬷�����������Ӫҵ˰�չˡ�</div>  	<div class=\"TextContentDuanLuo\"> &nbsp;&nbsp;&nbsp;&nbsp;�ġ����涨��1994��1��1����ִ�С������·�֮ǰ�����յ�Ӫҵ˰�˻������е�λ��</div> </div>"));

		layout.addView(textView);
		scrollView.addView(layout);

		setContentView(scrollView);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case 1:
			textView.setTextSize(18f);
			break;
		case 2:
			textView.setTextSize(16f);
			break;
		case 3:
			textView.setTextSize(14f);
			break;
		}
	}
}
