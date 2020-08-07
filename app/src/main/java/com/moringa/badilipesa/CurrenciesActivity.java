package com.moringa.badilipesa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrenciesActivity extends AppCompatActivity implements View.OnClickListener {

    //reference for the currencies list
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

    @BindView(R.id.currenciesList)
    ListView mCurrenciesList;

    @BindView(R.id.convertViewButton)
    Button mConvertViewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currencies);
        ButterKnife.bind(this);

        ArrayAdapter currencies = new CurrenciesArrayAdapter(this, android.R.layout.simple_list_item_1 ,supportedCurrencies);
        mCurrenciesList.setAdapter(currencies);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mUsernameTextView.setText(String.format("Hello %s, here are the supported currencies", username));
        mConvertViewButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mConvertViewButton) {
            Intent intent = new Intent(CurrenciesActivity.this, ConverterActivity.class);
            startActivity(intent);
        }
    }
}
