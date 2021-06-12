package teneocto.thiemjason.newsonline.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import teneocto.thiemjason.newsonline.R;
import teneocto.thiemjason.newsonline.models.NewsDTO;
import teneocto.thiemjason.newsonline.ui.news.NewsDetail;
import teneocto.thiemjason.newsonline.utils.AppConst;
import teneocto.thiemjason.newsonline.utils.Utils;

public class Home extends AppCompatActivity {
    private ArrayList<NewsDTO> arrayList = new ArrayList<>();
    private GridView mGridView;

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

    private void addItem(){
        // DummyData
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
}