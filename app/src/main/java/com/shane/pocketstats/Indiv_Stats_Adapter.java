package com.shane.pocketstats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;


public class Indiv_Stats_Adapter extends RecyclerView.Adapter<Indiv_Stats_Adapter.ViewHolder> {

    private LayoutInflater inflater;
    private String[] sTitles;
    private String[] sContent;
    private List<DB_Entity_Stats> indivStats;

    public Indiv_Stats_Adapter(Context context, List<DB_Entity_Stats> indivStats){
        this.inflater = LayoutInflater.from(context);
        this.indivStats = indivStats;
 //       this.sTitles = titles;
 //       this.sContent = contents;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.stats_recycler_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        DB_Entity_Stats entry = Objects.requireNonNull(indivStats.get(i));
        int Fgoalsmade = entry.getThreeptmade() + entry.getTwoptmade();
        int Fgoalsattempted = entry.getThreeptattempted() + entry.getTwoptattempted();
        int Ftmade = entry.getFtmade();
        int Ftattempted = entry.getFtattempted();

        int Steals = entry.getSteals();
        int Blocks = entry.getBlocks();
        int Turnovers = entry.getTurnovers();
        int Assist = entry.getAssist();

        int OffRebound = entry.getOffrebound();
        int DefRebound = entry.getDefrebound();
        int totRebound = entry.getOffrebound() + entry.getDefrebound();

        viewHolder.Fgoals.setText(String.valueOf(Fgoalsmade) + "/" + String.valueOf(Fgoalsattempted));
        viewHolder.ThreePts.setText(entry.getThreeptmade() + "/" + entry.getThreeptattempted() );
        viewHolder.TwoPts.setText(entry.getTwoptmade() + "/" + entry.getTwoptattempted());
        viewHolder.Fts.setText(entry.getFtmade() + "/" + entry.getFtattempted());

        viewHolder.Steals.setText(entry.getSteals());
        viewHolder.Block.setText(entry.getBlocks());
        viewHolder.Turnover.setText(entry.getTurnovers());
        viewHolder.Assist.setText(entry.getAssist());

        viewHolder.Rebounds.setText(entry.getOffrebound() + "/" + entry.getDefrebound());
        viewHolder.OffRebounds.setText(entry.getOffrebound());
        viewHolder.DefRebounds.setText(entry.getDefrebound());

    }

    @Override
    public int getItemCount() {
        return indivStats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView Fgoals, ThreePts, TwoPts, Fts, Steals, Block, Turnover, Assist, Rebounds , OffRebounds, DefRebounds;
        CardView card_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // implement onClick
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            Fgoals = itemView.findViewById(R.id.fieldGoals);
            ThreePts = itemView.findViewById(R.id.threePts);
            TwoPts = itemView.findViewById(R.id.twoPts);
            Fts = itemView.findViewById(R.id.freeT);

            Steals = itemView.findViewById(R.id.steal);
            Block = itemView.findViewById(R.id.block);
            Turnover = itemView.findViewById(R.id.turnO);
            Assist = itemView.findViewById(R.id.assist);

            Rebounds = itemView.findViewById(R.id.totR);
            OffRebounds = itemView.findViewById(R.id.offR);
            DefRebounds = itemView.findViewById(R.id.defR);

            card_view = itemView.findViewById(R.id.card_view);

        }
    }

}

