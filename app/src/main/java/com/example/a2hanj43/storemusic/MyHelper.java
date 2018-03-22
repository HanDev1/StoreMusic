package com.example.a2hanj43.storemusic;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by 2hanj43 on 21/03/2018.
 */

public class MyHelper extends SQLiteOpenHelper {

    static final int VERSION = 1;
    static final String DATABASE_NAME = "TestDB";


    public MyHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

        db.execSQL ("CREATE TABLE IF NOT EXISTS Music (Id INTEGER PRIMARY KEY, Title VARCHAR(255), Artist VARCHAR(255), Year INTEGER)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL ("DROP TABLE IF EXISTS Music");
        onCreate(db);
    }
/*
    public ArrayList<Song> findSong()
    {
        String title = "song1";
        ArrayList<Song> music = new ArrayList<Song>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery ("SELECT * FROM Music WHERE Title=?",
                new String[] { title } );
        if (cursor.moveToFirst())
        {
            while(!cursor.isAfterLast())
            {
                Song s = new Song
                        (cursor.getString(cursor.getColumnIndex("Title")),
                                cursor.getString(cursor.getColumnIndex("Artist")),
                                cursor.getLong(cursor.getColumnIndex("Year")));
                music.add(s);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return music;
    }

*/



    public long insertRecord(String Title, String Artist, Long Year) //Long year
    {
        SQLiteDatabase db = getWritableDatabase();
        SQLiteStatement stmt = db.compileStatement
                ("INSERT INTO Music (Title,Artist,Year) VALUES (?, ?, ?)");
        stmt.bindString (1, Title);
        stmt.bindString (2, Artist);
        stmt.bindLong (3, Year); //bindLong
        long id = stmt.executeInsert();
        Log.d("sqlite","allocated id: " + id);
        return id;
    }



}







