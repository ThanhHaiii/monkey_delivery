package com.example.delivery_monkey_be;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class StartedActivity extends Activity {

    private ImageView login;
    private ImageView createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started);
        initView();
    }

    private void initView() {
        login = findViewById(R.id.login_btn);
        createAccount = findViewById(R.id.create_account_btn);

        login.setOnClickListener(view -> {
            Intent intent = new Intent(StartedActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        createAccount.setOnClickListener(view -> {
            Intent intent = new Intent(StartedActivity.this, SignUpActivity.class);
            startActivity(intent);
            finish();
        });
    }
}