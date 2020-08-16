package com.moringa.mambopesa.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moringa.mambopesa.R;
import com.moringa.mambopesa.adapters.RelatedCurrenciesListAdapter;
import com.moringa.mambopesa.models.CurrencyPair;
import com.moringa.mambopesa.models.RelatedCurrenciesApiResponse;
import com.moringa.mambopesa.network.CurrencyExApi;
import com.moringa.mambopesa.network.CurrencyExClient;
import com.moringa.mambopesa.util.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RelatedCurrenciesListActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.recyclerView)
    RecyclerView mCurrenciesList;
//    @BindView(R.id.currencySymbolEditText)
//    EditText mCurrencySymbol;
//    @BindView(R.id.currencySymbolSearchIcon)
//    ImageView mSearchIcon;

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

        //api calls
        CurrencyExApi client = CurrencyExClient.getClient();
        //we add the api key to the parameter according to the Api Docs
        Call<RelatedCurrenciesApiResponse> call = client.getRelatedCurrencies("KES", Constants.FOREX_API_KEY);

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

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
//        if(view == mConvertViewButton) {
//            Intent intent = new Intent(RelatedCurrenciesListActivity.this, ConverterActivity.class);
//            startActivity(intent);
//        }
    }
}
