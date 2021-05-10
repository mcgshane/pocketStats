package com.shane.pocketstats;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
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
            DB_Entity_Stats stat = new DB_Entity_Stats("Fix1", player, 0, 0, 0, 0, 0, 0,
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
        TextView tvDisplay = findViewById(R.id.tvDisplay);
        String et_FixtureName = " ";

// loop through squad -
// i=1
// find flag of who on court
        //if on court set butt+i.settext (butt1)=player.name

// refactor to setplayerbuttons()


        btn_Player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                player_Selected = btn_Player1.getText().toString();


            }
        });

        btn_3_pt_scored.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(player_Selected + " has scored 3 points ");

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

        /*btn_3_pt_missed.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(player_Selected + " has missed 3 points ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int FgMissed = player.getFgMissed();
                            int ThreePtMissed = player.getThreePtMissed();
                            ThreePtMissed ++;
                            FgMissed ++;
                            player.setFgMissed(FgMissed);
                            player.setThreePtMissed(ThreePtMissed);

                        }
                    }

                }
            }
        });*/

        /*btn_2_pt_scored.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(player_Selected + " has scored 2 points ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int Fgmade = player.getFgmade();
                            int TwoPtMade = player.getTwoPtMade();
                            TwoPtMade ++;
                            FgScored ++;
                            player.setFgmade(Fgmade);
                            player.setTwoPtMade(TwoPtMade);

                        }
                    }

                }
            }
        });*/

        /*btn_2_pt_missed.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(player_Selected + " has missed 2 points ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int FgMissed = player.getFgMissed();
                            int TwoPtMissed = player.getTwoPtMissed();
                            TwoPtMissed ++;
                            FgMissed ++;
                            player.setFgMissed(FgMissed);
                            player.setTwoPtMissed(TwoPtMissed);

                        }
                    }

                }
            }
        });*/

        /*btn_ft_scored.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(player_Selected + " has scored a Free throw ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int Fgmade = player.getFgmade();
                            int FtMade = player.getFtMade();
                            FtMade ++;
                            Fgmade ++;
                            player.setFgmade(Fgmade);
                            player.setFtMade(FtMade);

                        }
                    }

                }
            }
        });*/

                /*btn_ft_missed.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(player_Selected + " has missed a Free throw ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int FgMissed = player.getFgMissed();
                            int FtMissed = player.getFtMissed();
                            FtMissed ++;
                            FgMissed ++;
                            player.setFgMissed(FgMissed);
                            player.setFtMissed(FtMissed);

                        }
                    }

                }
            }
        });*/
                /*btn_assist.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(player_Selected + " has earned a assist ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int Assist = player.getAssist();
                            Assist ++;
                            player.setAssist(Assist);

                        }
                    }

                }
            }
        });*/

                /*btn_off_rebound.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(player_Selected + " has got a offensive rebound ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int OffRebound = player.getOffRebound();
                            OffRebound ++;
                            player.setOffRebound(OffRebound);

                        }
                    }

                }
            }
        });*/

         /*btn_def_rebound.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(player_Selected + " has got a defensive rebound ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int DefRebound = player.getDefRebound();
                            DefRebound ++;
                            player.setDefRebound(DefRebound);

                        }
                    }

                }
            }
        });*/

        /*btn_turnover.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(player_Selected + " has turned over the ball ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int Turnover = player.getTurnover();
                            Turnover ++;
                            player.setTurnover(TurnOver);

                        }
                    }

                }
            }
        });*/

        /*btn_block.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(player_Selected + " has blocked the shot ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int Block = player.getBlock();
                            Block ++;
                            player.setBlock(Block);

                        }
                    }

                }
            }
        });*/

        /*btn_steal.setOnClickListener(new View.OnClickListener() {
            //loop through array get name for each recored see does it match player seecetd if it does get the 3 point value and set it back .All 7 players
            @Override
            public void onClick(View v) {
                if (!player_Selected.isEmpty()) {
                    tvDisplay.setText(player_Selected + " has stolen the ball ");

                    for (DB_Entity_Stats player : playersStats) {
                        if (player.getName().equals(player_Selected) ) {
                            int Steal = player.getSteal();
                            Steal ++;
                            player.setSteal(Steal);

                        }
                    }

                }
            }
        });*/
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Game = et_FixtureName;
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
                    int OffRebound = player.getOffrebound();
                    int DefRebound = player.getDefrebound();
                    DB_Entity_Stats stat = new DB_Entity_Stats(et_FixtureName, name, fgMade, fgAttempted, ThreePtMade, ThreePtAttempted, TwoPtMade, TwoPtAttempted,
                            FtMade, FtAttempted, OffRebound, DefRebound, OffRebound, Turnover, Steals, Block, PointsScored);

                    //   statsDB.stats_DAO().insert(stat);

                }


                btn_Subs.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showTeamSelection();

                    }
                });
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




