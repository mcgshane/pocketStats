package com.shane.pocketstats;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Training_DAO {
    @Query("SELECT id, Urls , Type FROM Training")
    List<DB_Entity_Training> getAll();

    /*  Query("SELECT * FROM Fixtures WHERE date IN (:userIds)")
      List<Fixtures_DAO> loadAllByIds(int[] userIds);

      @Query("SELECT * FROM fixtures WHERE venue LIKE :first AND " +
              "time LIKE :last LIMIT 1")
      Fixtures_DAO findByName(String first, String last);
  */
    @Insert
    void insertEntry(DB_Entity_Training... entry);

    @Delete
    void deleteEntry(DB_Entity_Training entry);

    //Fixtures_DAO Fixtures_DAO = Room_DB.Fixtures_DAO();
    //List<Fixtures_DAO> Fixtures_DAO = Fixtures_DAO.getAll();
}
