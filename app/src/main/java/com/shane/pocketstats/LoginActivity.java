package com.shane.pocketstats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.text.TextUtils.isEmpty;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    //Firebase - AuthState listener checks the status
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText EmailLogin, PasswordLogin;
    private Button btn_SignIn, btn_goToRegister,btn_forgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EmailLogin = (EditText) findViewById(R.id.et_EmailLogin);
        PasswordLogin = (EditText) findViewById(R.id.et_PasswordLogin);
        btn_SignIn = (Button) findViewById(R.id.btn_SignIn);
        btn_goToRegister = (Button) findViewById(R.id.btn_goToRegister);
        btn_forgotPassword = (Button) findViewById(R.id.btn_forgotPassword);

        //Listener will be listening for any changes
        startUpFirebaseAuth();

        btn_goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        Button btn_SignIn = (Button) findViewById(R.id.btn_SignIn);
        btn_SignIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!isEmpty(EmailLogin.getText().toString())
                        && !isEmpty(PasswordLogin.getText().toString())) {
                    Log.d(TAG, "onclick: Trying to Authenticate. ");

                    //checking that both the email and password fields are both not empty. Unable to proceed if they are
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(EmailLogin.getText().toString(),
                            PasswordLogin.getText().toString())
                            //add listener to listen for when the task has completed
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    //hideDialog();

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(LoginActivity.this, "Authentication has failed", Toast.LENGTH_SHORT).show();
                            //hideDialog();
                        }
                    });


                } else {
                    Toast.makeText(LoginActivity.this, "You didn't fill in all the fields.", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(LoginActivity.this, Coach_Home.class);
                startActivity(intent);

            }
        });

        Button register = (Button) findViewById(R.id.btn_goToRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        Button forgotPassword = (Button) findViewById(R.id.btn_forgotPassword);
        btn_forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    //checking there is text in the string is so it returns true
    private boolean isEmpty(String string){
        return string.equals("");
    }

    /*
    Firebase setup using firebase Docs
     */
    private void startUpFirebaseAuth(){
        Log.d(TAG, "StartUpFirebaseAuth: started.");

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    Toast.makeText(LoginActivity.this, "Authenticated with: " + user.getEmail(), Toast.LENGTH_SHORT).show();

                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }
    }
}