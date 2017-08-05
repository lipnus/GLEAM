package com.lipnus.gleam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class SearchActivity extends AppCompatActivity {

    ImageView backIv;
    EditText searchEt;
    private VoiceRecognition voiceRecognition;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        context = this;

        //툴바 없에기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        backIv = (ImageView) findViewById(R.id.search_background);
        searchEt = (EditText) findViewById(R.id.search_et);

        Glide.with(this).
                load(R.drawable.searchback).
                into(backIv);
        backIv.setScaleType(ImageView.ScaleType.FIT_XY);

        //검색버튼 눌렀을 때
        searchEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {


                switch (i) {
                    case EditorInfo.IME_ACTION_SEARCH:

                        //검색버튼
                        Log.d("AAAA", "으으");
                        moveToCompare();
                        break;

                    default:
                        //엔터키
                        Log.d("AAAA", "으으");
                        moveToCompare();
                        break;
                }
                return true;

            }
        });
    }

    public void moveToCompare(){
        Intent intent = new Intent(getApplicationContext(), CompareActivity.class);
        startActivity(intent);
    }

    // 음성인식
    public void onClick_voice(View v){
        startVoiceRecognition();
    }



    public void inputVoice(String input){
        searchEt.setText(input);
        moveToCompare();
    }


    // 음성 인식 시작
    private void startVoiceRecognition() {

        voiceRecognition = new VoiceRecognition(this);

        if (voiceRecognition.recognitionAvailable()) {

            Intent intent = voiceRecognition
                    .getVoiceRecognitionIntent("Speak now");

            startActivityForResult(intent,
                    voiceRecognition.VOICE_RECOGNITION_REQUEST_CODE);

        } else {
            Toast toast = Toast.makeText(this,
                    "Voice recognition is not available.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    // 음성 인식 결과
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode ==
                voiceRecognition.VOICE_RECOGNITION_REQUEST_CODE
                && resultCode == -1) {

            String result = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS).get(0);
            // 이 부분에서 result 를 가지고 검색을 하거나, 명령을 실행 하면 됨


            inputVoice(result);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
