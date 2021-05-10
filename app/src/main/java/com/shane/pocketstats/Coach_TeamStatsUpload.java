package com.shane.pocketstats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

                //Update the screen with list of Data that was uploaded
                // statsDB.stats_DAO().getAll();

            }
        });


    }


    private List<DB_Entity_Stats> processImportFile() {

        FragmentManager fragmentManager = this.getSupportFragmentManager();
        this.fragment = (FileChooserFragment) fragmentManager.findFragmentById(R.id.fragment_fileChooser);
        String path = this.fragment.getPath();
        if (path.startsWith("/document/raw:")) {
            path = path.replaceFirst("/document/raw:", "");
        }
        String filename=path.substring(path.lastIndexOf("/")+1);

//        File file = getBaseContext().getFileStreamPath(path);
//        if (file.exists()) {
//            Toast.makeText(this, "Path: " + path, Toast.LENGTH_LONG).show();
//        }

        FileInputStream is; //  = Files.newInputStream(path); // getResources().openRawResource( R.raw.test);
        try {
            is = new FileInputStream(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";
        List<DB_Entity_Stats> players = new ArrayList<>();

        try {
            reader.readLine();
            String strGame, strName, strMinsPLayed, strFGs, strThrees, strTwos, strFreeTs;
//            String stroffrebound, strdefrebound, strtotrebound, strturnover, strsteal, strblock, strpts ;
            int iFGMade, iFGAttempted, ithreeptmade, ithreeptattempted, itwoptmade, itwoptattempted,iftptmade, iftptattempted;
            int ioffrebound, idefrebound, itotrebound, iturnover, isteal, iblock, ipts ;
            while ((line = reader.readLine()) != null) {
                //              Log.d("MyActivity", "Line: " + line);

                strGame = filename.substring(0, filename.length() - 4) ;
                String[] fields = line.split(",");

                strName=fields[0];
//                strMinsPLayed=fields[1];
//                iMinsPLayed = Integer.valueOf(strMinsPLayed.toString());

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
                iturnover = Integer.valueOf(fields[10].toString());
                isteal = Integer.valueOf(fields[11].toString());
                iblock = Integer.valueOf(fields[12].toString());
                ipts = Integer.valueOf(fields[14].toString());





                DB_Entity_Stats stat=new DB_Entity_Stats(strGame, strName, iFGMade, iFGAttempted, ithreeptmade, ithreeptattempted, itwoptmade, itwoptattempted,
                        iftptmade, iftptattempted, ioffrebound, idefrebound, itotrebound, iturnover, isteal, iblock, ipts);

                statsDB.stats_DAO().insert(stat);
                players.add(stat);

                //               Log.d(TAG, "Just created: " + mGender+mMeaning+mName+mOrigin);

            }

        } catch (IOException e) {
            //           Log.wtf("MyActivity", "Error reading data file on line" + line, e);
            e.printStackTrace();
        }
        return players;
    }
}