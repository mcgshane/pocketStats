package com.shane.pocketstats;

import androidx.room.*;
import java.util.List;


@Dao
public interface Stats_DAO {

    @Query("SELECT * FROM stats")
    List<DB_Entity_Stats> getAll();

    @Query("SELECT * FROM stats")
    List<DB_Entity_Stats> getLast();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<DB_Entity_Stats> stats);

    @Insert
    void insert(DB_Entity_Stats stat);

//    @Insert
//    void insertAll(List<BabyName> babyNames);

    @Delete
    void Delete(DB_Entity_Stats stat);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void Update(DB_Entity_Stats stat);

}
