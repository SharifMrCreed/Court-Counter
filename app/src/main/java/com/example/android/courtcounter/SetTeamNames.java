package com.example.android.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class SetTeamNames extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_team_names);
    }

    public void setTeamNames(View view) {
        EditText etTeamAName = findViewById(R.id.etTeamAName);
        EditText etTeamBName = findViewById(R.id.etTeamBName);
        String TeamAName = etTeamAName.getText().toString();
        String TeamBName = etTeamBName.getText().toString();
        if (TeamAName.equals("")) {
            TeamAName = "Team A";
        }
        if (TeamBName.equals("")) {
            TeamBName = "Team B";
        }
        ArrayList<String> names = new ArrayList<>();
        names.add(TeamAName);
        names.add(TeamBName);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putStringArrayListExtra("names", names);
        startActivity(intent);
        finish();

    }
}