package com.lipnus.gleam;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class IntroActivity extends AppCompatActivity implements SurfaceHolder.Callback {

    //영상에 필요한 것
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    MediaPlayer mediaPlayer;

    ImageView kakaoBtn;
    ImageView naverBtn;
    ImageView logoIv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        //툴바 없에기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // surfaceView 등록
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();

        // Activity로 Video Stream 전송 등록
        surfaceHolder.addCallback(this);

        //연결
        kakaoBtn = (ImageView) findViewById(R.id.intro_kakao);
        naverBtn = (ImageView) findViewById(R.id.intro_naver);
        logoIv = (ImageView) findViewById(R.id.intro_logo);


        //이미지 등록
        Glide.with(this)
                .load( R.drawable.kakao )
                .into(kakaoBtn);

        Glide.with(this)
                .load( R.drawable.naver )
                .into(naverBtn);

        Glide.with(this)
                .load( R.drawable.logo )
                .into(logoIv);
        logoIv.setScaleType(ImageView.ScaleType.FIT_XY);

    }


    // 버튼클릭
    public void onClick_gotoMain(View v){
        Log.d("AAAA", "버튼클릭");
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }





    //==============================================================================================
    // 동영상재생에 필요한 서퍼스뷰 Interface때문에 꼭 Override해줘야 하는 것들
    //==============================================================================================
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        /**
         * surface 생성
         */
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
        } else {
            mediaPlayer.reset();
        }

        try {
            // local resource : raw에 포함시켜 놓은 리소스 호출
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.cham2);
            mediaPlayer.setDataSource(this, uri);

            mediaPlayer.setDisplay(holder);                                    // 화면 호출
            mediaPlayer.prepare();                                             // 비디오 load 준비
            mediaPlayer.setOnCompletionListener(completionListener);        // 비디오 재생 완료 리스너
            mediaPlayer.start(); //준비가 완료되면 시작한다

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {

        //비디오재생이 끝났을때
        @Override
        public void onCompletion(MediaPlayer mp) {
            //다시시작!
            mediaPlayer.seekTo(0);
            mediaPlayer.start();
        }
    };


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }


}
