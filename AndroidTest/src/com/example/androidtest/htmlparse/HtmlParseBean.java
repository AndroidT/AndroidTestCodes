package com.example.androidtest.htmlparse;

import java.io.Serializable;

/**
 * 
 * Class Name: HtmlParseBean.java Function:
 * 
 * @author liuzheng
 * @version 1.0
 * @created 2014-11-25 ����11:28:11
 * @Copyright �����Ƽ����Ϸֹ�˾
 */
public class HtmlParseBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private String htmlId;   // ���
	private String htmlTitle;// ����
	private String htmlDesc; // ���ݼ���
	private String htmlType; // ��ǩ���� (�������š���ʷ��������������)
	private String htmlTime; // ����ʱ��

	
	public String getHtmlId() {
		return htmlId;
	}
	
	public void setHtmlId(String htmlId) {
		this.htmlId = htmlId;
	}
	
	public String getHtmlTitle() {
		return htmlTitle;
	}

	public void setHtmlTitle(String htmlTitle) {
		this.htmlTitle = htmlTitle;
	}

	public String getHtmlDesc() {
		return htmlDesc;
	}
	
	public void setHtmlDesc(String htmlDesc) {
		this.htmlDesc = htmlDesc;
	}
	
	public String getHtmlType() {
		return htmlType;
	}

	public void setHtmlType(String htmlType) {
		this.htmlType = htmlType;
	}

	public String getHtmlTime() {
		return htmlTime;
	}

	public void setHtmlTime(String htmlTime) {
		this.htmlTime = htmlTime;
	}

}
