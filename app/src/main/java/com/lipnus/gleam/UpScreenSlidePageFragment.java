package com.lipnus.gleam;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class UpScreenSlidePageFragment {


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
                    rootView = inflater.inflate(R.layout.up_fragment_screen_slide_page, container, false);
                    context = rootView.getContext();

                    iV = ((ImageView)rootView.findViewById(R.id.imageView));
                    Glide.with(this)
                            .load( R.drawable.up1 )
                            .into(iV);
                    iV.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;


                default:
                    rootView = inflater.inflate(R.layout.up_fragment_screen_slide_page, container, false);
                    context = rootView.getContext();

                    iV = ((ImageView)rootView.findViewById(R.id.imageView));
                    Glide.with(this)
                            .load( R.drawable.up2 )
                            .into(iV);
                    iV.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;

            }

            Log.d("FFF", viewNum + "번째뷰생성");
            return rootView;
        }


    }
}