package com.example.watercalc.db;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.room.Room;

public class App extends Application {

    // объект текущего класса с глобальным доступом
    private static App instance;
    private String currentDBPath;

    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance() {
        if (instance == null)
            instance = new App();

        return instance;
    }

    public AppDatabase getDatabase(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    "database")
                    .build();
            currentDBPath = this.getDatabasePath("database.db").getAbsolutePath();
        }

        Log.d("AppDatabase", "Getting the database instance " + currentDBPath);

        return database;
    }
}
