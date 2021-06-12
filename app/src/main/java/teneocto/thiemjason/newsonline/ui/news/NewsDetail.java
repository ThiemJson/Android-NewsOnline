package teneocto.thiemjason.newsonline.ui.news;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import teneocto.thiemjason.newsonline.R;
import teneocto.thiemjason.newsonline.ui.progressdialog.CustomProgressDialog;
import teneocto.thiemjason.newsonline.utils.AppConst;

public class NewsDetail extends AppCompatActivity {
    CustomProgressDialog customProgressDialog;
    WebView mWebView;
    AdView adView1;
    AdView adView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        customProgressDialog = new CustomProgressDialog(this);

        mWebView = findViewById(R.id.news_web_view);
        loadAd();
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

    /**
     * Init Google AdsMob
     */
    void loadAd() {
        MobileAds.initialize(this, initializationStatus -> {
        });

        adView1 = findViewById(R.id.news_web_view_ads_view);
        adView2 = findViewById(R.id.news_web_view_ads_view_top);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView1.loadAd(adRequest);
        adView2.loadAd(adRequest);
    }

    @Override
    protected void onDestroy() {
        adView1.destroy();
        adView2.destroy();
        super.onDestroy();
    }
}