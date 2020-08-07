package com.moringa.badilipesa.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class CurrenciesArrayAdapter extends ArrayAdapter {

    private Context mContext;
    private String[] mSupportedCurrencies;

    public CurrenciesArrayAdapter(Context mContext,int resource, String[] mSupportedCurrencies) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mSupportedCurrencies = mSupportedCurrencies;
    }

    @Override
    public Object getItem(int position) {
        return mSupportedCurrencies[position];
    }

    @Override
    public int getCount() {
        return mSupportedCurrencies.length;
    }
}
