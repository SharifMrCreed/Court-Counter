package com.example.android.courtcounter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.MatchesViewHolder> {

    private ArrayList<Match> matches;
    private Context context;

    public MatchesAdapter(ArrayList<Match> matches, Context context) {
        this.matches = matches;
        this.context = context;
    }

    @NonNull
    @Override
    public MatchesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_matches_list, parent,false);
        return new MatchesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchesViewHolder holder, int position) {
        Match match = matches.get(position);
        holder.Bind(match);
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }



    class MatchesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView teamAName;
        TextView teamBName;
        TextView teamAScore;
        TextView teamBScore;


        public MatchesViewHolder(@NonNull View itemView) {
            super(itemView);
            teamAName = itemView.findViewById(R.id.rvteamAName);
            teamBName = itemView.findViewById(R.id.rvTeamBName);
            teamAScore = itemView.findViewById(R.id.rvTeamAscore);
            teamBScore = itemView.findViewById(R.id.rvTeamBscore);
            itemView.setOnClickListener(this);
        }
        public void Bind(Match match){
            teamAName.setText(match.getTeamAName());
            teamBName.setText(match.getTeamBName());
            teamAScore.setText(match.getTeamAScore());
            teamBScore.setText(match.getTeamBScore());
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Match match = matches.get(position);
            Intent intent = new Intent(view.getContext(), MatchDetailsActivity.class);
            intent.putExtra("Match", match);
            view.getContext().startActivity(intent);
        }
    }
}
