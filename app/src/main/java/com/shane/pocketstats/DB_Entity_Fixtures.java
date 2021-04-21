package com.shane.pocketstats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Room;


//Data Entity for Room DB
    @Entity(tableName = "Fixtures")
    public class DB_Entity_Fixtures{

 /*   public DB_Entity_Fixtures(String date, String venue) {
        this.date = date;
       //this.opponent = opponent;
        this.venue = venue;
        //this.time = time;
    }*/

    @PrimaryKey
    @NonNull
     private String date;

    @ColumnInfo(name = "opponent")
    private String opponent;

    @ColumnInfo(name = "venue")
    private String venue;

    @ColumnInfo(name = "time")
    private String time;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



}

