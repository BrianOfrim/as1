package com.example.brianofrim.as1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class AddHabitActivity extends AppCompatActivity {

//    private ArrayList<Day> daysOfTheWeek = new ArrayList<Day>();
//    private ListView daysListView;
//    private DayAdapter dayAdapter;
//    DialogFragment newFragment;

    int startYear;
    int startMonth;
    int startDay;
    String dateStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);
//        daysListView = (ListView) findViewById(R.id.daysOfWeekListView);

//        this.daysOfTheWeek.add(new Day("Sunday", false));
//        this.daysOfTheWeek.add(new Day("Monday", false));
//        this.daysOfTheWeek.add(new Day("Tuesday", false));
//        this.daysOfTheWeek.add(new Day("Wednesday", false));
//        this.daysOfTheWeek.add(new Day("Thursday", false));
//        this.daysOfTheWeek.add(new Day("Friday", false));
//        this.daysOfTheWeek.add(new Day("Saturday", false));

//        this.dayAdapter = new DayAdapter(this.daysOfTheWeek,this);
//
//        daysListView.setAdapter(this.dayAdapter);

        Date d = new Date();
        startYear = 1900 + d.getYear();
        startMonth = d.getMonth();
        startDay = d.getDate();
        TextView dateTextView = (TextView)findViewById(R.id.selectedDateText);
        dateTextView.setText("Start: " + startDay +"/"+ (startMonth + 1) +"/" + startYear);
//        newFragment = new DatePickerFragment();
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

    public void showDatePickerDialog(View v) {
        DatePickerDialog dialog = new DatePickerDialog(AddHabitActivity.this,
                new mDateSetListener(), startYear, startMonth, startDay);
        dialog.show();
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

        TextView nameTextView = (TextView)findViewById(R.id.habitNameText);

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
        habitList.addHabit(nameTextView.getText().toString(),activeDays ,dt.getTime());

        Toast.makeText(this,"Add Habit", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AddHabitActivity.this,ListHabitsActivity.class);
        startActivity(intent);

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


