package com.example.android.courtcounter.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ScoreTableHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MatchScoreDatabase";
    public static final int DATABASE_VERSION = 1;


    public ScoreTableHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_TABLE_CREATE_COMMAND = "CREATE TABLE "+ ScoreContract.ScoreTable.TABLE_NAME +
                "( " + ScoreContract.ScoreTable.ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ScoreContract.ScoreTable.A_NAME + " TEXT, " +
                ScoreContract.ScoreTable.B_NAME + " TEXT, " +
                ScoreContract.ScoreTable.A_SCORE + " INTEGER, " +
                ScoreContract.ScoreTable.B_SCORE + " INTEGER); ";
        sqLiteDatabase.execSQL(SQL_TABLE_CREATE_COMMAND);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
