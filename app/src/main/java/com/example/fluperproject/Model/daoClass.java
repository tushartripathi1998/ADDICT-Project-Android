package com.example.fluperproject.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface daoClass {

    @Query("SELECT * FROM mymodel ORDER BY value")
    public LiveData<List<MyModel>> getAllData();

    @Query("SELECT * FROM mymodel WHERE value=:value")
    public LiveData<MyModel> getData(String value);

    @Insert(onConflict = REPLACE)
    public void insert(MyModel myModel);

    @Update
    public void update(MyModel myModel);

}
