package net.totalmadownage.zombieworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Website extends Activity {
	/** Called when the activity is first created. */
	
	WebView webview;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.website);
	
    webview = (WebView) findViewById(R.id.webview); 
    webview.setWebViewClient(new HelloWebViewClient()); 
    webview.getSettings().setJavaScriptEnabled(true); 
    webview.loadUrl("http://totalmadownage.net/wp/?page_id=569");
	
	}
	
	private class HelloWebViewClient extends WebViewClient {
	    @Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        view.loadUrl(url);
	        return true;
	    }
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
	        webview.goBack();
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}
	
}