package com.shane.pocketstats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;


public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private String[] sTitles;
    private String[] sContent;
    private List<DB_Entity_Training> trainings;

    TrainingAdapter(Context context, List<DB_Entity_Training> trainings){
        this.inflater = LayoutInflater.from(context);
        this.trainings = trainings;
 //       this.sTitles = titles;
 //       this.sContent = contents;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.training_recycler_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        DB_Entity_Training entry = Objects.requireNonNull(trainings.get(i));
        viewHolder.tvUrls.setText(entry.getUrls());
        viewHolder.tvType.setText(entry.getType());
    }

    @Override
    public int getItemCount() {
        return trainings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvUrls,tvType;
        CardView card_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // implement onClick
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            tvUrls = itemView.findViewById(R.id.train_Urls);
            tvType = itemView.findViewById(R.id.train_Type);
            card_view = itemView.findViewById(R.id.card_view);


        }
    }

}



