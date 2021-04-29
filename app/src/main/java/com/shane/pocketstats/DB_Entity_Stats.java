package com.shane.pocketstats;

import androidx.room.*;

@Entity(tableName = "Stats")
public class DB_Entity_Stats {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "game")
    private String game;

    @ColumnInfo(name = "name")
    private String name;

/*
    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;
*/

    @ColumnInfo(name = "minspLayed")
    private int minspLayed;

    @ColumnInfo(name = "fgmade")
    private int fgmade;

    @ColumnInfo(name = "fgattempted")
    private int fgattempted;

    @ColumnInfo(name = "ThreePtMade")
    private int ThreePtMade;

    @ColumnInfo(name = "ThreePtMissed")
    private int ThreePtMissed;

    //@ColumnInfo(name = "FgMissed")
    //private int FgMissed;

    //@ColumnInfo(name = "TwoPtMade")
    //private int TwoPtMade;

    //@ColumnInfo(name = "TwoPtMissed")
    //private int TwoPtMissed;

    //@ColumnInfo(name = "FtMade")
    //private int FtMade;

    //@ColumnInfo(name = "FtMissed")
    //private int FtMissed;

    //@ColumnInfo(name = "OffRebound")
    //private int OffRebound;

    //@ColumnInfo(name = "DefRebound")
    //private int DefRebound;

    //@ColumnInfo(name = "Assist")
    //private int Assist;

    //@ColumnInfo(name = "Steal")
    //private int Steal;

    //@ColumnInfo(name = "Turnover")
    //private int Turnover;

    //@ColumnInfo(name = "Block")
    //private int Block;

// add 3 pt columns
    public DB_Entity_Stats(String game, String name, int minspLayed, int fgmade, int fgattempted) {
        this.id = id;
        this.game = game;
        this.name = name;
        this.minspLayed = minspLayed;
        this.fgmade = fgmade;
        this.fgattempted = fgattempted;
    }

    public DB_Entity_Stats(String game, String name, int ThreePtMade, int ThreePtMissed ) {
        this.id = id;
        this.game = game;
        this.name = name;
        this.ThreePtMade = ThreePtMade;
        this.ThreePtMissed = ThreePtMissed;
        //this.FgMissed = FgMissed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinspLayed() {
        return minspLayed;
    }

    public void setMinspLayed(int minspLayed) {
        this.minspLayed = minspLayed;
    }

    public int getFgmade() {
        return fgmade;
    }

    public void setFgmade(int fgmade) {
        this.fgmade = fgmade;
    }

    public int getFgattempted() {
        return fgattempted;
    }

    public void setFgattempted(int fgattempted) {
        this.fgattempted = fgattempted;
    }

    public int getThreePtMade() {
        return ThreePtMade;
    }

    public void setThreePtMade(int threePtMade) {
        ThreePtMade = threePtMade;
    }

    public int getThreePtMissed() {
        return ThreePtMissed;
    }

    public void setThreePtMissed(int threePtMissed) {
        ThreePtMissed = threePtMissed;
    }

    //public int getFgMissed() {
        //return FgMissed;
    //}

    //public void setFgMissed(int fgMissed) {
       // FgMissed = fgMissed;
    //}
}
