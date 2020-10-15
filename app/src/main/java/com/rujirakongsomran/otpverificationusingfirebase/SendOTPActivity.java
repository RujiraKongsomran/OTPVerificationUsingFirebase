package com.rujirakongsomran.otpverificationusingfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rujirakongsomran.otpverificationusingfirebase.databinding.ActivitySendOtpBinding;

public class SendOTPActivity extends AppCompatActivity {

    ActivitySendOtpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_send_otp);

        binding = ActivitySendOtpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        final EditText flEtInputMobile = binding.etInputMobile;

        binding.btnGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flEtInputMobile.getText().toString().trim().isEmpty()) {
                    Toast.makeText(SendOTPActivity.this, "Enter Mobile", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(), VerifyOTPActivity.class);
                intent.putExtra("mobile", flEtInputMobile.getText().toString());
                startActivity(intent);
            }
        });
    }
}