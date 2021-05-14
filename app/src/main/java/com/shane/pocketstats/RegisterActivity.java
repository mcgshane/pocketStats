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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText name, email, password,passwordCheck;
    Button Btn_Register, Btn_Login;
    private FirebaseAuth mAuth;
    private FirebaseFirestore fStore;
    boolean valid = true;

    private static final String TAG = "Register_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.et_Name);
        email = findViewById(R.id.et_Email);
        password = findViewById(R.id.et_Password);
        passwordCheck = findViewById(R.id.et_PasswordCheck);

        Btn_Register = findViewById(R.id.Btn_Register);
        Btn_Login = findViewById(R.id.Btn_Login);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        Btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkField(name);
                checkField(email);
                checkField(password);
                checkField(passwordCheck);

                if (valid) {
                    mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            FirebaseUser fbUser = mAuth.getCurrentUser();

                            Toast.makeText(RegisterActivity.this, "Account has been succesfully created ", Toast.LENGTH_SHORT).show();

                            DocumentReference docR = fStore.collection("User").document(fbUser.getUid());
                            Map<String, Object> userInfo = new HashMap<>();
                            userInfo.put("name", name.getText().toString());
                            userInfo.put("email", email.getText().toString());
                            // if userCheck is one normal user is signed in
                            userInfo.put("isPlayer", "1");

                            docR.set(userInfo);
                            startActivity(new Intent(getApplicationContext(), Player_Home.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(RegisterActivity.this, "Account creation failed ", Toast.LENGTH_SHORT).show();

                        }
                    });


                }
                //check if passwords match
                if (StringsEqual(password.getText().toString(), passwordCheck.getText().toString())) {
                    //Initiate registration task
                    registerNewEmail(email.getText().toString(), password.getText().toString());
                } else {
                    Toast.makeText(RegisterActivity.this, "Passwords do not Match", Toast.LENGTH_SHORT).show();
                }

            }

            {
                Toast.makeText(RegisterActivity.this, "You must fill out all the fields", Toast.LENGTH_SHORT).show();
            }
        });
    }



    private boolean checkField(EditText textF) {
        if(textF.getText().toString().isEmpty()){
            textF.setError("Error");
            valid = false;
        }else {
            valid = true;
        }

        return valid;
    }


    public void registerNewEmail(final String email, String password){

       /* mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                        // ...
                    }
                });*/

        //showDialog();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking that the task has been successfull
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        if (task.isSuccessful()){
                            //if log is sucessfull print out new user ID
                            Log.d(TAG, "onComplete: AuthState: " + FirebaseAuth.getInstance().getCurrentUser().getUid());

                            FirebaseAuth.getInstance().signOut();

                            //redirect the user to the login screen
                            //redirectLoginScreen();
                        }
                        if (!task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Unable to Register",
                                    Toast.LENGTH_SHORT).show();
                        }
                        // hideDialog();

                        // ...
                    }
                });
    }

    /**
     * Redirects the user to the login screen
     */
    private void redirectLoginScreen(){
        Log.d(TAG, "redirectLoginScreen: redirecting to login screen.");

        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
    // checking to make sure two passwords match
    private boolean StringsEqual(String pass1, String pass2){
        return pass1.equals(pass2);
    }

    //making te check that there are no fields empty
    private boolean isEmpty(String string){
        return string.equals("");
    }


}
