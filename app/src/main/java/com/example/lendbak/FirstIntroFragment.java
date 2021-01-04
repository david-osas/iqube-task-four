package com.example.lendbak;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lendbak.databinding.FragmentFirstIntroBinding;

public class FirstIntroFragment extends Fragment {

    private static final String ARG_PARAM1 = "positon";
    private int position = 0;
    private FragmentFirstIntroBinding binding;
    private int[] images = {R.drawable.first_intro, R.drawable.second_intro, R.drawable.third_intro};
    private int[] headings = {R.string.firstIntroHeading, R.string.secondIntroHeading, R.string.thirdIntroHeading};

    public FirstIntroFragment() {
        // Required empty public constructor
    }


    public static FirstIntroFragment newInstance(int param1) {
        FirstIntroFragment fragment = new FirstIntroFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFirstIntroBinding.inflate(inflater, container, false);
        binding.introImage.setImageResource(images[position]);
        binding.heading.setText(headings[position]);
        return binding.getRoot();
    }
}