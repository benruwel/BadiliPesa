package com.moringa.mambopesa.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moringa.mambopesa.R;
import com.moringa.mambopesa.adapters.CurrencyInfoListAdapter;
import com.moringa.mambopesa.adapters.RelatedCurrenciesListAdapter;
import com.moringa.mambopesa.models.CurrencyInfo;
import com.moringa.mambopesa.models.CurrencyInfoApiResponse;
import com.moringa.mambopesa.models.RelatedCurrenciesApiResponse;
import com.moringa.mambopesa.network.CurrencyExApi;
import com.moringa.mambopesa.network.CurrencyExClient;
import com.moringa.mambopesa.util.Constants;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.SearchView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyInfoActivity extends AppCompatActivity {

    @BindView(R.id.errorTextView)
    TextView mErrorText;
    @BindView(R.id.currencyInfoRecyclerView)
    RecyclerView mCurrencyInfo;
    @BindView(R.id.currencyInfoSearchView)
    SearchView mSearchView;
    @BindView(R.id.currencyInfoProgressBar)
    ProgressBar mProgressBar;

    private List<CurrencyInfo> mCurrencyInfoList;
    private CurrencyInfoListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_info);
        ButterKnife.bind(this);

        searchQueryListener();
    }

    //search query listener
    private void searchQueryListener() {
        mSearchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getCurrencyInfo(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    //gather the currency profile info from api
    private void getCurrencyInfo(String symbol) {
        hideCurrencyInfo();
        showProgressBar();

        CurrencyExApi client = CurrencyExClient.getClient();
        //api key is added as a parameter
        Call<CurrencyInfoApiResponse> call = client.getCurrencyInfo(symbol, Constants.FOREX_API_KEY);

        call.enqueue(new Callback<CurrencyInfoApiResponse>() {
            @Override
            public void onResponse(Call<CurrencyInfoApiResponse> call, Response<CurrencyInfoApiResponse> response) {

                hideProgressBar();
                //looking for response.isSuccessfull won't cut it in the case where there is an unsupported string from the search query
                //in this case the unsupported string will still ba parsed resulting in a Null object
                //this api provides a status of the response which we use to verify that we get the correct response
                if(response.isSuccessful() && response.body().getStatus()) {
                    mCurrencyInfoList = response.body().getCurrencyInfo();
                    mAdapter = new CurrencyInfoListAdapter(mCurrencyInfoList, CurrencyInfoActivity.this);
                    mCurrencyInfo.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CurrencyInfoActivity.this);
                    mCurrencyInfo.setLayoutManager(layoutManager);
                    mCurrencyInfo.setHasFixedSize(true);

                    showCurrencyInfo();

                } else {
                    hideProgressBar();
                    showUnsuccessfulMessage();
                }
            }
            @Override
            public void onFailure(Call<CurrencyInfoApiResponse> call, Throwable t) {
                showFailureMessage();
            }
        });
    }

    private void showFailureMessage() {
        mErrorText.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorText.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorText.setText("Unsupported and/or invalid search term. Try USD, KES or JPN");
        mErrorText.setVisibility(View.VISIBLE);
    }

    private void showCurrencyInfo() {
        mCurrencyInfo.setVisibility(View.VISIBLE);
    }
    private void hideCurrencyInfo() {
        mCurrencyInfo.setVisibility(View.GONE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }
}















