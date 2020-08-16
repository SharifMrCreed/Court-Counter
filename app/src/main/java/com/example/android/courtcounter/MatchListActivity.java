package com.example.android.courtcounter;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class MatchListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<Match> matches = dummyMatches();
        Match match = getIntent().getParcelableExtra("Match");
        if (match != null){
            matches.add(match);
        }
        RecyclerView nRecyclerView = findViewById(R.id.rvTeamList);
        nRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        nRecyclerView.setAdapter(new MatchesAdapter(matches, this));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MatchListActivity.this, SetTeamNames.class);
                startActivity(intent);
            }
        });
    }

    private ArrayList<Match> dummyMatches(){
        ArrayList<Match> matches = new ArrayList<>();
        Random random = new Random();

        for(int i =1; i <= 15; i++){

            String display3;
            String display4;
            String display;
            String display2;
            int num1 = random.nextInt(10)+1;
            int num2 = random.nextInt(10)+1;
            int Score1 = random.nextInt(100)+25;
            int Score2 = random.nextInt(100)+25;

            if (num1 == num2){
                num2 = random.nextInt(10)+1;
            }
            display3 =  String.valueOf(Score1);
            display4 = String.valueOf(Score2);
            display = "Team " + num1;
            display2 = "Team " + num2;

            Match match = new Match(display, display2, display3, display4);
            matches.add(match);
        }
        return matches;
    }

}