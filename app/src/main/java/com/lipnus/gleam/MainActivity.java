package com.lipnus.gleam;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.nfc.NfcAdapter;
import android.nfc.tech.NfcF;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    // 뷰페이저
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;


    TextView tv;
    NfcAdapter na; // NFC 어댑터
    PendingIntent pi; // 수신받은 데이터가 저장된 인텐트
    IntentFilter[] mIntentFilters; // 인텐트 필터
    String[][] mNFCTechLists;

    //음악플레이어
    MediaPlayer mp = new MediaPlayer();

    //네비게이션
    ImageView navi1, navi2, navi3, navi4, navi5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //툴바 없에기/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        //전환효과(false, true에 의해서 앞뒤의 레이어 순위가 바뀜)
        mPager.setPageTransformer(true, new DepthPageTransformer());

        //뷰페이저에 변화가 있을때의 리스너(쓰진 않음)
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                naviAllBlack();

                switch (position){
                    case 0:
                        Glide.with(getApplicationContext())
                                .load( R.drawable.icon11 )
                                .into(navi1);
                        navi1.setScaleType(ImageView.ScaleType.FIT_XY);
                        break;

                    case 1:
                        Glide.with(getApplicationContext())
                                .load( R.drawable.icon22 )
                                .into(navi2);
                        navi2.setScaleType(ImageView.ScaleType.FIT_XY);
                        break;

                    case 2:
                        Glide.with(getApplicationContext())
                                .load( R.drawable.icon55 )
                                .into(navi3);
                        navi3.setScaleType(ImageView.ScaleType.FIT_XY);
                        break;

                    case 3:
                        Glide.with(getApplicationContext())
                                .load( R.drawable.icon44 )
                                .into(navi4);
                        navi4.setScaleType(ImageView.ScaleType.FIT_XY);
                        break;

                    case 4:
//                        Glide.with(getApplicationContext())
//                                .load( R.drawable.icon33 )
//                                .into(navi5);
//                        navi5.setScaleType(ImageView.ScaleType.FIT_XY);
                        break;
                }




            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        navi1 = (ImageView) findViewById(R.id.main_navi1);
        navi2 = (ImageView) findViewById(R.id.main_navi2);
        navi3 = (ImageView) findViewById(R.id.main_navi3);
        navi4 = (ImageView) findViewById(R.id.main_navi4);
        navi5 = (ImageView) findViewById(R.id.main_navi5);

        naviAllBlack();
        Glide.with(this)
                .load( R.drawable.icon11 )
                .into(navi1);
        navi1.setScaleType(ImageView.ScaleType.FIT_XY);

        //NFC
        tv = (TextView) findViewById(R.id.textMessage);
        na = NfcAdapter.getDefaultAdapter(this); // NFC 어댑터
        if (na == null) {
            tv.setText("This phone is not NFC_enable."); // 경고 메시지로 변경 후 종료
            return;
        } // NFC 칩 존재 X
        tv.setText("Scan a NFC tag");

        Intent i = new Intent(this, getClass());
        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        pi = PendingIntent.getActivity(this, 0, i, 0);
        IntentFilter iFilter = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED); // NFC 데이터 활성화에 필요한 인텐트 필터 생성
        try {
            iFilter.addDataType("*/*");
            mIntentFilters = new IntentFilter[]{iFilter};
        } catch (Exception e) {
            tv.setText("Make IntentFilter error");
        }
        mNFCTechLists = new String[][]{new String[]{NfcF.class.getName()}};




    }


    public void naviAllBlack(){
        Glide.with(this)
                .load( R.drawable.icon1 )
                .into(navi1);
        navi1.setScaleType(ImageView.ScaleType.FIT_XY);

        Glide.with(this)
                .load( R.drawable.icon2 )
                .into(navi2);
        navi2.setScaleType(ImageView.ScaleType.FIT_XY);

        Glide.with(this)
                .load( R.drawable.icon3 )
                .into(navi3);
        navi3.setScaleType(ImageView.ScaleType.FIT_XY);

        Glide.with(this)
                .load( R.drawable.icon4 )
                .into(navi4);
        navi4.setScaleType(ImageView.ScaleType.FIT_XY);

        Glide.with(this)
                .load( R.drawable.icon5 )
                .into(navi5);
        navi5.setScaleType(ImageView.ScaleType.FIT_XY);


    }


    public void onClick_navi(View v){

        switch(v.getId()){

            case R.id.main_navi1:
                mPager.setCurrentItem(0, true);
                break;

            case R.id.main_navi2:
                mPager.setCurrentItem(1, true);
                break;

            case R.id.main_navi3:
                mPager.setCurrentItem(2, true);
                break;

            case R.id.main_navi4:
                mPager.setCurrentItem(3, true);
                break;

            case R.id.main_navi5:
                mPager.setCurrentItem(4, true);
                break;


        }

    }


    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ScreenSlidePageFragment.PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            //뷰페이저의 총 페이지수
            return 5;
        }
    }





    //===============================================================================================
    // NFC 검출부분
    //===============================================================================================

    public void detectSound(){
        mp.release();
        mp = MediaPlayer.create(this, R.raw.uwa);
        mp.start();
    }



    public void onResume() {
        super.onResume();

        if (na != null) {
            //na.enableForegroundDispatch(this, pi, null, null);
            na.enableForegroundDispatch(this, pi, null, null);
        }
    }

    public void onPause() {
        super.onPause();
        if (na != null) {
            na.disableForegroundDispatch(this);
        }
    }

    @Override
    public void onNewIntent(Intent i) {
        String action = i.getAction(); // intent에서 action 추출
        String tag = i.getParcelableExtra(NfcAdapter.EXTRA_TAG).toString(); // 태그 정보를 받아 string으로 변환
        String strMsg = action + "\n\n" + tag;
        tv.setText(strMsg);


        // NFC 태그페이지일때만 태그를 인식
        if(mPager.getCurrentItem()==0){
            Toast.makeText(getApplicationContext(), "까꿍!", Toast.LENGTH_LONG).show();
            detectSound();
            Intent intent = new Intent(getApplicationContext(),InformationActivity.class);
            startActivity(intent);
        }

    }
}
