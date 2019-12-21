package com.example.fluperproject;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.fluperproject.Model.Database;
import com.example.fluperproject.Model.MyModel;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    public Database db;

    private LiveData<List<MyModel>> allData;

    public ViewModel(@NonNull Application application) {
        super(application);
        db = Database.getInstance(this.getApplication());
        allData = db.getDao().getAllData();
    }

    public LiveData<List<MyModel>> getAllData()
    {
        return allData;
    }

    public LiveData<MyModel> getData(String value)
    {
        return db.getDao().getData(value);
    }

    public void insertData(MyModel myModel)
    {
        db.getDao().insert(myModel);
    }
    public void update(MyModel myModel)
    {
        db.getDao().update(myModel);
    }
}
