package com.moringa.badilipesa.ui;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.moringa.badilipesa.R;

import java.text.NumberFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConverterActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.amountToConvert)
    EditText mAmountToConvert;

    @BindView(R.id.conversionButton)
    Button mConversionButton;

    @BindView(R.id.convertedString)
    TextView mConvertedString;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_converter);
        ButterKnife.bind(this);

        mConversionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mConversionButton) {
            String convertedAmountString = mAmountToConvert.getText().toString();
            mConvertedString.setText(String.format("To KSH %s", convertedAmountString));
        }
    }
}
