package com.moringa.mambopesa.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringa.mambopesa.R;
import com.moringa.mambopesa.adapters.FirebaseExpenseViewHolder;
import com.moringa.mambopesa.models.Budget;
import com.moringa.mambopesa.util.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BudgetListActivity extends AppCompatActivity {

    @BindView(R.id.expensesRecyclerView)
    RecyclerView expensesRecyclerView;
    @BindView(R.id.noItemsTextView)
    TextView mNoItems;

    private DatabaseReference mBudgetReference;
    private FirebaseUser user;
    private FirebaseRecyclerAdapter<Budget, FirebaseExpenseViewHolder> mFirebaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_list);
        ButterKnife.bind(this);

        //get the use id so as to get their scoped data
        user = FirebaseAuth.getInstance().getCurrentUser();
        //get user's unique id
        String uid = user.getUid();
        mBudgetReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_BUDGET_PLANNER).child(uid);
        setupFirebaseAdapter();
    }

    private void setupFirebaseAdapter() {
        //by using the in-built firebase adapter, it listens to data changes through out
        FirebaseRecyclerOptions<Budget> options = new FirebaseRecyclerOptions.Builder<Budget>().setQuery(mBudgetReference, Budget.class).build();
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Budget, FirebaseExpenseViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseExpenseViewHolder holder, int position, @NonNull Budget model) {
                for(int i = 0; i < model.getExpenseList().size(); i++) {
                    holder.bindExpense(model.getExpenseList().get(i));
                }
            }

            @NonNull
            @Override
            public FirebaseExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.budget_list_item, parent, false);
                return new FirebaseExpenseViewHolder(view);
            }
        };

        expensesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        expensesRecyclerView.setAdapter(mFirebaseAdapter);
        showRecyclerView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter != null) {
            mFirebaseAdapter.stopListening();
        }
    }

    private void showRecyclerView() {
        expensesRecyclerView.setVisibility(View.VISIBLE);
    }
    private void hideNoItemsText() {
        mNoItems.setVisibility(View.GONE);
    }
}