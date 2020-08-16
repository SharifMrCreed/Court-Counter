package com.example.android.courtcounter.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.android.courtcounter.Match;

import java.util.ArrayList;

public class RetrieveData {
    private static final String TAG = "DataBase";
    Context context;
    public RetrieveData(Context context) {
        this.context = context;
    }

    public ArrayList<Match> dbData() {
        ArrayList<Match> retrieved = new ArrayList<>();
        ScoreTableHelper nHelper = new ScoreTableHelper(context);
        SQLiteDatabase db = nHelper.getReadableDatabase();

        String[] projection = {
                ScoreContract.ScoreTable.ID,
                ScoreContract.ScoreTable.A_NAME,
                ScoreContract.ScoreTable.B_NAME,
                ScoreContract.ScoreTable.A_SCORE,
                ScoreContract.ScoreTable.B_SCORE
        };
        Cursor cursor = db.query(ScoreContract.ScoreTable.TABLE_NAME,
                projection, null, null, null, null, null);

        while (cursor.moveToNext()){
            int aNameIndex = cursor.getColumnIndex(ScoreContract.ScoreTable.A_NAME);
            int bNameIndex = cursor.getColumnIndex(ScoreContract.ScoreTable.B_NAME);
            int aScoreIndex = cursor.getColumnIndex(ScoreContract.ScoreTable.A_SCORE);
            int bScoreIndex = cursor.getColumnIndex(ScoreContract.ScoreTable.B_SCORE);
            String aName = cursor.getString(aNameIndex);
            String bName = cursor.getString(bNameIndex);
            String aScore = String.valueOf(cursor.getInt(aScoreIndex));
            String bScore = String.valueOf(cursor.getInt(bScoreIndex));
            Match match = new Match(aName, bName, aScore, bScore);
            retrieved.add(match);
        }
        cursor.close();
        Log.d(TAG, "the Database contains" + retrieved.toString());

        return retrieved;
    }
}
