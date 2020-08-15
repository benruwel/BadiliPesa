package com.moringa.mambopesa.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.moringa.mambopesa.R;
import com.moringa.mambopesa.models.ConvertCurrencyApiResponse;
import com.moringa.mambopesa.models.Rates;
import com.moringa.mambopesa.network.ConversionApi;
import com.moringa.mambopesa.network.ConversionClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConverterActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.fromEditView)
    EditText fromEditView;
    @BindView(R.id.toEditView)
    EditText toEditView;
    @BindView(R.id.amountEditView)
    EditText amountEditView;
    @BindView(R.id.conversionButton)
    Button conversionButton;
    @BindView(R.id.resultsView)
    TextView mResults;
    @BindView(R.id.converterProgressBar)
    ProgressBar mProgressBar;

    private static final String TAG = ConverterActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_converter);
        ButterKnife.bind(this);

        conversionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == conversionButton) {
            showProgressBar();
            String fromSymbolString = fromEditView.getText().toString();
            String toSymbolString = toEditView.getText().toString();
            String amountToConvert = amountEditView.getText().toString();
            ConversionApi client = ConversionClient.getClient();
            Call<ConvertCurrencyApiResponse> call = client.getConversionResults(amountToConvert, fromSymbolString, toSymbolString );
            call.enqueue(new Callback<ConvertCurrencyApiResponse>() {
                @Override
                public void onResponse(Call<ConvertCurrencyApiResponse> call, Response<ConvertCurrencyApiResponse> response) {
                    hideProgressBar();
                    if(response.isSuccessful()) {
                        mResults.setText(response.body().getRates().getConvertedAmount().toString());
                        showResults();
                    } else {
                        showUnsuccessfulMessage();
                    }
                }

                @Override
                public void onFailure(Call<ConvertCurrencyApiResponse> call, Throwable t) {
                    Log.d(TAG, "on failure", t);
                    hideProgressBar();
                    showFailureMessage();
                }
            });
        }
    }

    private void showFailureMessage() {
        mResults.setText("Something went wrong. Please check your Internet connection and try again later");
        mResults.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mResults.setText("Something went wrong. Please try again later");
        mResults.setVisibility(View.VISIBLE);
    }

    private void showResults() {
        mResults.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }
}
