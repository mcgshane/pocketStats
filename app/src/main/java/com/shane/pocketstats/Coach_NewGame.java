package com.shane.pocketstats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Coach_NewGame extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_new_game);

        Button btn_Player1 = findViewById(R.id.btn_Player1);
        Button btn_Player2 = findViewById(R.id.btn_Player2);
        Button btn_Player3 = findViewById(R.id.btn_Player3);
        Button btn_Player4 = findViewById(R.id.btn_Player4);
        Button btn_Player5 = findViewById(R.id.btn_Player5);
        Button btn_3_pt_scored = findViewById(R.id.btn_3_pt_scored);
        Button btn_3_pt_missed = findViewById(R.id.btn_3_pt_missed);
        Button btn_2_pt_scored = findViewById(R.id.btn_2_pt_scored);
        Button btn_2_pt_missed = findViewById(R.id.btn_2_pt_missed);
        Button btn_ft_scored = findViewById(R.id.btn_ft_scored);
        Button btn_ft_missed = findViewById(R.id.btn_ft_missed);
        Button btn_off_rebound = findViewById(R.id.btn_off_rebound);
        Button btn_def_rebound = findViewById(R.id.btn_def_rebound);
        Button btn_turnover = findViewById(R.id.btn_turnover);
        Button btn_steal = findViewById(R.id.btn_steal);
        Button btn_block = findViewById(R.id.btn_block);
        Button btn_def_block = findViewById(R.id.btn_def_block);

        btn_3_pt_scored.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_3_pt_missed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_2_pt_scored.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_2_pt_missed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_ft_scored.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_ft_missed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}