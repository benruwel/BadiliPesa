package com.moringa.badilipesa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrenciesActivity extends AppCompatActivity {

    @BindView(R.id.usernameTextView)
    TextView mUsernameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currencies);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mUsernameTextView.setText(String.format("Hello %s, here are the supported currencies", username));
    }

}
