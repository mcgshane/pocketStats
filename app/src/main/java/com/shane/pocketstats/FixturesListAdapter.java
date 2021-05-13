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


public class FixturesListAdapter extends RecyclerView.Adapter<FixturesListAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private String[] sTitles;
    private String[] sContent;
    private List<DB_Entity_Fixtures> localFixturesList;

    FixturesListAdapter(Context context, List<DB_Entity_Fixtures> localFixturesList){
        this.inflater = LayoutInflater.from(context);
        this.localFixturesList = localFixturesList;
 //       this.sTitles = titles;
 //       this.sContent = contents;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.fixtures_recycler_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        DB_Entity_Fixtures entry = Objects.requireNonNull(localFixturesList.get(i));
        viewHolder.tvfixDate.setText(entry.getDate());
        viewHolder.tvfixVenue.setText(entry.getVenue());
        viewHolder.tvfixOpponent.setText(entry.getOpponent());
        viewHolder.tvfixTime.setText(entry.getTime());
 /*       String title = sTitles[i];
        String content = sContent[i];
        viewHolder.storyTitle.setText(title);
        viewHolder.storyContent.setText(content);
        viewHolder.number.setText(String.valueOf(title.charAt(0)));
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.OVAL);
        // generate random color

        Random r = new Random();
        int red = r.nextInt(255 - 0 + i);
        int green = r.nextInt(255 - i + 1);
        int blue = r.nextInt(255 - 0 + (i+1));
        shape.setColor(Color.rgb(red,green,blue));
        viewHolder.circle.setBackground(shape);
*/    }

    @Override
    public int getItemCount() {
        return localFixturesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvfixDate,tvfixVenue,tvfixTime,tvfixOpponent;
        CardView card_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // implement onClick
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
/*
                    Intent i = new Intent(v.getContext(), Details.class);
                    // send story title and contents through recyclerview to detail activity
                    i.putExtra("titleOfStory",sTitles[getAdapterPosition()]);
                    i.putExtra("contentOfStory",sContent[getAdapterPosition()]);
                    v.getContext().startActivity(i);
*/
                }
            });
/*
            storyTitle = itemView.findViewById(R.id.storyTitle);
            storyContent = itemView.findViewById(R.id.storyContent);
            number = itemView.findViewById(R.id.number);
*/
            tvfixDate = itemView.findViewById(R.id.fix_Date);
            tvfixVenue = itemView.findViewById(R.id.fix_Venue);
            tvfixTime = itemView.findViewById(R.id.fix_Time);
            tvfixOpponent = itemView.findViewById(R.id.fix_Opponent);
            card_view = itemView.findViewById(R.id.card_view);


        }
    }

}









/*
public class FixturesListAdapter extends RecyclerView.Adapter<FixturesListAdapter.FixturesViewHolder> {

    private final List<DB_Entity_Fixtures> localFixturesList;
    private final Context context;

    public FixturesListAdapter(List<DB_Entity_Fixtures> localFixturesList, Context context) {
        this.localFixturesList = localFixturesList;
        this.context = context;
    }

    @NonNull
    @Override
    public FixturesViewHolder onCreateFixturesViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fixtures_recycler_view, parent, false);

        return new FixturesViewHolder(view, contactClickListener);
    }

    @Override
    public void onBindFixturesViewHolder(@NonNull FixturesViewHolder holder, int position) {
        DB_Entity_Fixtures entry = Objects.requireNonNull(localFixturesList.get(position));
        holder.setFixDate(entry.getDate());
        holder.setFixVenue(entry.getVenue());
        holder.setFixOpponent(entry.getOpponent());
        holder.setFixTime(entry.getTime());


    }

    @Override
    public int getItemCount() {
        return Objects.requireNonNull(localFixturesList.size());
    }

    public interface OnContactClickListener {
        void onContactClick(int position);
    }

    public class FixturesViewHolder extends RecyclerView.FixturesViewHolder {
        public TextView tvfixDate;
        public TextView tvfixVenue;
        public TextView tvfixTime;
        public TextView tvfixOpponent;
 //       OnContactClickListener onContactClickListener;

        public FixturesViewHolder(View itemView) {
            super(itemView);
            tvfixDate = itemView.findViewById(R.id.fix_Date);
            tvfixVenue = itemView.findViewById(R.id.fix_Venue);
            tvfixTime = itemView.findViewById(R.id.fix_Time);
            tvfixOpponent = itemView.findViewById(R.id.fix_Opponent);

        }
*/
/*
        public FixturesViewHolder(@NonNull View itemView, OnContactClickListener onContactClickListener) {
            super(itemView);
            tvfixDate = itemView.findViewById(R.id.fix_Date);
            tvfixVenue = itemView.findViewById(R.id.fix_Venue);
            tvfixTime = itemView.findViewById(R.id.fix_Time);
            tvfixOpponent = itemView.findViewById(R.id.fix_Opponent);
            this.onContactClickListener = onContactClickListener;
            itemView.setOnClickListener(this);

        }
*//*

*/
/*

        @Override
        public void onClick(View view) {
            onContactClickListener.onContactClick(getAdapterPosition());
        }
*//*

    }
}
*/
