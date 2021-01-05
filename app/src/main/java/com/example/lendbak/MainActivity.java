package com.example.lendbak;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lendbak.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends FragmentActivity {

    private ActivityMainBinding binding;
    private ViewPager2 viewPager;
    private FragmentStateAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewPager = binding.introViewPager;
        adapter = new IntroViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
        binding.button.setText(R.string.continueBtn);

        viewPagerListener();
        TabLayout tabLayout = binding.tabLayout;
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

            }
        }).attach();
    }

    public void showIntro(View view){
        int current = viewPager.getCurrentItem();
        if(current == IntroViewPagerAdapter.NUM_PAGES-1){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else if(current < IntroViewPagerAdapter.NUM_PAGES-1){
            viewPager.setCurrentItem(current+1);
        }
    }

    private void viewPagerListener(){
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if(position == IntroViewPagerAdapter.NUM_PAGES-1){
                    binding.button.setText(R.string.getStartedBtn);
                }else{
                    binding.button.setText(R.string.continueBtn);
                }
            }
        });
    }
}