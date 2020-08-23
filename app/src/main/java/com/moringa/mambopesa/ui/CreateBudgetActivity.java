package com.moringa.mambopesa.ui;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringa.mambopesa.R;
import com.moringa.mambopesa.models.Budget;
import com.moringa.mambopesa.util.Constants;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateBudgetActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.amountToBudgetEditView)
    EditText mAmountToBudget;
    @BindView(R.id.submitBudgetButton)
    Button mSubmitBudget;

    private FirebaseUser user;
    private String uid;
    private Budget budget;
    DatabaseReference budgetRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_budget);
        ButterKnife.bind(this);

        //get the user's uid
        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();
        //set the db reference to the budgetPlanner node
        budgetRef = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_CHILD_BUDGET_PLANNER).child(uid);

        mSubmitBudget.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mSubmitBudget){
            Intent intent = new Intent(CreateBudgetActivity.this, BudgetListActivity.class);
            int allocatedBudget = Integer.parseInt(mAmountToBudget.getText().toString().trim());
            saveBudgetToFirebase(allocatedBudget);
            startActivity(intent);
        }
    }

    private void saveBudgetToFirebase(int allocatedBudget){
        DatabaseReference allocatedBudgetRef = budgetRef.child(Constants.FIREBASE_CHILD_ALLOCATED_BUDGET);
        //set the allocatedBudget in this budget instance
        //budget.setAllocatedBudget(allocatedBudget)
        //save the allocated budget to firebase
        allocatedBudgetRef.setValue(allocatedBudget);
    }
}