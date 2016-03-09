package com.example.akoldas.mysixthapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AKOLDAS on 3/8/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "User.db" ;
    public static final String TABLE_NAME = "user_table" ;
    public static final String COL_1 = "ID" ;
    public static final String COL_2 = "USERNAME" ;
    public static final String COL_3 = "PASSWORD" ;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME TEXT,PASSWORD TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase() ;
        ContentValues contentValues = new ContentValues() ;
        contentValues.put(COL_2,username);
        contentValues.put(COL_3, password);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if ( result == -1)
            return false ;
        else
            return true ;


    }

    public boolean query (String username, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase() ;
        String sql = "SELECT * FROM user_table WHERE USERNAME = '" + username + "'" + " AND PASSWORD = '" + password + "'";
        Cursor data =  db.rawQuery(sql, null);

        if (data.moveToFirst()) {
                return true ;
        } else {
            return false ;
        }
    }


}
