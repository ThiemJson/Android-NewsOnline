package teneocto.thiemjason.newsonline.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

import teneocto.thiemjason.newsonline.R;
import teneocto.thiemjason.newsonline.models.NewsDTO;
import teneocto.thiemjason.newsonline.ui.news.NewsDetail;
import teneocto.thiemjason.newsonline.utils.AppConst;
import teneocto.thiemjason.newsonline.utils.Utils;

public class Home extends AppCompatActivity {
    private ArrayList<NewsDTO> arrayList = new ArrayList<>();
    private GridView mGridView;
    private AdView adView1;
    private AdView adView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.mGridView = findViewById(R.id.home_gridview);

        addItem();

        mGridView.setAdapter(new HomeAdapter(arrayList));
        mGridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(), NewsDetail.class);
            intent.putExtra(AppConst.NEWS_URL, arrayList.get(position).getUrl());
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadAd();
    }

    @Override
    protected void onPause() {
        super.onPause();
        adView1.destroy();
        adView2.destroy();
    }

    private void addItem(){
        // DummyData
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.xosomienbac, "https://xsmb.me/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.xosomiennam, "https://xsmn.me/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.soxomientrung, "https://xsmn.me/xsmt-sxmt-kqxsmt-ket-qua-xo-so-mien-trung.html"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.vietlott, "https://www.minhngoc.net.vn/ket-qua-xo-so/dien-toan-vietlott.html"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.vtv1, "https://vtv.vn/truyen-hinh-truc-tuyen/vtv1.htm"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.vtv2, "https://vtv.vn/truyen-hinh-truc-tuyen/vtv2.htm"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.vtv3, "https://vtv.vn/truyen-hinh-truc-tuyen/vtv3.htm"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.vtv4, "https://vtv.vn/truyen-hinh-truc-tuyen/vtv4.htm"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.vtv5, "https://vtv.vn/truyen-hinh-truc-tuyen/vtv5.htm"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.vtv6, "https://vtv.vn/truyen-hinh-truc-tuyen/vtv6.htm"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.vtv7, "https://vtv.vn/truyen-hinh-truc-tuyen/vtv7.htm"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.baomoi, "https://baomoi.com/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.bongdaplus, "https://bongdaplus.vn/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.dantri, "https://dantri.com.vn/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.genk, "https://genk.vn/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.kenh14, "https://kenh14.vn/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.nguoiduatin, "https://www.nguoiduatin.vn/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.nguoilaodong, "https://nld.com.vn//"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.nhandan, "https://nhandan.vn/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.thanhnien, "https://thanhnien.vn/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.tinhte, "https://tinhte.vn/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.tinmoi, "https://tinmoi.vn/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.tuoitre, "https://tuoitre.vn/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.vietnamnet, "https://vietnamnet.vn/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.vietnamplus, "https://www.vietnamplus.vn/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.vnexpress, "https://vnexpress.net/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.vnreview, "https://vnreview.vn/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.vov, "https://vov.vn/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.vtc, "https://vtc.vn/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.xaluan, "https://www.xaluan.com/"));
        arrayList.add(new NewsDTO(Utils.getRandomUUID(), R.drawable.zing, "https://zingnews.vn/"));
    }

    /**
     * Init Google AdsMob
     */
    void loadAd() {
        MobileAds.initialize(this, initializationStatus -> {
        });

        adView1 = findViewById(R.id.home_web_view_ads_view);
        adView2 = findViewById(R.id.home_web_view_ads_view_2);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView1.loadAd(adRequest);
        adView2.loadAd(adRequest);
    }
}