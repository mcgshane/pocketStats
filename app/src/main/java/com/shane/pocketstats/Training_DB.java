package com.shane.pocketstats;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DB_Entity_Training.class}, version = 1)

public abstract class Training_DB extends RoomDatabase {
    public abstract Training_DAO training_dao();

    private static Room_DB INSTANCE;

    public static Room_DB getDbInstanceTraining(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Room_DB.class,"Training")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }





}