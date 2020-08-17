package com.moringa.mambopesa.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moringa.mambopesa.R;
import com.moringa.mambopesa.models.CurrencyInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrencyInfoListAdapter extends RecyclerView.Adapter<CurrencyInfoListAdapter.CurrencyInfoViewHolder> {

    private List<CurrencyInfo> currencyInfoList;
    private Context context;

    public CurrencyInfoListAdapter(List<CurrencyInfo> currencyInfoList, Context context) {
        this.currencyInfoList = currencyInfoList;
        this.context = context;
    }

    @Override
    public CurrencyInfoListAdapter.CurrencyInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.currency_info_list_item, parent, false);
        CurrencyInfoViewHolder  viewHolder = new CurrencyInfoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyInfoListAdapter.CurrencyInfoViewHolder holder, int position) {
        holder.bindCurrencyInfo(currencyInfoList.get(position));
    }

    @Override
    public int getItemCount() {
        return currencyInfoList.size();
    }

    //view holder class
    public class CurrencyInfoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.currencyWebsite)
        TextView mWebSite;
        @BindView(R.id.currencyBank)
        TextView mBank;
        @BindView(R.id.currencyBankNotes)
        TextView mBankNotes;
        @BindView(R.id.currencyCountry)
        TextView mCountry;
        @BindView(R.id.currencyIcon)
        ImageView mIcon;
        @BindView(R.id.currencyShortName)
        TextView mCurrencyShortName;
        @BindView(R.id.currencyName)
        TextView mCurrencyName;

        private Context context;

        public CurrencyInfoViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            context = itemView.getContext();
        }

        @Override
        public void onClick(View view) {

        }

        public void bindCurrencyInfo(CurrencyInfo currencyInfo) {
            mCurrencyName.setText(currencyInfo.getName());
            mCurrencyShortName.setText(currencyInfo.getShortName());
            mCountry.setText(String.format("County: %s",currencyInfo.getCountry()));
            mBankNotes.setText(String.format("Bank notes: %s",currencyInfo.getBanknotes()));
            mBank.setText(String.format("Bank: %s",currencyInfo.getBank()));
            mWebSite.setText(String.format("Website: %s",currencyInfo.getWebsite()));
//            Glide.with(context).load(Uri.parse(currencyInfo.getIcon())).into(mIcon);
//            GlideToVectorYou.justLoadImage(this, Uri.parse(currencyInfo.getIcon()) ,mIcon);
            //TODO look for a lib that supports svgs
            Picasso.get().load("https://img.icons8.com/flat_round/300/000000/error--v1.png").into(mIcon);
        }
    }
}
