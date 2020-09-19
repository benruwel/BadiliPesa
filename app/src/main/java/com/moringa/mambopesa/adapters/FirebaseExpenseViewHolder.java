package com.moringa.mambopesa.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.moringa.mambopesa.models.Expense;
import com.moringa.mambopesa.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirebaseExpenseViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.expenseName)
    TextView mExpenseName;
    @BindView(R.id.expensePrice)
    TextView mExpensePrice;

    View mView;
    Context context;

    public FirebaseExpenseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mView = itemView;
        context = itemView.getContext();
    }

    public void bindExpense(Expense expense) {
        mExpenseName.setText(expense.getName());
        mExpensePrice.setText(String.format("%s",expense.getPrice()));
    }
}
