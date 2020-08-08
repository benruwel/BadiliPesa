package com.moringa.badilipesa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.moringa.badilipesa.R;
import com.moringa.badilipesa.models.CurrencyPair;

public class RelatedCurrenciesListAdapter extends RecyclerView.Adapter<RelatedCurrenciesListAdapter.CurrenciesViewHolder> {

    private List<CurrencyPair> currencyPairList;
    private Context mContext;

    public RelatedCurrenciesListAdapter(List<CurrencyPair> currencyPairList, Context mContext) {
        this.currencyPairList = currencyPairList;
        this.mContext = mContext;
    }

    @Override
    public RelatedCurrenciesListAdapter.CurrenciesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.currencypair_list_item, parent, false);
        CurrenciesViewHolder viewHolder = new CurrenciesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RelatedCurrenciesListAdapter.CurrenciesViewHolder holder, int position) {
        holder.bindCurrency(currencyPairList.get(position));
    }

    @Override
    public int getItemCount() {
        return currencyPairList.size();
    }

    public class CurrenciesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.currencySymbol)
        TextView mCurrencySymbol;
        @BindView(R.id.currencyPrice)
        TextView mCurrencyPrice;
        @BindView(R.id.currencyChange)
        TextView mCurrencyChange;

        private Context mContext;

        public CurrenciesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindCurrency(CurrencyPair currencyPair) {
            mCurrencySymbol.setText(currencyPair.getSymbol());
            mCurrencyPrice.setText(String.format("Price:%s", currencyPair.getPrice()));
            mCurrencyChange.setText(String.format("Change:%s", currencyPair.getChange()));
        }

        @Override
        public void onClick(View view) {

        }
    }

}
