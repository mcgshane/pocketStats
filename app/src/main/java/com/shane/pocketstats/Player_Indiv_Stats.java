package com.shane.pocketstats;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Player_Indiv_Stats extends AppCompatActivity {

    TextView Fgoals, ThreePts, TwoPts;
    private RecyclerView rv_Stats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        Bundle b = getIntent().getExtras();
        String player = b.getString("Player");
        setContentView(R.layout.player_indiv_stats);

        Fgoals = (TextView) findViewById(R.id.fieldGoals);
        ThreePts =(TextView) findViewById(R.id.threePts);
        TwoPts = (TextView) findViewById(R.id.twoPts);


        Stats_DB statsDB = Stats_DB.getDbInstance(this.getApplicationContext());
        List<DB_Entity_Stats> stats = statsDB.stats_DAO().getPlayer(player);

        rv_Stats = findViewById(R.id.player_rec_view);
        Indiv_Stats_Adapter inDivAdapter = new Indiv_Stats_Adapter(this, stats);

        rv_Stats.setLayoutManager(new LinearLayoutManager(this));
        rv_Stats.setAdapter(inDivAdapter);


        //for (DB_Entity_Stats gameStats : stats) {
        //}
    }
}
