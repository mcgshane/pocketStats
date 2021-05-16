package com.shane.pocketstats;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Fixtures_DAO {
    //CRUD Querys for database
    @Query("SELECT date,venue,opponent,time FROM Fixtures")
    List<DB_Entity_Fixtures> getAll();

    @Insert
    void insertEntry(DB_Entity_Fixtures... entry);

    @Delete
    void deleteEntry(DB_Entity_Fixtures entry);


}
