package com.moringa.badilipesa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrenciesActivity extends AppCompatActivity {

    public String[] supportedCurrencies = new String[] {
            "AED: 3.67295",
            "AFN: 76.7",
            "ALL: 105.3",
            "AMD: 485.33",
            "ANG: 1.795763",
            "AOA: 576.975",
            "ARS: 72.3764",
            "AUD: 1.399805",
            "AWG: 1.8",
            "AZN: 1.7",
            "BAM: 1.651305",
            "BBD: 2.003622",
            "BDT: 84.82762",
            "BGN: 1.653791",
            "BHD: 0.3769837",
            "BIF: 1927.5",
            "BMD: 1",
            "BND: 1.372204",
            "BOB: 6.913053",
            "BRL: 5.22265",
            "BSD: 1.00046",
            "BTN: 74.735",
    };

    @BindView(R.id.usernameTextView)
    TextView mUsernameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currencies);
        ButterKnife.bind(this);

        ArrayAdapter currencies = new CurrenciesArrayAdapter(this, android.R.layout.simple_list_item_1 ,supportedCurrencies);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mUsernameTextView.setText(String.format("Hello %s, here are the supported currencies", username));
    }

}
