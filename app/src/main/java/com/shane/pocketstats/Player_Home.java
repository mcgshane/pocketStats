package com.shane.pocketstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Player_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_home);

        Button btn_PlayerStats = findViewById(R.id.btn_PlayerStats);
        Button btn_Player_Training = findViewById(R.id.btn_PlayerTraining);
        Button btn_PlayerFixtures = findViewById(R.id.btn_PlayerFixtures);
        Button btn_PlayerChat = findViewById(R.id.btn_PlayerChat);

        btn_PlayerStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Player_Home.this, Player_MyStats.class);
                startActivity(intent);
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
}