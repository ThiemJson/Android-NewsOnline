package teneocto.thiemjason.newsonline.ui.news;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import teneocto.thiemjason.newsonline.R;
import teneocto.thiemjason.newsonline.ui.progressdialog.CustomProgressDialog;
import teneocto.thiemjason.newsonline.utils.AppConst;

public class NewsDetail extends AppCompatActivity {
    CustomProgressDialog customProgressDialog;
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        customProgressDialog = new CustomProgressDialog(this);

        mWebView = findViewById(R.id.news_web_view);
        webViewInitial();
    }

    /**
     * Initial WebView
     */
    private void webViewInitial() {
        Bundle bundle = getIntent().getExtras();
        String notificationURL = bundle.getString(AppConst.NEWS_URL);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                customProgressDialog.deleteProgressDialog();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        mWebView.loadUrl(notificationURL);
    }
}