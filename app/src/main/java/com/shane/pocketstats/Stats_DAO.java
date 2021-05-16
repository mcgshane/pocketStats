package com.shane.pocketstats;

import androidx.room.*;

import java.util.List;


@Dao
public interface Stats_DAO {
    //CRUD querys for database

    @Query("SELECT * FROM stats")
    List<DB_Entity_Stats> getAll();

    @Query("SELECT * FROM stats")
    List<DB_Entity_Stats> getLast();

    @Query("SELECT * FROM stats WHERE LOWER(name) = :playerName")
    List<DB_Entity_Stats> getPlayer(String playerName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<DB_Entity_Stats> stats);

    @Insert
    void insert(DB_Entity_Stats stat);

    @Delete
    void Delete(DB_Entity_Stats stat);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void Update(DB_Entity_Stats stat);

}
