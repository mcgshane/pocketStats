package com.shane.pocketstats;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Fixtures_DAO {
    @Query("SELECT date,venue,opponent,time FROM Fixtures")
    List<DB_Entity_Fixtures> getAll();

  /*  Query("SELECT * FROM Fixtures WHERE date IN (:userIds)")
    List<Fixtures_DAO> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM fixtures WHERE venue LIKE :first AND " +
            "time LIKE :last LIMIT 1")
    Fixtures_DAO findByName(String first, String last);
*/
    @Insert
    void insertEntry(DB_Entity_Fixtures... entry);

    @Delete
    void deleteEntry(DB_Entity_Fixtures entry);

    //Fixtures_DAO Fixtures_DAO = Room_DB.Fixtures_DAO();
    //List<Fixtures_DAO> Fixtures_DAO = Fixtures_DAO.getAll();
}
