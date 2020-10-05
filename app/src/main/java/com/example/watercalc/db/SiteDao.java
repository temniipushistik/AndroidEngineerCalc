package com.example.watercalc.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SiteDao {
    @Query("SELECT * FROM site")
    List<Site> getAll();

    @Query("DELETE FROM site")
    void deleteAll();

    @Query("SELECT * FROM site WHERE id=:id")
    Site getById(long id);

    @Query("SELECT * FROM Site WHERE nameOfArea=:name")
    Site getByName(String name);


    @Insert
    void insert(Site site);

    @Update
    void update(Site site);

    @Delete
    void delete(Site site);


}
