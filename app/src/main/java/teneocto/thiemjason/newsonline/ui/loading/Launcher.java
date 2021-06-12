package teneocto.thiemjason.newsonline.ui.loading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import teneocto.thiemjason.newsonline.R;
import teneocto.thiemjason.newsonline.ui.home.Home;

public class Launcher extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}