package com.moringa.badilipesa.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moringa.badilipesa.R;
import com.moringa.badilipesa.adapters.RelatedCurrenciesListAdapter;
import com.moringa.badilipesa.models.Currency;
import com.moringa.badilipesa.models.SupportedRatesResponse;
import com.moringa.badilipesa.network.CurrencyExApi;
import com.moringa.badilipesa.network.CurrencyExClient;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrenciesListActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.usernameTextView)
    TextView mUsernameTextView;

    @BindView(R.id.convertViewButton)
    Button mConvertViewButton;

    @BindView(R.id.recyclerView)
    RecyclerView mCurrenciesList;


    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @BindView(R.id.errorTextView)
    TextView mErrorTextView;

    private RelatedCurrenciesListAdapter mAdapter;
    public List<Currency> currencies;
    public Map<String, Currency> currencyItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_related_currencies);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mUsernameTextView.setText(String.format("Hello %s, here are the supported currencies", username));
        mConvertViewButton.setOnClickListener(this);

        //api calls
        CurrencyExApi client = CurrencyExClient.getClient();
        Call<SupportedRatesResponse> call = client.getCurrencies("USD");

        call.enqueue(new Callback<SupportedRatesResponse>() {
            @Override
            public void onResponse(Call<SupportedRatesResponse> call, Response<SupportedRatesResponse> response) {
                hideProgressBar();

                if(response.isSuccessful()) {
                    currencyItem = response.body().getCurerncies();
                    mAdapter = new RelatedCurrenciesListAdapter(currencyItem,CurrenciesListActivity.this);
                    mCurrenciesList.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CurrenciesListActivity.this);
                    mCurrenciesList.setLayoutManager(layoutManager);
                    mCurrenciesList.setHasFixedSize(true);

                    showCurrencies();
                } else {
                    showUnsuccessfulMessage();
                }
            }
            @Override
            public void onFailure(Call<SupportedRatesResponse> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
            }
        });
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showCurrencies() {
        mCurrenciesList.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        if(view == mConvertViewButton) {
            Intent intent = new Intent(CurrenciesListActivity.this, ConverterActivity.class);
            startActivity(intent);
        }
    }
}
