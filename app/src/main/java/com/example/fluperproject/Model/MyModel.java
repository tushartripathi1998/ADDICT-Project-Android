package com.example.fluperproject.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mymodel")
public class MyModel {

    @PrimaryKey
    @NonNull
    private String value;
    private int count;
    private int total;

    public MyModel(String value, int count, int total) {
        this.value = value;
        this.count = count;
        this.total = total;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
