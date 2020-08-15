package com.moringa.mambopesa.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.moringa.mambopesa.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.emailInsertLoginView)
    EditText mEmailAddress;
    @BindView(R.id.passwordInsertView)
    EditText mPassword;
    @BindView(R.id.createAccountTextView)
    TextView mCreateAccountText;
    @BindView(R.id.loginBtn)
    Button mLoginButton;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog mProgressDialog;
    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        //operations are performed in this one instance to prevent memory leaks
        firebaseAuth = FirebaseAuth.getInstance();

        //click listeners
        mLoginButton.setOnClickListener(this);
        mCreateAccountText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mLoginButton) {
            login();
        }
        if (view == mCreateAccountText) {
            Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }

    //login logic
    private void login() {
        String email = mEmailAddress.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

//        mProgressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        mProgressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Authentication successful");
//                            createFirebaseUserProfile(task.getResult().getUser());
                        } else {
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}















