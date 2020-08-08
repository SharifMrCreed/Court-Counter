package com.example.android.courtcounter;

import android.os.Parcel;
import android.os.Parcelable;

public class Match implements Parcelable {

    String teamAName;
    String teamBName;
    String teamAScore;
    String teamBScore;

    public Match(String teamAName, String teamBName, String teamAScore, String teamBScore) {
        this.teamAName = teamAName;
        this.teamBName = teamBName;
        this.teamAScore = teamAScore;
        this.teamBScore = teamBScore;
    }

    protected Match(Parcel in) {
        teamAName = in.readString();
        teamBName = in.readString();
        teamAScore = in.readString();
        teamBScore = in.readString();
    }

    public static final Creator<Match> CREATOR = new Creator<Match>() {
        @Override
        public Match createFromParcel(Parcel in) {
            return new Match(in);
        }

        @Override
        public Match[] newArray(int size) {
            return new Match[size];
        }
    };

    public void setTeamAName(String teamAName) {
        this.teamAName = teamAName;
    }

    public void setTeamBName(String teamBName) {
        this.teamBName = teamBName;
    }

    public void setTeamAScore(String teamAScore) {
        this.teamAScore = teamAScore;
    }

    public void setTeamBScore(String teamBScore) {
        this.teamBScore = teamBScore;
    }

    public String getTeamAName() {
        return teamAName;
    }

    public String getTeamBName() {
        return teamBName;
    }

    public String getTeamAScore() {
        return teamAScore;
    }

    public String getTeamBScore() {
        return teamBScore;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(teamAName);
        parcel.writeString(teamBName);
        parcel.writeString(teamAScore);
        parcel.writeString(teamBScore);
    }
}
