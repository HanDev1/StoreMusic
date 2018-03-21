package com.example.a2hanj43.storemusic;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

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




    public long insertRecord(String Title, String Artist, Integer Year)
    {
        SQLiteDatabase db = getWritableDatabase();
        SQLiteStatement stmt = db.compileStatement
                ("INSERT INTO Music (Title,Artist,Year) VALUES (?, ?, ?)");
        stmt.bindString (1, "Let it be");
        stmt.bindString (2, "Beatles");
        stmt.bindLong (3, 1970);
        long id = stmt.executeInsert();
        return id;
    }


    }







