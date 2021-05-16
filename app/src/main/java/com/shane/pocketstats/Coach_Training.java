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

//Data Entity for Training DB

public class Coach_Training extends AppCompatActivity {

    private EditText et_Url, et_Type ;
    private Button Save;
    private RecyclerView rv_Training;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_training);

        et_Type = (EditText) findViewById(R.id.et_Type);
        et_Url = (EditText) findViewById(R.id.et_Url);
        Save = (Button) findViewById(R.id.Save);

        //       getAllTraining();
        Training_DB training_DB = Training_DB.getDbInstanceTraining(this.getApplicationContext());
        List<DB_Entity_Training> training = training_DB.training_DAO().getAll();

        if (!training.isEmpty()) {
            rv_Training = findViewById(R.id.recycler_view);
            TrainingAdapter adapter = new TrainingAdapter(this, training);

            rv_Training.setLayoutManager(new LinearLayoutManager(this));
            rv_Training.setAdapter(adapter);
        }

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTraining(et_Url.getText().toString(), et_Type.getText().toString());
            }

        });
    }
// Saving the data from the textfields and inserting into the table
    public void saveTraining(String et_Url, String et_Type){

        Training_DB trainDB = Training_DB.getDbInstanceTraining(this.getApplicationContext());

        DB_Entity_Training entry = new DB_Entity_Training();
        entry.setUrls(et_Url);
        entry.setType(et_Type);
        trainDB.training_DAO().insertEntry(entry);

        Toast toast = Toast.makeText(getApplicationContext(),"Url has been uploaded" ,Toast.LENGTH_SHORT);
        toast.show();

        //finish();
    }

    private void setRecyclerView(){
        findViewById(R.id.Save);
    }

    private void getAllTraining() {

    }


}