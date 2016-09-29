package com.example.brianofrim.as1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Habit> todayHabits;
    private ListView todayHabitsListView;
    private ArrayAdapter<Habit> todayHabitAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar todayCal = Calendar.getInstance();
        todayHabits = HabitListController.getTodaysHabits(todayCal.get(Calendar.DAY_OF_WEEK));
        todayHabitsListView = (ListView) findViewById(R.id.todayHabitList);

        todayHabitAdapter = new TodayListAdapter(this, todayHabits);

        todayHabitsListView.setAdapter(todayHabitAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public void goToViewHabits(MenuItem menu) {
        Toast.makeText(this,"Habits", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,ListHabitsActivity.class);
        startActivity(intent);
    }

    public void goToAddHabit(MenuItem menu) {
        Toast.makeText(this,"Add Habit", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,AddHabitActivity.class);
        startActivity(intent);
    }


}

