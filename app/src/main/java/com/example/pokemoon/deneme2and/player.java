package com.example.pokemoon.deneme2and;

import android.database.Cursor;
import android.media.Image;

import java.util.ArrayList;

public class player
{

    private  String name;
    private int id;


    public player(String name, int id)
    { this.name=name;
    this.id=id;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static ArrayList<player> cursorToArray (Cursor input) {
        ArrayList<player> arrayList = new ArrayList<>();
        while(input.moveToNext()){
            arrayList.add(new player(input.getString(1), input.getInt(0)));
        }
        return arrayList;

    }
}
