package com.example.android.courtcounter.db;

import android.provider.BaseColumns;

public final class ScoreContract {
    private ScoreContract() {}

    public static final class ScoreTable implements BaseColumns{

        public static final String TABLE_NAME = "scores";
        public static final String ID = BaseColumns._ID;
        public static final String A_NAME = "aname";
        public static final String B_NAME = "bname";
        public static final String A_SCORE = "ascore";
        public static final String B_SCORE = "bscore";
    }

}
