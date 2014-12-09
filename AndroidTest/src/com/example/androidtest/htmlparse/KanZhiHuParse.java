package com.example.androidtest.htmlparse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

public class KanZhiHuParse {
	
	private static ArrayList<HtmlParseBean> htmlParseBeans = new ArrayList<HtmlParseBean>();
	
	public static ArrayList<HtmlParseBean> getHtmlParseBeans() {
		return htmlParseBeans;
	}
	
	public static void getContentHtml() {
		try {
			Document document = Jsoup.parse(new java.net.URL(Constants.KANZHIHU_URL), 5000);
//			System.out.println(document.outerHtml());  // ����html �ĵ�
			
			Elements elements = document.select("article");
			System.out.println(elements.size()+"\n===============================================");
//			Element allElement = elements.get(0);// �ܽڵ�
//			System.out.println(element.outerHtml());// ĳһ�� article ��html ����
			
			for (int i = 0; i < elements.size(); i++) {
				Element allElement = elements.get(i);
				articleHtmlParse(allElement);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 *  Function:�������ݽ���
	 *  @author liuzheng
	 *  @created 2014-12-2 ����2:58:58 
	 *  @param allElement 
	 */
	private static void articleHtmlParse(Element allElement) {
		HtmlParseBean htmlParseBean = new HtmlParseBean();
		
		Elements elements = null;
		//////////////////////image link//////////////////////////////////
		elements = allElement.select("div[class=post-thumbnail]"); // ���� ͼƬ ����
		
		// get html id
		String articalCSSIdVal = allElement.attr("id");// ��ȡ article id ����ֵ
		int length = articalCSSIdVal.length();
		String articalCSSIdValId = articalCSSIdVal.substring(length-4, length);
//		System.out.println(articalCSSIdVal + "...get attr val..." + articalCSSIdValId);
		
		htmlParseBean.setHtmlId(articalCSSIdValId);
		
		Element linkImageElement = elements.get(0);// ĳһ�� div[class=post-thumbnail] ��html ����
		elements = linkImageElement.getElementsByTag("a");// a ����
		linkImageElement = elements.get(0);// ��ȡ a ��ǩ��ֵ
//		System.out.println(linkImageElement.attr("title") +"_________"+ linkImageElement.attr("href"));// ��ȡ a ��ǩ��title and href ֵ
		
		htmlParseBean.setHtmlImageTitle(linkImageElement.attr("title"));
		htmlParseBean.setHtmlUrl(linkImageElement.attr("href"));
		
		elements = linkImageElement.getElementsByTag("img");// a ����
		linkImageElement = elements.get(0);// ��ȡ image ��ǩ��ֵ
//		System.out.println(linkImageElement.attr("width") +"_________"+ linkImageElement.attr("height") +"_________"+ linkImageElement.attr("src"));// ��ȡ a ��ǩ��title and href ֵ
		
		htmlParseBean.setHtmlImageUrl(linkImageElement.attr("src"));
		
		///////////////////////////post date catagory/////////////////////////////
		elements = allElement.select("div[class=post-meta group]"); // ����ʱ��   ���ݷ��� 
		Element postGroupElement = elements.get(0);
		//System.out.println(postGroupElement.outerHtml());// 
		
		elements = postGroupElement.select("p[class=post-category]"); // ���ݷ���
		Element groupElement = elements.get(0);// �������ӽڵ�
		Elements cataElements = groupElement.getElementsByTag("a"); // �������ӽڵ� �е� a ��ǩ
		Elements dateElements = postGroupElement.select("p[class=post-date]"); // ����ʱ��
//		System.out.println(cataElements.get(0).text() +"_________"+ cataElements.get(0).attr("href") +"_______" + dateElements.text());// ���ݷ��� ���� ����ʱ��
		
		htmlParseBean.setHtmlCataName(cataElements.get(0).text());
		htmlParseBean.setHtmlCataUrl(cataElements.get(0).attr("href"));
		
		htmlParseBean.setHtmlType(cataElements.get(0).text());
		htmlParseBean.setHtmlTime(dateElements.text());
		
		/////////////////////////post title///////////////////////////////
		elements = allElement.select("h2[class=post-title]");// �������ϸ��������
		Element postTitleElement = elements.get(0);
//		System.out.println(postTitleElement.text() +"_________"+ postTitleElement.getElementsByTag("a").attr("href"));
		
		htmlParseBean.setHtmlTitle(postTitleElement.text());
		htmlParseBean.setHtmlUrl(postTitleElement.getElementsByTag("a").attr("href"));
		
		////////////////////////////////////////////////////////
		elements = allElement.select("div[class=entry excerpt]"); // ���ݼ�����
		Element descElement = elements.get(0); // 
//		System.out.println("_________"+ descElement.getElementsByTag("p").text());
		
		htmlParseBean.setHtmlDesc(descElement.getElementsByTag("p").text());
		
		Log.i("liuz", htmlParseBean.toString());
		
		// 
		htmlParseBeans.add(htmlParseBean);
		////////////////////////////////////////////////////////
	}
}
