package com.shane.pocketstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Coach_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_home);

        Button btn_NewGame = findViewById(R.id.btn_NewGame);
        Button btn_TeamStats = findViewById(R.id.btn_TeamStats);
        Button btn_Plays = findViewById(R.id.btn_Plays);
        Button btn_Fixtures = findViewById(R.id.btn_Fixtures);
        Button btn_Chat = findViewById(R.id.btn_Chat);

        btn_NewGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent intent = new Intent(Coach_Home.this, Coach_NewGame.class);
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
    }
}