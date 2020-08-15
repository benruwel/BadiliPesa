package com.moringa.mambopesa.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.moringa.mambopesa.R;
import com.moringa.mambopesa.models.Rates;

import butterknife.ButterKnife;

public class ConverterActivity extends AppCompatActivity implements View.OnClickListener {

//    @BindView(R.id.fromEditView)
//    EditText fromEditView;
//    @BindView(R.id.toEditView)
//    EditText toEditView;
//    @BindView(R.id.amountEditView)
//    EditText amountEditView;
//    @BindView(R.id.conversionButton)
//    Button conversionButton;
//    @BindView(R.id.amountToConvert)
//    TextView amountToConvertView;
//    @BindView(R.id.convertedAmount)
//    TextView convertedAmountView;

    public Rates convertedRate;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_converter);
        ButterKnife.bind(this);

//        conversionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        if(view == conversionButton) {
//            String fromSymbolString = fromEditView.getText().toString();
//            String toSymbolString = toEditView.getText().toString();
//            String amountToConvert = amountEditView.getText().toString();
//            ConversionApi client = ConversionClient.getClient();
//            Call<ConvertCurrencyApiResponse> call = client.getConversionResults(amountToConvert, fromSymbolString, toSymbolString );
//            call.enqueue(new Callback<ConvertCurrencyApiResponse>() {
//                @Override
//                public void onResponse(Call<ConvertCurrencyApiResponse> call, Response<ConvertCurrencyApiResponse> response) {
//                    if(response.isSuccessful()) {
//                        amountToConvertView.setText(response.body().getAmount().toString());
//                        convertedRate = response.body().getRates();
//                        convertedAmountView.setText(convertedRate.getConvertedAmount().toString());
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<ConvertCurrencyApiResponse> call, Throwable t) {
//
//                }
//            });
//        }
    }
}
