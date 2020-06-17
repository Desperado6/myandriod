package com.example.enterandregist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper
{
    public static final String CREATE_BOOK = "create table Info(" +
            "id integer primary key autoincrement," +
            "username,"    +
            "password,"    +
            "balance,"     +
            "point,"       +
            "butterfly,"   +
            "ak47,"        +
            "clawknife,"   +
            "awp,"         +
            "m4a1,"        +
            "m4a4,"        +
            "m9,"          +
            "blueglove,"   +
            "purpleglove," +
            "gunbox,"      +
            "deserteagle," +
            "defender)";

    private Context mContext;
    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
