package com.shane.pocketstats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

//Data Entity for Room DB

public class Coach_Fixtures extends AppCompatActivity {

    private EditText et_Date, et_Venue,et_Time, et_Opponent;
    private Button Save;
    private RecyclerView rv_Fixtures;
//    FixturesListAdapter adapter;
//    private ArrayList<DB_Entity_Fixtures> fixtures;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_fixtures);

        et_Date = (EditText) findViewById(R.id.et_Date);
        et_Time = (EditText) findViewById(R.id.et_Time);
        et_Opponent = (EditText) findViewById(R.id.et_Opponent);
        et_Venue = (EditText) findViewById(R.id.et_Venue);
        Save = (Button) findViewById(R.id.Save);

        // Intizaing the database and retreive data
        Room_DB fixDB = Room_DB.getDbInstance(this.getApplicationContext());
        List<DB_Entity_Fixtures> fixtures = fixDB.fixtures_DAO().getAll();

        //Intizing the recyler view and link to layout view page
        rv_Fixtures = findViewById(R.id.recycler_view);
        FixturesListAdapter adapter = new FixturesListAdapter(this, fixtures);

        rv_Fixtures.setLayoutManager(new LinearLayoutManager(this));
        rv_Fixtures.setAdapter(adapter);

    // saving  the fixtures
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFixtures(et_Date.getText().toString(),et_Venue.getText().toString(),et_Time.getText().toString(),et_Opponent.getText().toString());

                }

        });

    }
 // saving fixtures into the table
    public void saveFixtures(String et_Date, String et_Venue, String et_Opponent, String et_Time){

      Room_DB fixDB = Room_DB.getDbInstance(this.getApplicationContext());

      DB_Entity_Fixtures entry = new DB_Entity_Fixtures();
      entry.setDate(et_Date);
      entry.setVenue(et_Venue);
      entry.setTime(et_Time);
      entry.setOpponent(et_Opponent);
      fixDB.fixtures_DAO().insertEntry(entry);

        Toast toast = Toast.makeText(getApplicationContext(),"Fixture Saved" ,Toast.LENGTH_SHORT);
        toast.show();

    }

    private void setRecyclerView(){
        findViewById(R.id.Save);
    }

    private void getAllFixtures() {

    }


}