package com.shane.pocketstats;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Player_Indiv_Stats extends AppCompatActivity {

    TextView Fgoals, ThreePts, TwoPts, FT, OR, DR, TO, ST, BL;
    private RecyclerView rv_Stats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //read parameter sent by calling activity for player selection
        Bundle b = getIntent().getExtras();
        String player = b.getString("Player");
        setContentView(R.layout.player_indiv_stats);

        Fgoals = (TextView) findViewById(R.id.fieldGoals);
        ThreePts =(TextView) findViewById(R.id.threePts);
        TwoPts = (TextView) findViewById(R.id.twoPts);
        FT = (TextView) findViewById(R.id.freeT);
        OR = (TextView) findViewById(R.id.offR);
        DR = (TextView) findViewById(R.id.defR);
        TO = (TextView) findViewById(R.id.turnO);
        ST = (TextView) findViewById(R.id.steal);
        BL = (TextView) findViewById(R.id.block);


    //intialize stats DB and get stats for the player signed in
        Stats_DB statsDB = Stats_DB.getDbInstance(this.getApplicationContext());
        List<DB_Entity_Stats> stats = statsDB.stats_DAO().getPlayer(player.toLowerCase());

        rv_Stats = findViewById(R.id.player_rec_view);
        //Initalize the recycler view adapter and link to main layout page
        Indiv_Stats_Adapter inDivAdapter = new Indiv_Stats_Adapter(this, stats);

        rv_Stats.setLayoutManager(new LinearLayoutManager(this));
        rv_Stats.setAdapter(inDivAdapter);

    }
}
