package com.shane.pocketstats;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Player_Home extends AppCompatActivity {

    FirebaseAuth mAuth;
    private FirebaseFirestore fStore;
String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_home);

        //Initialize FireStore
        fStore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        Button btn_PlayerStats = findViewById(R.id.btn_PlayerStats);
        Button btn_Player_Training = findViewById(R.id.btn_PlayerTraining);
        Button btn_PlayerFixtures = findViewById(R.id.btn_PlayerFixtures);
        Button btn_PlayerChat = findViewById(R.id.btn_PlayerChat);
        Button btn_Logout = findViewById(R.id.btn_LogOut);

        btn_Logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(Player_Home.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btn_PlayerStats.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Initializing firebase Firestore in order to get user info
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                //colletion refering to the firestore Users data
                CollectionReference itemsRef = db.collection("User");
                // Initialize array list
                ArrayList itemList = new ArrayList<>() ;
                itemsRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                String itemName = document.getString("name");
                            }
                            //Testing tags
                            Log.d("myTag", "success");
                        } else{
                            Log.d("myTag", "FAil", task.getException());
                        }
                    }
                });
                Log.d("myTag" , "After call");

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String[] CurrentEmail = user.getEmail().split("@");
                name  = CurrentEmail[0].toString();

                //Send User to relevant Stats page with player name parameter
                Intent i ;
                i = new Intent(Player_Home.this, Player_Indiv_Stats.class);
                i.putExtra("Player" , name);
                startActivity(i);

            }
        });
        btn_PlayerFixtures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Player_Home.this, Player_Fixtures.class);
                startActivity(intent);
            }
        });

        btn_Player_Training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Player_Home.this, Player_Training.class);
                startActivity(intent);
            }
        });

        btn_PlayerChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Player_Home.this, Player_TeamChat.class);
                startActivity(intent);
            }
        });

    }
    private String getUserName(String uid) {

        String result;
        DocumentReference docR = fStore.collection("User").document(uid);

        //get the data from the document
        DocumentSnapshot documentSnapshot = docR.get().getResult();
        result = documentSnapshot.getString("name");

        return result;
    }
}