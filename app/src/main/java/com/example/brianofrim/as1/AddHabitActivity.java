package com.example.brianofrim.as1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class AddHabitActivity extends AppCompatActivity {

    private ArrayList<Day> daysOfTheWeek = new ArrayList<Day>();
    private ListView daysListView;
    private DayAdapter dayAdapter;
//    DialogFragment newFragment;

    int startYear;
    int startMonth;
    int startDay;
    String dateStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);
        daysListView = (ListView) findViewById(R.id.daysOfWeekListView);

        this.daysOfTheWeek.add(new Day("Sunday", false));
        this.daysOfTheWeek.add(new Day("Monday", false));
        this.daysOfTheWeek.add(new Day("Tuesday", false));
        this.daysOfTheWeek.add(new Day("Wednesday", false));
        this.daysOfTheWeek.add(new Day("Thursday", false));
        this.daysOfTheWeek.add(new Day("Friday", false));
        this.daysOfTheWeek.add(new Day("Saturday", false));

        this.dayAdapter = new DayAdapter(this.daysOfTheWeek,this);

        daysListView.setAdapter(this.dayAdapter);

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

    public void submitHabit(){

    }
}


