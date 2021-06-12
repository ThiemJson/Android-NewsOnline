package teneocto.thiemjason.newsonline.ui.home;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

import teneocto.thiemjason.newsonline.R;
import teneocto.thiemjason.newsonline.models.NewsDTO;
import teneocto.thiemjason.newsonline.utils.Utils;

public class HomeAdapter extends BaseAdapter {
    private ArrayList<NewsDTO> arrayList = new ArrayList<>();

    public HomeAdapter(ArrayList<NewsDTO> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1
        final NewsDTO newsDTO = arrayList.get(position);

        // 2
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.home_news_item, null);
        }

        // 3
        ImageView imageView = convertView.findViewById(R.id.home_news_item_image);
        imageView.setImageResource(arrayList.get(position).getImage());

        return convertView;
    }
}
