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

//    @ColumnInfo(name = "minspLayed")
//    private int minspLayed;

    @ColumnInfo(name = "fgmade")
    private int fgmade;

    @ColumnInfo(name = "fgattempted")
    private int fgattempted;

    @ColumnInfo(name = "threeptmade")
    private int threeptmade;

    @ColumnInfo(name = "threeptattempted")
    private int threeptattempted;

    @ColumnInfo(name = "twoptmade")
    private int twoptmade;

    @ColumnInfo(name = "twoptattempted")
    private int twoptattempted;

    @ColumnInfo(name = "ftmade")
    private int ftmade;

    @ColumnInfo(name = "ftattempted")
    private int ftattempted;

    @ColumnInfo(name = "offrebound")
    private int offrebound;

    @ColumnInfo(name = "defrebound")
    private int defrebound;

    @ColumnInfo(name = "totrebound")
    private int totrebound;

    @ColumnInfo(name = "turnovers")
    private int turnovers;

    @ColumnInfo(name = "steals")
    private int steals;

    @ColumnInfo(name = "blocks")
    private int blocks;

    @ColumnInfo(name = "points")
    private int points;



    public DB_Entity_Stats(String game, String name, int fgmade, int fgattempted, int  threeptmade , int  threeptattempted,
                           int twoptmade, int twoptattempted, int ftmade, int ftattempted, int offrebound, int defrebound,
                           int totrebound, int turnovers, int steals, int blocks, int points ) {
        this.id = id;
        this.game = game;
        this.name = name;
        this.fgmade = fgmade;
        this.fgattempted = fgattempted;
        this.threeptmade = threeptmade;
        this.threeptattempted = threeptattempted;
        this.twoptmade = twoptmade;
        this.twoptattempted = twoptattempted;
        this.ftmade = ftmade;
        this.ftattempted = ftattempted;
        this.offrebound = offrebound;
        this.defrebound = defrebound;
        this.totrebound = totrebound;
        this.turnovers = turnovers;
        this.steals = steals;
        this.blocks = blocks;
        this.points = points;
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

    public int getThreeptmade() {
        return threeptmade;
    }

    public void setThreeptmade(int threeptmade) {
        this.threeptmade = threeptmade;
    }

    public int getThreeptattempted() {
        return threeptattempted;
    }

    public void setThreeptattempted(int threeptattempted) {
        this.threeptattempted = threeptattempted;
    }

    public int getTwoptmade() {
        return twoptmade;
    }

    public void setTwoptmade(int twoptmade) {
        this.twoptmade = twoptmade;
    }

    public int getTwoptattempted() {
        return twoptattempted;
    }

    public void setTwoptattempted(int twoptattempted) {
        this.twoptattempted = twoptattempted;
    }

    public int getFtmade() {
        return ftmade;
    }

    public void setFtmade(int ftmade) {
        this.ftmade = ftmade;
    }

    public int getFtattempted() {
        return ftattempted;
    }

    public void setFtattempted(int ftattempted) {
        this.ftattempted = ftattempted;
    }

    public int getOffrebound() {
        return offrebound;
    }

    public void setOffrebound(int offrebound) {
        this.offrebound = offrebound;
    }

    public int getDefrebound() {
        return defrebound;
    }

    public void setDefrebound(int defrebound) {
        this.defrebound = defrebound;
    }

    public int getTotrebound() {
        return totrebound;
    }

    public void setTotrebound(int totrebound) {
        this.totrebound = totrebound;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(int turnovers) {
        this.turnovers = turnovers;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
