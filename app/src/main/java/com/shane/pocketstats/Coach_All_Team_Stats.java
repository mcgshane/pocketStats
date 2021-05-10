package com.shane.pocketstats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.shane.pocketstats.IndivStats.CarolynB_Indiv_Stats;
import com.shane.pocketstats.IndivStats.EdelT_Indiv_Stats;
import com.shane.pocketstats.IndivStats.KateM_Indiv_Stats;
import com.shane.pocketstats.IndivStats.KatieG_Indiv_Stats;
import com.shane.pocketstats.IndivStats.LaurenG_Indiv_Stats;
import com.shane.pocketstats.IndivStats.NiamhK_Indiv_Stats;
import com.shane.pocketstats.IndivStats.SarahM_Indiv_Stats;

public class Coach_All_Team_Stats extends AppCompatActivity implements View.OnClickListener {

    private CardView SarahM, EdelT, CarolynB, KateM, NiamhK, KatieG, LaurenG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_all_team_stats);

        SarahM = (CardView) findViewById(R.id.SarahM_Card);
        EdelT = (CardView) findViewById(R.id.EdelT_Card);
        CarolynB = (CardView) findViewById(R.id.CarolynB_Card);
        KateM = (CardView) findViewById(R.id.KateM_Card);
        NiamhK = (CardView) findViewById(R.id.NiamhK_Card);
        KatieG = (CardView) findViewById(R.id.KatieG_Card);
        LaurenG = (CardView) findViewById(R.id.LaurenG_Card);

        SarahM.setOnClickListener(this);
        EdelT.setOnClickListener(this);
        CarolynB.setOnClickListener(this);
        KateM.setOnClickListener(this);
        NiamhK.setOnClickListener(this);
        KatieG.setOnClickListener(this);
        LaurenG.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.SarahM_Card:
                i = new Intent(this, SarahM_Indiv_Stats.class);
                startActivity(i);
                break;

            case R.id.EdelT_Card:
                i = new Intent(this, EdelT_Indiv_Stats.class);
                startActivity(i);
                break;

            case R.id.CarolynB_Card:
                i = new Intent(this, CarolynB_Indiv_Stats.class);
                startActivity(i);
                break;

            case R.id.KateM_Card:
                i = new Intent(this, KateM_Indiv_Stats.class);
                startActivity(i);
                break;

            case R.id.NiamhK_Card:
                i = new Intent(this, NiamhK_Indiv_Stats.class);
                startActivity(i);
                break;

            case R.id.KatieG_Card:
                i = new Intent(this, KatieG_Indiv_Stats.class);
                startActivity(i);
                break;

            case R.id.LaurenG_Card:
                i = new Intent(this, LaurenG_Indiv_Stats.class);
                startActivity(i);
                break;
        }

    }
}
