// inspired by lonelyTwitter
//https://github.com/joshua2ua/lonelyTwitter

package com.example.brianofrim.as1;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListHabitsActivity extends AppCompatActivity{

//    private ArrayList<Day> daysOfTheWeek = new ArrayList<Day>();
//    private ListView daysListView;
//    private DayAdapter dayAdapter;
    private HabitList habitList;
    private ListView habitsListView;
    private ArrayAdapter<Habit> habitAdapter;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.view_habits_menu, menu);
        return true;
    }

    public void goToToday(MenuItem menu) {
        Toast.makeText(this,"Today", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ListHabitsActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void goToAddHabit(MenuItem menu) {
        Toast.makeText(this,"Add", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(ListHabitsActivity.this,AddHabitActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_list_habits);
        habitList = HabitListController.getHabitList();
        habitsListView = (ListView) findViewById(R.id.habits_listView) ;
        habitAdapter = new HabitListAdapter(this, habitList.getHabits());

        habitsListView.setAdapter(habitAdapter);
//
        // listener from: https://stackoverflow.com/questions/17851687/how-to-handle-the-click-event-in-listview-in-android
        habitsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
            Intent intent = new Intent(ListHabitsActivity.this,HabitDetailActivity.class);
            intent.putExtra("index",position);
            startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        // upadate data
        habitList = HabitListController.getHabitList();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
