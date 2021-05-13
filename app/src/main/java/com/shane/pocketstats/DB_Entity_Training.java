package com.shane.pocketstats;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Training")
public class DB_Entity_Training {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Urls")
    private String urls;

    @ColumnInfo(name = "Type")
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
