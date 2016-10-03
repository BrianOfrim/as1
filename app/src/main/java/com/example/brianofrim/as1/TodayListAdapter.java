package com.example.brianofrim.as1;

/**
 * Created by brianofrim on 2016-09-28.
 */

// inspiration from https://stackoverflow.com/questions/17525886/listview-with-add-and-delete-buttons-in-each-row-in-android

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TodayListAdapter extends ArrayAdapter<Habit>{
    private ArrayList<Habit> habitsList;
    private Context currContext;
    public TodayListAdapter(Context context, ArrayList<Habit> habits){
        super(context, 0, habits);
        habitsList = habits;
        currContext = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position



        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.today_habit_list_item, parent, false);
        }

        Habit habit = getItem(position);

        if(habit.completedToday()){
            convertView.setBackgroundColor(ContextCompat.getColor(currContext, R.color.lightGreen));
        }else{
            convertView.setBackgroundColor(ContextCompat.getColor(currContext, R.color.lightRed));
        }

        // Lookup view for data population
        TextView habit_title = (TextView) convertView.findViewById(R.id.today_habit_title);

        Button completion_button = (Button) convertView.findViewById(R.id.completeHabitBtn);

        completion_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Habit h = habitsList.get(position); //or some other task
                h.addHabitCompletion();
                System.out.println(h.getTitle());
                RelativeLayout listItem = (RelativeLayout) v.getParent();
                //v.setBackgroundColor(ContextCompat.getColor(currContext, R.color.lightGreen));
                listItem.setBackgroundColor(ContextCompat.getColor(currContext, R.color.lightGreen));
                if(currContext instanceof MainActivity){
                    ((MainActivity) currContext).showHabitCompletion(h.getTitle());
                }

                HabitListController.saveInFile();
            }
        });

        // Populate the data into the template view using the data object
        habit_title.setText(habit.getTitle());
        // Return the completed view to render on screen
        return convertView;
    }
}
