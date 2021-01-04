package com.example.lendbak;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class IntroViewPagerAdapter extends FragmentStateAdapter {
    private final int NUM_PAGES = 3;

    public IntroViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new FirstIntroFragment();
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
