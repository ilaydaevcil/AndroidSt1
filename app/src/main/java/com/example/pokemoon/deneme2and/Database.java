package com.example.pokemoon.deneme2and;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "sqllite_database";//database adı

    private static final String TABLE_NAME = "kisilistesi";
    private static String KISI_ADI = "kitap_adi";
    private static String KISI_ID = "id";

    public Database(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KISI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KISI_ADI + " TEXT"+ ")";

        sqLiteDatabase.execSQL(CREATE_TABLE);
    }
    public void KisiEkle(String kisi_adi) {
        //kitapEkle methodu ise adı üstünde Databese veri eklemek için
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KISI_ADI, kisi_adi);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public void Kisisil(int id){

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KISI_ID + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }

    public Cursor Listele()
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor data =  sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME , null);
        return data;

    }
    public int getLastId() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data =  db.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY ID DESC LIMIT 1 ", null);
        data.moveToNext();
        return data.getInt(0);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
