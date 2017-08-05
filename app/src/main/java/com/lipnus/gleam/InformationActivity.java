package com.lipnus.gleam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class InformationActivity extends AppCompatActivity {

    ImageView backgroundIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        //툴바 없에기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        backgroundIv = (ImageView)findViewById(R.id.infomation_background);
        Glide.with(this)
                .load( R.drawable.ruby )
                .into(backgroundIv);
        backgroundIv.setScaleType(ImageView.ScaleType.FIT_XY);

    }
}
