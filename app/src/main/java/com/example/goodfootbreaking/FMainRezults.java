package com.example.goodfootbreaking;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class FMainRezults extends Fragment {


    private ViewPager mViewPager;
    PagerAdapter pagerAdapter;
    private static Pupils curPupil;



    public FMainRezults() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fmain_rezults, container, false);

        curPupil = (Pupils) this.getArguments().getSerializable("curPupil");
        mViewPager = (ViewPager) view.findViewById(R.id.MyRezultPager);
        pagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View v, float pos) {
                final float opacity = Math.abs(Math.abs(pos) - 1);
                v.setAlpha(opacity);
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                TextView ratingtext = (TextView) getActivity().findViewById(R.id.ratingtext);
                switch (position) {
                    case 0:
                        ratingtext.setText(String.valueOf("FREZZE RATING - " + curPupil.frezze_rating) + "%");
                        break;
                    case 1:
                        ratingtext.setText(String.valueOf("POWER RATING - " + curPupil.powermove_rating) + "%");
                        break;
                    case 2:
                        ratingtext.setText(String.valueOf("ОФП RATING - " + curPupil.ofp_rating) + "%");
                        break;
                    case 3:
                        ratingtext.setText(String.valueOf("STRETCH RATING - " + curPupil.streching_rating) + "%");
                        break;
                    default:
                        ratingtext.setText("");
                }
            }
        });

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setText("FREZZE");
        tabLayout.getTabAt(1).setText("MOVE");
        tabLayout.getTabAt(2).setText("ОФП");
        tabLayout.getTabAt(3).setText("STRETCH");


        return view;
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return FMyFrezzesResults.newInstance(position, curPupil);
                case 1:
                    return MyPowerMoveResults.newInstance(position, curPupil);
                case 2:
                    return MyOFPResults.newInstance(position, curPupil);
                case 3:
                    return MyStretchResults.newInstance(position, curPupil);
                default:
                    return FMyFrezzesResults.newInstance(position, curPupil);
            }


        }

        @Override
        public int getCount() {
            return 4;
        }

    }


}
