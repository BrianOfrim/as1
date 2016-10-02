package com.example.brianofrim.as1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HabitDetailActivity extends AppCompatActivity {
    Habit habit;
    private ArrayList<Long> completions;
    private ListView completionListView;
    private ArrayAdapter<Long> completionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_detail);
        Intent intent = getIntent();
        Integer habitIndex = intent.getIntExtra("index",0);
        habit = HabitListController.getHabitAt(habitIndex);
        completions = habit.getHabitCompletions();
        TextView habit_title = (TextView) findViewById(R.id.habit_detail_title);
        habit_title.setText(habit.getTitle());
        TextView number_of_completions = (TextView) findViewById(R.id.number_of_completions_number);
        Integer numOfCompletions = habit.getTimesCompleted();
        //number_of_completions.setText(numOfCompletions);

        completionListView = (ListView) findViewById(R.id.completions_listview);
        completionAdapter = new CompletionsAdapter(this, habit.getHabitCompletions());
        completionListView.setAdapter(completionAdapter);
    }
}

