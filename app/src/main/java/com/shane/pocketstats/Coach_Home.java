package com.shane.pocketstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Coach_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_home);

        Button btn_NewGame = findViewById(R.id.btn_NewGame);
        Button btn_TeamStats = findViewById(R.id.btn_PlayerStats);
        Button btn_Plays = findViewById(R.id.btn_PlayerTraining);
        Button btn_Fixtures = findViewById(R.id.btn_PlayerFixtures);
        Button btn_Chat = findViewById(R.id.btn_PlayerChat);
        Button btn_Upload_Stats = findViewById(R.id.btn_Upload_Stats);
        Button btn_Logout = findViewById(R.id.btn_LogOut);

        btn_Logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(Coach_Home.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btn_NewGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent intent = new Intent(Coach_Home.this, Coach_NewGame.class);
                startActivity(intent);
            }
        });

        btn_TeamStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Coach_Home.this, Coach_All_Team_Stats.class);
                startActivity(intent);
            }
        });

        btn_Plays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Coach_Home.this, Coach_Training.class);
                startActivity(intent);
            }
        });

        btn_Fixtures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Coach_Home.this, Coach_Fixtures.class);
                startActivity(intent);
            }
        });

        btn_Chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Coach_Home.this, Coach_TeamChat.class);
                startActivity(intent);
            }
        });

        btn_Upload_Stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Coach_Home.this, Coach_TeamStatsUpload.class);
                startActivity(intent);
            }
        });
    }
}