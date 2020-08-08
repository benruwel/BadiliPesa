package com.moringa.badilipesa.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.moringa.badilipesa.models.Currency;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.moringa.badilipesa.R;
import com.moringa.badilipesa.ui.CurrenciesListActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

public class CurrenciesListAdapter extends RecyclerView.Adapter<CurrenciesListAdapter.CurrenciesViewHolder> {

    private Map<String, Currency> mCurrencies;
    private Context mContext;

    public CurrenciesListAdapter(Map<String, Currency> mCurrencies, Context mContext) {
        this.mCurrencies = mCurrencies;
        this.mContext = mContext;
    }

    @Override
    public CurrenciesListAdapter.CurrenciesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.currency_list_item, parent, false);
        CurrenciesViewHolder viewHolder = new CurrenciesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CurrenciesListAdapter.CurrenciesViewHolder holder, int position) {
        holder.bindCurrency(mCurrencies.get(position));
    }

    @Override
    public int getItemCount() {
        return mCurrencies.size();
    }

    public class CurrenciesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.currencySymbol)
        TextView mCurrencySymbol;
        @BindView(R.id.currencyName)
        TextView mCurrencyName;

        private Context mContext;

        public CurrenciesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindCurrency(Currency currency) {
            mCurrencySymbol.setText(currency.getSymbol());
            mCurrencyName.setText(currency.getName());
        }

        @Override
        public void onClick(View view) {

        }
    }

}
