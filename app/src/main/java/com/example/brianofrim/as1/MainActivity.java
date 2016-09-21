package com.example.brianofrim.as1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public void viewHabit(MenuItem menu) {
        Toast.makeText(this,"Habits", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,ListHabitsActivity.class);
        startActivity(intent);
    }

    public void addHabit(MenuItem menu) {
        Toast.makeText(this,"Add Habit", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,AddHabitActivity.class);
        startActivity(intent);
    }


}

