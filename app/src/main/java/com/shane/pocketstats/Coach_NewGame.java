package com.shane.pocketstats;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Coach_NewGame extends AppCompatActivity {
    private Button btn_player1;
    private Button btn_player2;
    private Button btn_player3;
    private Button btn_player4;
    private Button btn_player5;
    private Button btn_3_pt_scored;
    private Button btn_3_pt_missed;
    private Button btn_2_pt_scored;
    private Button btn_2_pt_missed;
    private Button btn_ft_scored;
    private Button btn_ft_missed;
    private Button btn_off_rebound;
    private Button btn_def_rebound;
    private Button btn_turnover;
    private Button btn_steal;
    private Button btn_block;
    private Button btn_Subs;
    private Button btn_Save;
    private EditText et_FixtureName;

    Stats_DB statsDB;

    //private Button btn_def_block;
    List<DB_Entity_Stats> playersStats = new ArrayList<>();
    private String[] squad = {"SarahM", "EdelT", "CarolynB", "KateM", "NiamhK", "KatieG", "LaurenG"};
    private Boolean [] startingPlayer = new Boolean[]{
            false, false, false,false, false, false,false
    };
    private static String player_Selected = null;

    SharedPreferences sharedPrefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getting settings values from preference screen
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        for (String player : squad) {
            DB_Entity_Stats stat = new DB_Entity_Stats("", player, 0, 0, 0,0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0, 0);
            playersStats.add(stat);
        }

        //find player button

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
        Button btn_Subs = findViewById(R.id.btn_Subs);
        Button btn_Save = findViewById(R.id.btn_Save);
        Button btn_assist = findViewById(R.id.btn_assist);
        TextView tvDisplay = findViewById(R.id.tvDisplay);
        EditText et_FixtureName = findViewById(R.id.et_FixtureName);

        btn_Player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                player_Selected = btn_Player1.getText().toString();


            }
        });

        btn_Player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                player_Selected = btn_Player2.getText().toString();


            }
        });

        btn_Player3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                player_Selected = btn_Player3.getText().toString();


            }
        });

        btn_Player4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                player_Selected = btn_Player4.getText().toString();


            }
        });

        btn_Player5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                player_Selected = btn_Player5.getText().toString();


            }
        });

        btn_3_pt_scored.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(tvDisplay.getText() + "\n"+ player_Selected + " has scored 3 points ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected)) {
                            int Fgmade = player.getFgmade();
                            int ThreePtMade = player.getThreeptmade();
                            ThreePtMade++;
                            Fgmade++;
                            player.setFgmade(Fgmade);
                            player.setThreeptmade(ThreePtMade);

                        }
                    }
                    //player_Selected = "";
                }
            }
        });

        btn_3_pt_missed.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(tvDisplay.getText() + "\n"+ player_Selected + " has missed 3 points ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int FgAttempted = player.getFgattempted();
                            int ThreePtAttempted = player.getThreeptattempted();
                            ThreePtAttempted ++;
                            FgAttempted ++;
                            player.setFgattempted(FgAttempted);
                            player.setThreeptattempted(ThreePtAttempted);

                        }
                    }

                }
            }
        });

        btn_2_pt_scored.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recorded see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(tvDisplay.getText() + "\n"+ player_Selected + " has scored 2 points ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int Fgmade = player.getFgmade();
                            int twoptmade = player.getTwoptmade();
                            twoptmade ++;
                            Fgmade ++;
                            player.setFgmade(Fgmade);
                            player.setTwoptmade(twoptmade);

                        }
                    }

                }
            }
        });

        btn_2_pt_missed.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(tvDisplay.getText() + "\n"+ player_Selected + " has missed 2 points ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int FgAttempted = player.getFgattempted();
                            int TwoPtAttempted = player.getTwoptattempted();
                            TwoPtAttempted ++;
                            FgAttempted ++;
                            player.setFgattempted(FgAttempted);
                            player.setTwoptattempted(TwoPtAttempted);

                        }
                    }

                }
            }
        });

        btn_ft_scored.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(tvDisplay.getText() + "\n"+ player_Selected + " has scored a Free throw ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int Fgmade = player.getFgmade();
                            int FtMade = player.getFtmade();
                            FtMade ++;
                            Fgmade ++;
                            player.setFgmade(Fgmade);
                            player.setFtmade(FtMade);

                        }
                    }

                }
            }
        });

                btn_ft_missed.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(tvDisplay.getText() + "\n"+ player_Selected + " has missed a Free throw ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int FgAttempted = player.getFgattempted();
                            int FtAttempted = player.getFtattempted();
                            FtAttempted ++;
                            FgAttempted ++;
                            player.setFgattempted(FgAttempted);
                            player.setFtattempted(FtAttempted);

                        }
                    }

                }
            }
        });
                btn_assist.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(tvDisplay.getText() + "\n"+ player_Selected + " has earned a assist ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int Assist = player.getAssist();
                            Assist ++;
                            player.setAssist(Assist);

                        }
                    }

                }
            }
        });

                btn_off_rebound.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(tvDisplay.getText() + "\n"+ player_Selected + " has got a offensive rebound ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int OffRebound = player.getOffrebound();
                            OffRebound ++;
                            player.setOffrebound(OffRebound);

                        }
                    }

                }
            }
        });

         btn_def_rebound.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(tvDisplay.getText() + "\n"+ player_Selected + " has got a defensive rebound ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int DefRebound = player.getDefrebound();
                            DefRebound ++;
                            player.setDefrebound(DefRebound);

                        }
                    }

                }
            }
        });

        btn_turnover.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(tvDisplay.getText() + "\n"+ player_Selected + " has turned over the ball ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int Turnovers = player.getTurnovers();
                            Turnovers ++;
                            player.setTurnovers(Turnovers);

                        }
                    }

                }
            }
        });

        btn_block.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(tvDisplay.getText() + "\n"+ player_Selected + " has blocked the shot ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int Blocks = player.getBlocks();
                            Blocks ++;
                            player.setBlocks(Blocks);

                        }
                    }

                }
            }
        });

        btn_steal.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(tvDisplay.getText() + "\n"+ player_Selected + " has stolen the ball ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int Steals = player.getSteals();
                            Steals ++;
                            player.setSteals(Steals);

                        }
                    }

                }
            }
        });

        btn_Save.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            EditText Game = et_FixtureName;
                                            statsDB = Stats_DB.getDbInstance(getApplicationContext());
                                            for (DB_Entity_Stats player : playersStats) {
                                                String name = player.getName();
                                                int ThreePtMade = player.getThreeptmade();
                                                int ThreePtMissed = player.getThreeptattempted();
                                                int TwoPtMade = player.getTwoptmade();
                                                int TwoPtMissed = player.getTwoptattempted();
                                                int FtMade = player.getFtmade();
                                                int FtMissed = player.getFgattempted();
                                                int fgMade = ThreePtMade + TwoPtMade + FtMade;
                                                int fgAttempted = ThreePtMade + ThreePtMissed + TwoPtMade + TwoPtMissed + FtMade + FtMissed;
                                                int ThreePtAttempted = ThreePtMade + ThreePtMissed;
                                                int TwoPtAttempted = TwoPtMade + TwoPtMissed;
                                                int FtAttempted = FtMade + FtMissed;
                                                int PointsScored = ThreePtMade * 3 + TwoPtMade * 2 + FtMade * 1;
                                                int Steals = player.getSteals();
                                                int Block = player.getBlocks();
                                                int Turnover = player.getTurnovers();
                                                int Assist = player.getAssist();
                                                int OffRebound = player.getOffrebound();
                                                int DefRebound = player.getDefrebound();
                                                int TotRebounds = OffRebound + DefRebound;
                                                DB_Entity_Stats stat = new DB_Entity_Stats(et_FixtureName.getText().toString(), name, fgMade, fgAttempted, ThreePtMade, ThreePtAttempted, TwoPtMade, TwoPtAttempted,
                                                        FtMade, FtAttempted, OffRebound, DefRebound, TotRebounds, Assist, Turnover, Steals, Block, PointsScored);

                                                statsDB.stats_DAO().insert(stat);

                                                Intent intent = new Intent(Coach_NewGame.this, Coach_Home.class);
                                                startActivity(intent);

                                            }
                                        }
        });


        btn_Subs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTeamSelection();

            }


            private void showTeamSelection() {
                AlertDialog.Builder builder = new AlertDialog.Builder(Coach_NewGame.this);
                builder.setTitle("Select Starting 5 Players")
                        .setMultiChoiceItems(squad, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                            }
                        })
                        .setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int a = 0;
                                int i = 1;
                                while (a < startingPlayer.length) {
                                    boolean value = startingPlayer[a];

                                    if (value) {
                                        Button button = (Button) findViewById(getResources().getIdentifier("btn_Player" + i, "id", "com.shane.pocketstats"));
                                        button.setText(startingPlayer[a].toString());
                                    }
                                    i++;
                                    a++;
                                }

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();
            }
        });
    }

}




