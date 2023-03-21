package com.example.delivery_monkey_be;

import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

public class BlurView extends FragmentActivity {

    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur);
        ImageView image = findViewById(R.id.image);
        image.setRenderEffect(RenderEffect.createBlurEffect(75, 75, Shader.TileMode.MIRROR));
    }
}
