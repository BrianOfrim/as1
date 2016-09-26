package com.example.brianofrim.as1;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListHabitsActivity extends AppCompatActivity{

//    private ArrayList<Day> daysOfTheWeek = new ArrayList<Day>();
//    private ListView daysListView;
//    private DayAdapter dayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_habits);
//        daysListView = (ListView) findViewById(R.id.daysOfWeekListView);
//
//        this.daysOfTheWeek.add(new Day("Sunday", false));
//        this.daysOfTheWeek.add(new Day("Monday", false));
//        this.daysOfTheWeek.add(new Day("Tuesday", false));
//        this.daysOfTheWeek.add(new Day("Wednesday", false));
//        this.daysOfTheWeek.add(new Day("Thursday", false));
//        this.daysOfTheWeek.add(new Day("Friday", false));
//        this.daysOfTheWeek.add(new Day("Saturday", false));
//
//        this.dayAdapter = new DayAdapter(this.daysOfTheWeek,this);
//
//        daysListView.setAdapter(this.dayAdapter);
        //setContentView(R.layout.activity_list_habits);
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
//        DOWadapter = new ArrayAdapter<Day>(this,
//                R.layout.activity_list_habits, this.daysOfTheWeek);
//        daysListView.setAdapter(DOWadapter);
    }

}
