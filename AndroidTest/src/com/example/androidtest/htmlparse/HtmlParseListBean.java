package com.example.androidtest.htmlparse;

import java.io.Serializable;

/**
 * 
 * Class Name: HtmlParseBean.java Function:
 * 
 * @author liuzheng
 * @version 1.0
 * @created 2014-11-25 ����11:28:11
 * @Copyright http://liuz.me
 */
public class HtmlParseListBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String htmlId; // ���
	private String htmlTitle;// ����
	private String htmlDesc; // ���ݼ���
	private String htmlType; // ��ǩ���� (�������š���ʷ��������������)
	private String htmlTime; // ����ʱ��
	private String htmlUrl; // ��������
	private String htmlImageTitle;//
	private String htmlImageUrl; // ����ͼƬ����
	private String htmlCataName; // ����Ŀ¼����
	private String htmlCataUrl; // ����Ŀ¼����

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

	public String getHtmlImageTitle() {
		return htmlImageTitle;
	}

	public void setHtmlImageTitle(String htmlImageTitle) {
		this.htmlImageTitle = htmlImageTitle;
	}

	public String getHtmlUrl() {
		return htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	public String getHtmlImageUrl() {
		return htmlImageUrl;
	}

	public void setHtmlImageUrl(String htmlImageUrl) {
		this.htmlImageUrl = htmlImageUrl;
	}

	public String getHtmlCataName() {
		return htmlCataName;
	}

	public void setHtmlCataName(String htmlCataName) {
		this.htmlCataName = htmlCataName;
	}

	public String getHtmlCataUrl() {
		return htmlCataUrl;
	}

	public void setHtmlCataUrl(String htmlCataUrl) {
		this.htmlCataUrl = htmlCataUrl;
	}
	
	@Override
	public String toString() {
		return htmlId + "#" + htmlCataName + "#" + htmlCataUrl + "#" + htmlDesc + "#" + htmlTime;
	}

}
