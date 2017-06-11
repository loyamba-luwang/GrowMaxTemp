package com.example.loya.growmaxtemp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import static com.example.loya.growmaxtemp.R.attr.logo;

public class MainActivity extends AppCompatActivity {
    public static WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

/*        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
       // setSupportActionBar(toolbar);
*/


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.liclogo2);
        setTitle("  GrowMax-DO Login  ");





        webview = new WebView(this);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDomStorageEnabled(true);
        //if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
        //webview.getSettings().setAllowUniversalAccessFromFileURLs(true);
        //webview.getSettings().setAllowFileAccessFromFileURLs(true);
        //}
        //webview.addJavascriptInterface(new PremCalc(this), "Premium");
        webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webview.requestFocusFromTouch();
        //webview.setWebViewClient(new WebViewClient());
        webview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                webview.loadUrl("https://customer.onlinelic.in/BusinessReports/portlets/growmax/begin.do");
                Toast.makeText(getBaseContext(), description+" Please Ensure Internet Connection is turned on", Toast.LENGTH_SHORT).show();
            }
        });
        //webview.setWebChromeClient(new WebChromeClient());
       webview.loadUrl("https://customer.onlinelic.in/BusinessReports/portlets/growmax/begin.do");
        //webview.loadUrl("https://www.google.com");
        setContentView(webview);
    }
}
