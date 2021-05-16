package com.shane.pocketstats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class Player_Training extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_training);

        // Intialize recyler view
        RecyclerView rv_Training;
            // Initialise train DB Instance and get data
            Training_DB trainDB = Training_DB.getDbInstanceTraining(this.getApplicationContext());
            List<DB_Entity_Training> trainings = trainDB.training_DAO().getAll();

            // link adapter to relevant layout page
            rv_Training = findViewById(R.id.train_rec_view);
            TrainingAdapter adapter = new TrainingAdapter(this, trainings);

            rv_Training.setLayoutManager(new LinearLayoutManager(this));
            rv_Training.setAdapter(adapter);

    }
}