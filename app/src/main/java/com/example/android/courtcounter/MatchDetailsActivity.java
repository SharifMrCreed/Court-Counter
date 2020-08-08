package com.example.android.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MatchDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_details_layout);
        Match match = getIntent().getParcelableExtra("Match");
        TextView tvAName = findViewById(R.id.tvAName);
        TextView tvBName = findViewById(R.id.tvBName);
        TextView tvAScore = findViewById(R.id.tvAScore);
        TextView tvBScore = findViewById(R.id.tvBScore);
        assert match != null;
        tvAName.setText(match.getTeamAName());
        tvAScore.setText(match.getTeamAScore());
        tvBScore.setText(match.getTeamBScore());
        tvBName.setText(match.getTeamBName());

    }

    public void addComment(View view) {

        TextView comment1 = findViewById(R.id.mlComments);
        if(comment1.getText()!= null){
            // we need to store these comments in due time
            String comments = comment1.getText().toString();
            Toast.makeText(view.getContext(),"Comment Saved", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(view.getContext(),"Please Type Something in the comments Field", Toast.LENGTH_LONG).show();
        }
    }
}