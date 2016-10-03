package com.example.brianofrim.as1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class AddHabitActivity extends AppCompatActivity {

    int startYear;
    int startMonth;
    int startDay;
    String dateStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);

        Date d = new Date();
        startYear = 1900 + d.getYear();
        startMonth = d.getMonth();
        startDay = d.getDate();
        TextView dateTextView = (TextView)findViewById(R.id.selectedDateText);
        dateTextView.setText("Start: " + startDay +"/"+ (startMonth + 1) +"/" + startYear);
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_habits_menu, menu);
        return true;
    }

    public void goToToday(MenuItem menu) {
        Toast.makeText(this,"Today", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AddHabitActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void goToViewHabits(MenuItem menu) {
        Toast.makeText(this,"ViewHabits", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AddHabitActivity.this,ListHabitsActivity.class);
        startActivity(intent);
    }


    public void submitHabitToList(View v){
        // get properties required to create a habit
        Date dt = new Date();
        dt.setYear(startYear);
        dt.setMonth(startMonth);
        dt.setDate(startDay);
        dt.setHours(0);
        dt.setMinutes(0);
        dt.setSeconds(0);

        EditText nameEditText = (EditText) findViewById(R.id.habitNameEdit);

        boolean activeDays[] = {false,false,false,false,false,false,false};

        Switch sunday_s = (Switch) findViewById(R.id.sunday_switch);
        activeDays[0] = sunday_s.isChecked();
        Switch monday_s = (Switch) findViewById(R.id.monday_switch);
        activeDays[1] = monday_s.isChecked();
        Switch tuesday_s = (Switch) findViewById(R.id.tuesday_switch);
        activeDays[2] = tuesday_s.isChecked();
        Switch wednesday_s = (Switch) findViewById(R.id.wednesday_switch);
        activeDays[3] = wednesday_s.isChecked();
        Switch thurdays_s = (Switch) findViewById(R.id.thursday_switch);
        activeDays[4] = thurdays_s.isChecked();
        Switch friday_s = (Switch) findViewById(R.id.friday_switch);
        activeDays[5] = friday_s.isChecked();
        Switch saturday_s = (Switch) findViewById(R.id.saturday_switch);
        activeDays[6] = saturday_s.isChecked();


        HabitListController habitListController = new HabitListController();
        HabitList habitList = HabitListController.getHabitList();
        habitList.addHabit(nameEditText.getText().toString(),activeDays ,dt.getTime());

        Toast.makeText(this,"Add Habit", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AddHabitActivity.this,ListHabitsActivity.class);
        startActivity(intent);

    }

    public void showDatePickerDialog(View v) {
        DatePickerDialog dialog = new DatePickerDialog(AddHabitActivity.this,
                new mDateSetListener(), startYear, startMonth, startDay);
        dialog.show();
    }

    class mDateSetListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            // getCalender();
            startYear = year;
            startMonth = monthOfYear;
            startDay = dayOfMonth;
            System.out.println(startYear);
            TextView dateTextView = (TextView)findViewById(R.id.selectedDateText);
            dateTextView.setText("Start: " + startDay +"/"+ (startMonth + 1) +"/" + startYear);
        }
    }


}


