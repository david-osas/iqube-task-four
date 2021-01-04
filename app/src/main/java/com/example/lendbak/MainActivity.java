package com.example.lendbak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.example.lendbak.databinding.ActivityMainBinding;

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
        binding.button.setText(R.string.introBtnText1);

        viewPagerListener();
    }

    public void showIntro(View view){
        int current = viewPager.getCurrentItem();
        if(current < IntroViewPagerAdapter.NUM_PAGES-1){
            viewPager.setCurrentItem(current+1);
        }
    }

    private void viewPagerListener(){
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if(position == IntroViewPagerAdapter.NUM_PAGES-1){
                    binding.button.setText(R.string.introBtnText2);
                }else{
                    binding.button.setText(R.string.introBtnText1);
                }
            }
        });
    }
}