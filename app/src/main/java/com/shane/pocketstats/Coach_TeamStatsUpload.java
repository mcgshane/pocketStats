package com.shane.pocketstats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Coach_TeamStatsUpload extends AppCompatActivity {

    Stats_DB statsDB;
    private FileChooserFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_team_stats_upload);
        statsDB = Stats_DB.getDbInstance(getApplicationContext());

        Button btnUpload = (Button) findViewById(R.id.btnupload);

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<DB_Entity_Stats> playerStats =  processImportFile();
                statsDB.stats_DAO().insertAll(playerStats);

                Toast toast = Toast.makeText(getApplicationContext(),"Upload Completed" ,Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(Coach_TeamStatsUpload.this, Coach_Home.class);
                startActivity(intent);

            }
        });


    }


    private List<DB_Entity_Stats> processImportFile() {

        //Initialise file selection Fragment . Fragment on screen has tb and button Upload button
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        this.fragment = (FileChooserFragment) fragmentManager.findFragmentById(R.id.fragment_fileChooser);
        // gets the path of file selected file and uts it into text box
        String path = this.fragment.getPath();
        if (path.startsWith("/document/raw:")) {
            path = path.replaceFirst("/document/raw:", "");
        }
        //creating file name of the csv selected
        String filename=path.substring(path.lastIndexOf("/")+1);
        // Opens the file into memory
        FileInputStream is;
        try {
            is = new FileInputStream(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //Stores file into buffer reader for processing
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";
        //Initalisng player Array of type Db Entity Stats
        List<DB_Entity_Stats> players = new ArrayList<>();
    // reading the reader line by line
        try {
            reader.readLine();
            String strGame, strName, strMinsPLayed, strFGs, strThrees, strTwos, strFreeTs;

            int iFGMade, iFGAttempted, ithreeptmade, ithreeptattempted, itwoptmade, itwoptattempted,iftptmade, iftptattempted;
            int ioffrebound, idefrebound, itotrebound, iassist, iturnover, isteal, iblock, ipts ;
            //loops through fields on the line storing data in local variables
            while ((line = reader.readLine()) != null) {

                strGame = filename.substring(0, filename.length() - 4) ;
                String[] fields = line.split(",");

                strName=fields[0];

                strFGs=fields[2];
                String[] fgs = strFGs.split("/");
                iFGMade = Integer.valueOf(fgs[0].toString());
                iFGAttempted = Integer.valueOf(fgs[1].toString());

                strThrees=fields[3];
                String[] threes = strThrees.split("/");
                ithreeptmade = Integer.valueOf(threes[0].toString());
                ithreeptattempted = Integer.valueOf(threes[1].toString());

                strTwos=fields[4];
                String[] twos = strTwos.split("/");
                itwoptmade = Integer.valueOf(twos[0].toString());
                itwoptattempted = Integer.valueOf(twos[1].toString());

                strFreeTs=fields[5];
                String[] fts = strFreeTs.split("/");
                iftptmade = Integer.valueOf(fts[0].toString());
                iftptattempted = Integer.valueOf(fts[1].toString());

                ioffrebound = Integer.valueOf(fields[6].toString());
                idefrebound = Integer.valueOf(fields[7].toString());
                itotrebound = Integer.valueOf(fields[8].toString());
                iassist = Integer.valueOf(fields[9].toString());
                iturnover = Integer.valueOf(fields[10].toString());

                isteal = Integer.valueOf(fields[11].toString());
                iblock = Integer.valueOf(fields[12].toString());
                ipts = Integer.valueOf(fields[14].toString());




            // Creates a new DB Entity record
                DB_Entity_Stats stat=new DB_Entity_Stats(strGame, strName, iFGMade, iFGAttempted, ithreeptmade, ithreeptattempted, itwoptmade, itwoptattempted,
                        iftptmade, iftptattempted, ioffrebound, idefrebound, itotrebound, iassist, iturnover, isteal, iblock, ipts);

                // adds db Entity record to player Array
                players.add(stat);


            }

        } catch (IOException e) {

            e.printStackTrace();
        }
        return players;
    }
}