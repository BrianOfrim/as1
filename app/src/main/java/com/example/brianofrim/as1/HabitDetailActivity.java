package com.example.brianofrim.as1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

/*
 * The activity where the details of a particular habit are shown
 * details include: habit title, number of times habit was completed, a list of
 * all completed habits and the times that they were completed. The user can
 * also delete completions
 */

public class HabitDetailActivity extends AppCompatActivity {
    Habit habit;
    private ArrayList<Long> completions;
    private ListView completionListView;
    private ArrayAdapter<Long> completionAdapter;
    private int listIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_detail);

        Intent intent = getIntent();
        listIndex = intent.getIntExtra("index",0);
        habit = HabitListController.getHabitAt(listIndex);
        completions = habit.getHabitCompletions();

        TextView habit_title = (TextView) findViewById(R.id.habit_detail_title);
        habit_title.setText(habit.getTitle());

        TextView number_of_completions = (TextView) findViewById(R.id.number_of_completions_number);
        Integer numOfCompletions = habit.getTimesCompleted();
        number_of_completions.setText(numOfCompletions.toString());

        completionListView = (ListView) findViewById(R.id.completions_listview);
        completionAdapter = new CompletionsAdapter(this, habit.getHabitCompletions());
        completionListView.setAdapter(completionAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        completions = habit.getHabitCompletions();
    }

    public void numCompletionsUpdate(){
        TextView number_of_completions = (TextView) findViewById(R.id.number_of_completions_number);
        Integer numOfCompletions = habit.getTimesCompleted();
        number_of_completions.setText(numOfCompletions.toString());
    }
}

