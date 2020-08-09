package com.moringa.badilipesa.ui;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.moringa.badilipesa.R;
import com.moringa.badilipesa.models.ConvertCurrencyApiResponse;
import com.moringa.badilipesa.models.Rates;
import com.moringa.badilipesa.network.ConversionApi;
import com.moringa.badilipesa.network.ConversionClient;

import java.text.NumberFormat;
import java.util.Currency;

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
    @BindView(R.id.amountToConvert)
    TextView amountToConvertView;
    @BindView(R.id.convertedAmount)
    TextView convertedAmountView;

    public Rates convertedRate;

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
                        amountToConvertView.setText(response.body().getAmount().toString());
                        convertedRate = response.body().getRates();
                        convertedAmountView.setText(convertedRate.getConvertedAmount().toString());
                    }
                }

                @Override
                public void onFailure(Call<ConvertCurrencyApiResponse> call, Throwable t) {

                }
            });
        }
    }
}
