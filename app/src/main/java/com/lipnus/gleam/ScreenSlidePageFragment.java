package com.lipnus.gleam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ScreenSlidePageFragment {


    public static class PlaceholderFragment extends Fragment {

        //현재 어느페이지인지
        private static final String ARG_SECTION_NUMBER = "section_number";

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);

            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            int viewNum = getArguments().getInt(ARG_SECTION_NUMBER);
            View rootView;
            final ImageView iV, reverseIv;
            final Context context;


            switch(viewNum){
                case 1:
                    rootView = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
                    context = rootView.getContext();

                    iV = ((ImageView)rootView.findViewById(R.id.imageView));
                    Glide.with(this)
                            .load( R.drawable.m1 )
                            .into(iV);
                    iV.setScaleType(ImageView.ScaleType.FIT_XY);

                    reverseIv = ((ImageView)rootView.findViewById(R.id.reverseIv));
                    Glide.with(this)
                            .load( R.drawable.reverse2 )
                            .into(reverseIv);
                    iV.setScaleType(ImageView.ScaleType.FIT_XY);

                    reverseIv.setOnClickListener(new Button.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // TODO : click event
                            Log.d("FFFF", "반전");
                        }
                    });
                    break;


                case 2:
                    rootView = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
                    context = rootView.getContext();

                    iV = ((ImageView)rootView.findViewById(R.id.imageView));
                    Glide.with(this)
                            .load( R.drawable.m2 )
                            .into(iV);
                    iV.setScaleType(ImageView.ScaleType.FIT_XY);

                    reverseIv = ((ImageView)rootView.findViewById(R.id.reverseIv));
                    Glide.with(this)
                            .load( R.drawable.reverse2 )
                            .into(reverseIv);
                    iV.setScaleType(ImageView.ScaleType.FIT_XY);

                    iV.setOnClickListener(new Button.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // TODO : click event
                            Intent intent = new Intent(context, SearchActivity.class);
                            startActivity(intent);
                        }
                    });
                    break;

                case 3:
                    rootView = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
                    context = rootView.getContext();

                    iV = ((ImageView)rootView.findViewById(R.id.imageView));
                    Glide.with(this)
                            .load( R.drawable.m3 )
                            .into(iV);
                    iV.setScaleType(ImageView.ScaleType.FIT_XY);

                    reverseIv = ((ImageView)rootView.findViewById(R.id.reverseIv));
                    Glide.with(this)
                            .load( R.drawable.reverse2 )
                            .into(reverseIv);
                    iV.setScaleType(ImageView.ScaleType.FIT_XY);

                    iV.setOnClickListener(new Button.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // TODO : click event
                            Intent intent = new Intent(context,MypageActivity.class);
                            startActivity(intent);
                        }
                    });
                    break;

                case 4:
                    rootView = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
                    context = rootView.getContext();

                    iV = ((ImageView)rootView.findViewById(R.id.imageView));
                    Glide.with(this)
                            .load( R.drawable.m4 )
                            .into(iV);
                    iV.setScaleType(ImageView.ScaleType.FIT_XY);

                    reverseIv = ((ImageView)rootView.findViewById(R.id.reverseIv));
                    Glide.with(this)
                            .load( R.drawable.reverse2 )
                            .into(reverseIv);
                    iV.setScaleType(ImageView.ScaleType.FIT_XY);

                    iV.setOnClickListener(new Button.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // TODO : click event
                            Intent intent = new Intent(context, MirrorActivity.class);
                            startActivity(intent);
                        }
                    });
                    break;

                default:
                    rootView = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);

                    iV = ((ImageView)rootView.findViewById(R.id.imageView));
                    Glide.with(this)
                            .load( R.drawable.setting )
                            .into(iV);
                    iV.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
            }

            Log.d("FFF", viewNum + "번째뷰생성");
            return rootView;
        }


    }
}