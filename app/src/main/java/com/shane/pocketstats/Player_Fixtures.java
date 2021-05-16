package com.shane.pocketstats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

//Data Entity for Room DB

public class Player_Fixtures extends AppCompatActivity {

    private RecyclerView rv_Fixtures;
//    FixturesListAdapter adapter;
//    private ArrayList<DB_Entity_Fixtures> fixtures;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_fixtures);

        
        Room_DB fixDB = Room_DB.getDbInstance(this.getApplicationContext());
        List<DB_Entity_Fixtures> fixtures = fixDB.fixtures_DAO().getAll();

        rv_Fixtures = findViewById(R.id.recycler_view);
        FixturesListAdapter adapter = new FixturesListAdapter(this, fixtures);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);


        rv_Fixtures.setLayoutManager(layoutManager);
        rv_Fixtures.setAdapter(adapter);
    }

}