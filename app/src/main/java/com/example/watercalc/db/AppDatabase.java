package com.example.watercalc.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Site.class}, version = 1)
public abstract class AppDatabase extends   RoomDatabase {
    public abstract SiteDao siteDao();
}