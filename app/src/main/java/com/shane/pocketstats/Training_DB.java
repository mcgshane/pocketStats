package com.shane.pocketstats;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DB_Entity_Training.class}, version = 1)

public abstract class Training_DB extends RoomDatabase  {
    public abstract Training_DAO training_DAO();

    private static Training_DB INSTANCE;

    public static Training_DB getDbInstanceTraining(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Training_DB.class,"Training")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }





}