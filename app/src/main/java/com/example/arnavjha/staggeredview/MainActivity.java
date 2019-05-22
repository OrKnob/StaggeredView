package com.example.arnavjha.staggeredview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements Adapter.OnLayoutListner {
    RecyclerView r1;
    ArrayList name = new ArrayList<>(Arrays.asList("Grid Layout","Linear Layout","Relative Layout","Constraint Layout","Grid Layout","Linear Layout","Relative Layout","Constraint Layout"));
    Adapter ad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1 = (RecyclerView)findViewById(R.id.recycle);


        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        r1.setLayoutManager(staggeredGridLayoutManager);

        ad = new Adapter(name,this);
        r1.setAdapter(ad);



    }

    @Override
    public void onLayoutClick(int position) {
        String y = ((String) name.get(position));
        if (y == "Relative Layout"){
            Intent i1 = new Intent(this,relative.class);
            startActivity(i1);
        }
        else if (y == "Constraint Layout"){
            Intent i2 = new Intent(this,Constraint.class);
            startActivity(i2);
        }
        if (y == "Linear Layout"){
            Intent i3 = new Intent(this,Linear.class);
            startActivity(i3);
        }
        if (y == "Grid Layout"){
            Intent i4 = new Intent(this,Grid.class);
            startActivity(i4);
        }


    }
}
