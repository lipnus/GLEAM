package com.lipnus.gleam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MypageActivity extends AppCompatActivity {

    ImageView backIv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        //툴바 없에기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        backIv = (ImageView) findViewById(R.id.mypage_background);

        Glide.with(this).
                load(R.drawable.box).
                into(backIv);
        backIv.setScaleType(ImageView.ScaleType.FIT_XY);

    }

    public void onClick_mypage(View v){
        Intent intent = new Intent(getApplicationContext(),ListActivity.class);
        startActivity(intent);
    }


}
