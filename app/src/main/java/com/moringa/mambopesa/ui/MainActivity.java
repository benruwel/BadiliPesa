package com.moringa.mambopesa.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moringa.mambopesa.R;
import com.moringa.mambopesa.models.CurrencyInfo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.profileImage)
    ImageView mProfileImage;
    @BindView(R.id.convertCurrencyCardView)
    CardView mConvertCurrencyCardView;
    @BindView(R.id.ForexRatesCardView)
    CardView mForexRates;
    @BindView(R.id.currencyInfoCardView)
    CardView mCurrencyInfo;
    @BindView(R.id.budgetPlannerCardView)
    CardView mBudgetPlanner;
    @BindView(R.id.welcomeMessage)
    TextView mWelcomeMessage;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mConvertCurrencyCardView.setOnClickListener(this);
        mProfileImage.setOnClickListener(this);
        mForexRates.setOnClickListener(this);
        mCurrencyInfo.setOnClickListener(this);
        mBudgetPlanner.setOnClickListener(this);
        //add the auth state listeners as soon as the activity starts
        authStateListener();
    }

    @Override
    public void onClick(View view) {

        if(view == mProfileImage) {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, mProfileImage);
            //inflating the popup using xml
            popupMenu.getMenuInflater().inflate(R.menu.menu_logout, popupMenu.getMenu());

            popupMenu.show();
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    //we use a switch statement to handle the diff events of the various menu items
                    switch (menuItem.getItemId()) {
                        case R.id.action_logout:
                            logOutUser();
                            return true;
                        case R.id.action_profile:
                            Toast.makeText(MainActivity.this, R.string.great_things, Toast.LENGTH_SHORT).show();
                            return true;
                        default:
                            return false;
                    }
                }
            });
        }
        if (view == mConvertCurrencyCardView) {
            Intent intent = new Intent(MainActivity.this, ConverterActivity.class);
            startActivity(intent);
        }
        if (view == mForexRates) {
            Intent intent = new Intent(MainActivity.this, RelatedCurrenciesListActivity.class);
            startActivity(intent);
        }
        if (view == mCurrencyInfo) {
            Intent intent = new Intent(MainActivity.this, CurrencyInfoActivity.class);
            startActivity(intent);
        }
        if (view == mBudgetPlanner) {
            Intent intent = new Intent(MainActivity.this, CreateBudgetActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            firebaseAuth.removeAuthStateListener(mAuthListener);
        }
    }

    //method to logout user current session
    private void logOutUser() {
        FirebaseAuth.getInstance().signOut();

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void authStateListener() {
        //get the user's firebase instance where we saved their name
        firebaseAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    mWelcomeMessage.setText(String.format("Welcome, %s!", user.getDisplayName()));
                } else {
                    mWelcomeMessage.setText("Welcome, stranger!");
                }
            }
        };
    }
}