package com.example.delivery_monkey_be;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;

public class Splash extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_slpash);
        new Handler().postDelayed(
                () -> {
                    Intent intent = new Intent(Splash.this, BlurView.class);
                    startActivity(intent);
                    finish();
                }, 3000);
    }
}