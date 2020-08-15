package com.moringa.mambopesa.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.moringa.mambopesa.R;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = CreateAccountActivity.class.getSimpleName();

    @BindView(R.id.usernameInsertCreateView)
    EditText mUsername;
    @BindView(R.id.emailInsertCreateView)
    EditText mEmail;
    @BindView(R.id.passwordInsertCreateView)
    EditText mPassword;
    @BindView(R.id.confirmPassword)
    EditText mConfirmPassword;
    @BindView(R.id.signUpButton)
    Button mSignUpButton;
    @BindView(R.id.goToLoginActivity)
    TextView mGoToLogin;

    //this class responsible for all auth actions we require
    private FirebaseAuth firebaseAuth;
    //auth listener to check the auth of the app at a given time
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ProgressDialog mProgressAuthDialog;
    //holds name of the user so as to display it in the Main activity
    public String mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);

        //operations are performed in this one instance to prevent memory leaks
        firebaseAuth = FirebaseAuth.getInstance();
        createAuthStateListener();
        mSignUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mSignUpButton) {
            createNewUser();
        }
        if (view == mGoToLogin) {
            Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
            //makes sure the user isn't allowed to go back even with system buttons
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        //essential for the auth state listener to work
        firebaseAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            firebaseAuth.removeAuthStateListener(mAuthListener);
        }
    }

    //method to hold logic for creating new accounts
    private void createNewUser() {
        mUserName = mUsername.getText().toString().trim();
        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        String confirmPassword = mConfirmPassword.getText().toString().trim();

//        mProgressAuthDialog.show();
        //parse users' info into the firebase auth api
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        mProgressAuthDialog.dismiss();
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Authentication successful");
                            createFirebaseUserProfile(task.getResult().getUser());
                        } else {
                            Toast.makeText(CreateAccountActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    //logic to check the app's auth state
    private void createAuthStateListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //if there exists an account, the user is redirected to the main activity
                    Intent intent = new Intent(CreateAccountActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }

        };
    }
    //setting up the user's profile so as to access their username from Firebase
    private void createFirebaseUserProfile(final FirebaseUser user) {

        UserProfileChangeRequest addProfileName = new UserProfileChangeRequest.Builder()
                .setDisplayName(mUserName)
                .build();

        user.updateProfile(addProfileName)
                .addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, user.getDisplayName());
                        }
                    }

                });
    }
}