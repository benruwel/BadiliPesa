package com.moringa.mambopesa.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.moringa.mambopesa.R;
import com.moringa.mambopesa.adapters.FirebaseExpenseViewHolder;
import com.moringa.mambopesa.models.Budget;

public class BudgetListActivity extends AppCompatActivity {

    private DatabaseReference mBudgetReference;
    private FirebaseRecyclerAdapter<Budget, FirebaseExpenseViewHolder> mFirebaseAdap

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_list);
    }
}