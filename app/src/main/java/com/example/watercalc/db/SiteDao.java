package com.example.watercalc.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SiteDao {
    @Query("SELECT * FROM Site")
   List<Site> getAll();

    @Query("SELECT * FROM Site WHERE mId=:id")
    Site getById(long id);

    @Query("SELECT * FROM Site WHERE name_of_area=:name")
    Site getByName(String name);


    @Insert
    void insert(Site site);


}
