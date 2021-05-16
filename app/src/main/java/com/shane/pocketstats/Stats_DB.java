package com.shane.pocketstats;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DB_Entity_Stats.class}, version = 1)
public abstract class Stats_DB extends RoomDatabase {
    public abstract Stats_DAO stats_DAO();

    private static Stats_DB INSTANCE;
    // Initialise stats DB and get instance

    public static Stats_DB getDbInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Stats_DB.class, "Stats")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}