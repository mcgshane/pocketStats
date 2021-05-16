package com.shane.pocketstats;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Training_DAO {
    //CRUD querys on database
    @Query("SELECT id, Urls , Type FROM Training")
    List<DB_Entity_Training> getAll();

    @Insert
    void insertEntry(DB_Entity_Training... entry);

    @Delete
    void deleteEntry(DB_Entity_Training entry);

}
