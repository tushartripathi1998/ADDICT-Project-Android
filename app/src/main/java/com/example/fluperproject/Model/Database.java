package com.example.fluperproject.Model;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {MyModel.class}, version = 1)
public abstract class Database extends RoomDatabase {
    private static Database mInstance;

    public static Database getInstance(Context context)
    {
        if(mInstance == null)
        {
            mInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    Database.class,
                    "mymodel"
                    ).build();
        }
        return mInstance;
    }

    public abstract daoClass getDao();
}
