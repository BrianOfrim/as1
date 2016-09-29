package com.example.brianofrim.as1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by brianofrim on 2016-09-27.
 */
public class HabitListAdapter extends ArrayAdapter<Habit>{
    public HabitListAdapter(Context context, ArrayList<Habit> habits) {
        super(context, 0, habits);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Habit habit = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.habit_list_item, parent, false);
        }
        // Lookup view for data population
        TextView habit_title = (TextView) convertView.findViewById(R.id.habit_title);
        TextView habit_DOW = (TextView) convertView.findViewById(R.id.habit_days_active);
        // Populate the data into the template view using the data object
        habit_title.setText(habit.getTitle());
        habit_DOW.setText("Do on: " + habit.formatDaysOfWeek());
        // Return the completed view to render on screen
        return convertView;
    }
}
