package com.example.arnavjha.staggeredview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyOwnHolder> {
    OnLayoutListner mListner;
    ArrayList s1;




    public Adapter(ArrayList name , OnLayoutListner onLayoutListner){
        mListner = onLayoutListner;
        s1 = name;

    }
    public Adapter.MyOwnHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater myInflater = LayoutInflater.from(viewGroup.getContext());
        View myView = myInflater.inflate(R.layout.items,viewGroup,false);
        return new MyOwnHolder(myView,mListner);
    }



    @Override
    public void onBindViewHolder (@NonNull Adapter.MyOwnHolder myOwnHolder, int i) {
         myOwnHolder.t1.setText((String)s1.get(i));
    }

    @Override
    public int getItemCount() {
        return s1.size();
    }

    public class MyOwnHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
         TextView t1;
         public CardView card1;
         OnLayoutListner onLayoutListner;
        public MyOwnHolder(@NonNull View itemView , OnLayoutListner onLayoutListner) {
            super(itemView);
            t1 = (TextView)itemView.findViewById(R.id.text);
            card1 = (CardView)itemView.findViewById(R.id.card);
            this.onLayoutListner = onLayoutListner;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
           onLayoutListner.onLayoutClick(getAdapterPosition());
        }
    }

    public interface OnLayoutListner{
        void onLayoutClick(int position);
    }
}
