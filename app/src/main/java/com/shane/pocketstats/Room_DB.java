package com.shane.pocketstats;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DB_Entity_Fixtures.class}, version = 1)

    public abstract class Room_DB extends RoomDatabase {
    public abstract Fixtures_DAO fixtures_DAO();

    private static Room_DB INSTANCE;

    public static Room_DB getDbInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Room_DB.class, "Fixtures")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

}

