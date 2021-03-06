package com.example.androidtest.sliding;

import com.example.androidtest.R;
import com.example.androidtest.main.BaseActivity;
import com.example.androidtest.sliding.SlidingPaneLayoutLeftFragment.onLeftItemClick;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v4.widget.SlidingPaneLayout.PanelSlideListener;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * 
 * @author liuzheng
 * @date 2014-10-27 ����4:17:59
 * http://my.oschina.net/summerpxy/blog/211835
 */
public class SlidingPaneLayoutAct extends BaseActivity implements onLeftItemClick {
	
	private SlidingPaneLayout slidingPaneLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.sliding_panel_layout);
		
		slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.sliding_pane_lay);

		onItemClick("http://www.gfsoso.com");
	}

	@Override
	public void onItemClick(String url) {
		SlidingPaneLayoutRightFragment sprf = (SlidingPaneLayoutRightFragment) SlidingPaneLayoutAct.this.getFragmentManager().findFragmentById(R.id.right_panelayout);
		// ��ȡwebview
		WebView webView = sprf.getWebView();
		WebSettings ws = webView.getSettings();
		ws.setJavaScriptEnabled(true);
		WebViewClient client = new WebViewClient();
        webView.setWebViewClient(client);
        webView.loadUrl(url);
		
        toggleSlidingPanel();
	}

	public void toggleSlidingPanel() {
		if (slidingPaneLayout.isOpen()) {
			slidingPaneLayout.closePane();
		}else {
			slidingPaneLayout.openPane();
		}
	}
	
	@Override
	protected void leftBtnListener() {
		toggleSlidingPanel();
	}
}
