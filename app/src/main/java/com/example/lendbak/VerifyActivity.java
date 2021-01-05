package com.example.lendbak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lendbak.databinding.ActivityVerifyBinding;

public class VerifyActivity extends AppCompatActivity {
    private ActivityVerifyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVerifyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void verifyDetails(View view){
        Button button = (Button) view;
        if(button.getText().toString().equals(getString(R.string.continueBtn))){
            binding.verifyImg.setImageResource(R.drawable.verify2);
            binding.verifyTitle.setText(R.string.verifyPhoneTitle);
            binding.verifyText.setText(R.string.verifyPhoneText);
            binding.verifyOtp.setVisibility(View.VISIBLE);
            button.setText(R.string.verifyBtn);
        }else{
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
    }
}