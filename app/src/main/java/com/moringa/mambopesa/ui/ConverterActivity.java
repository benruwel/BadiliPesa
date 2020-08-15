package com.moringa.mambopesa.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    TextView results;
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
            String fromSymbolString = fromEditView.getText().toString();
            String toSymbolString = toEditView.getText().toString();
            String amountToConvert = amountEditView.getText().toString();
            ConversionApi client = ConversionClient.getClient();
            Call<ConvertCurrencyApiResponse> call = client.getConversionResults(amountToConvert, fromSymbolString, toSymbolString );
            call.enqueue(new Callback<ConvertCurrencyApiResponse>() {
                @Override
                public void onResponse(Call<ConvertCurrencyApiResponse> call, Response<ConvertCurrencyApiResponse> response) {
                    if(response.isSuccessful()) {
                        results.setText(response.body().getRates().getConvertedAmount().toString());
                    }
                }

                @Override
                public void onFailure(Call<ConvertCurrencyApiResponse> call, Throwable t) {
                    Log.d(TAG, "on failure", t);
                }
            });
        }
    }
}
