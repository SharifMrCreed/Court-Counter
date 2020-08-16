/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.courtcounter;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.courtcounter.db.ScoreContract;
import com.example.android.courtcounter.db.ScoreTableHelper;

import java.util.ArrayList;

/**
 * This activity keeps track of the basketball score for 2 teams.
 */
public class MainActivity extends AppCompatActivity {

    TextView teamAName;
    TextView teamBName;
    TextView teamAScore;
    TextView teamBScore;
    Button save;

    String aName;
    String bName;
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamAName = findViewById(R.id.tvteamAName);
        teamBName = findViewById(R.id.tvteamBName);
        teamAScore = findViewById(R.id.tvAscore);
        teamBScore = findViewById(R.id.tvBscore);
        save = findViewById(R.id.btnSave);

        ArrayList<String> names = getIntent().getStringArrayListExtra("names");
        assert names != null;
        aName = names.get(0);
        bName = names.get(1);
        teamAName.setText(aName);
        teamBName.setText(bName);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveScore();
            }
        });


    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        teamAScore.setText(String.valueOf(scoreTeamA));
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        teamAScore.setText(String.valueOf(scoreTeamA));
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        scoreTeamA = scoreTeamA + 3;
        teamAScore.setText(String.valueOf(scoreTeamA));
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        teamBScore.setText(String.valueOf(scoreTeamB));
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        teamBScore.setText(String.valueOf(scoreTeamB));
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        teamBScore.setText(String.valueOf(scoreTeamB));
    }

    public void saveScore() {
        Match match = new Match(aName, bName, String.valueOf(scoreTeamA), String.valueOf(scoreTeamB));

        ScoreTableHelper nHelper = new ScoreTableHelper(this);
        SQLiteDatabase db = nHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ScoreContract.ScoreTable.A_NAME, aName);
        values.put(ScoreContract.ScoreTable.B_NAME, bName);
        values.put(ScoreContract.ScoreTable.A_SCORE, scoreTeamA);
        values.put(ScoreContract.ScoreTable.B_SCORE, scoreTeamB);
        long returnedID = db.insert(ScoreContract.ScoreTable.TABLE_NAME, null,values);

        Toast.makeText(MainActivity.this,"Match Score Saved", Toast.LENGTH_LONG).show();
        Log.d("ROW ID ", String.valueOf(returnedID));

        Intent intent = new Intent(this, MatchListActivity.class);
        intent.putExtra("Match", match);
        startActivity(intent);

    }
}
