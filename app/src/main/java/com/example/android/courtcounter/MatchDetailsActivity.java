package com.example.android.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.courtcounter.utils.ScoreContract;
import com.example.android.courtcounter.utils.ScoreTableHelper;

public class MatchDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_details_layout);

        TextView tvAName = findViewById(R.id.tvAName);
        TextView tvBName = findViewById(R.id.tvBName);
        TextView tvAScore = findViewById(R.id.tvAScore);
        TextView tvBScore = findViewById(R.id.tvBScore);

        Match match = getIntent().getParcelableExtra("Match");
        assert match != null;
        tvAName.setText(match.getTeamAName());
        tvAScore.setText(match.getTeamAScore());
        tvBScore.setText(match.getTeamBScore());
        tvBName.setText(match.getTeamBName());

        displayDatabaseInfo();

    }

    private void displayDatabaseInfo() {

        ScoreTableHelper mDbHelper = new ScoreTableHelper(this);

        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + ScoreContract.ScoreTable.TABLE_NAME, null);
        try {
            TextView displayView = (TextView) findViewById(R.id.text_view_pet);
            displayView.setText("Number of rows in pets database table: " + cursor.getCount());
            Log.d ("Row number", displayView.getText().toString() );
        } finally {
            cursor.close();
        }
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