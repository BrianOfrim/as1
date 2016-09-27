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
    private HabitList habitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_list_habits);
        habitList = HabitListController.getHabitList();
//        daysListView = (ListView) findViewById(R.id.daysOfWeekListView);
//

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
