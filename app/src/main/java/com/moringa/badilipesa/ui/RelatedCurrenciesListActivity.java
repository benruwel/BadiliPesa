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
import com.moringa.badilipesa.models.RelatedCurrenciesApiResponse;
import com.moringa.badilipesa.network.CurrencyExApi;
import com.moringa.badilipesa.network.CurrencyExClient;
import com.moringa.badilipesa.util.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RelatedCurrenciesListActivity extends AppCompatActivity implements View.OnClickListener {

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
    //create a list variable to hold all the currency pairs from the api call
    public List<CurrencyPair> mCurrencyPairs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_related_currencies);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String currencySymbol = intent.getStringExtra("currencySymbol");
        //display both username and currency symbol
        mUsernameTextView.setText(String.format("Hello %s, here are the related currencies:%s", username, currencySymbol));
        mConvertViewButton.setOnClickListener(this);

        //api calls
        CurrencyExApi client = CurrencyExClient.getClient();
        //we add the api key to the parameter according to the Api Docs
        Call<RelatedCurrenciesApiResponse> call = client.getRelatedCurrencies(currencySymbol, Constants.FOREX_API_KEY);

        call.enqueue(new Callback<RelatedCurrenciesApiResponse>() {
            @Override
            public void onResponse(Call<RelatedCurrenciesApiResponse> call, Response<RelatedCurrenciesApiResponse> response) {
                hideProgressBar();

                if(response.isSuccessful()) {
                    mCurrencyPairs = response.body().getCurrencyPairs();
                    mAdapter = new RelatedCurrenciesListAdapter(mCurrencyPairs, RelatedCurrenciesListActivity.this);
                    mCurrenciesList.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RelatedCurrenciesListActivity.this);
                    mCurrenciesList.setLayoutManager(layoutManager);
//                    mCurrenciesList.setHasFixedSize(true);

                    showCurrencies();
                    showConvertViewButton();
                } else {
                    showUnsuccessfulMessage();
                }
            }
            @Override
            public void onFailure(Call<RelatedCurrenciesApiResponse> call, Throwable t) {
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

    private void showConvertViewButton() {
        mConvertViewButton.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        if(view == mConvertViewButton) {
            Intent intent = new Intent(RelatedCurrenciesListActivity.this, ConverterActivity.class);
            startActivity(intent);
        }
    }
}
