package com.example.brianofrim.as1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by brianofrim on 2016-09-24.
 */

//based on info found here: https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView

public class DayAdapter extends ArrayAdapter<Day> {

    private List<Day> dayList;
    private Context context;

    public DayAdapter( ArrayList<Day> days, Context context) {
        super(context, R.layout.day_listview_item, days);
//        this.context = context;
//        this.dayList = days;


    }

    private static class DayHolder {
        public TextView dayName;
        public CheckBox dayChkbox;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        View v = convertView;
//        DayHolder dayHolder = new DayHolder();
//
//        if(convertView == null) {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            v = inflater.inflate(R.layout.day_listview_item, null);
//            dayHolder.dayName = (TextView) v.findViewById(R.id.day_name_txt);
//            dayHolder.dayChkbox = (CheckBox) v.findViewById(R.id.day_checkbox);
//            dayHolder.dayChkbox.setOnCheckedChangeListener((ListHabitsActivity) context);
//        }else{
//            //dayHolder = (DayHolder) v.getTag();
//        }
//
//        Day d = dayList.get(position);
//        dayHolder.dayName.setText(d.getName());
//        dayHolder.dayChkbox.setChecked(d.isActive());
//        dayHolder.dayChkbox.setTag(d);
//        return v;
        // Get the data item for this position
        final Day day = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.day_listview_item, parent, false);
        }
        // Lookup view for data population
        TextView day_name_txt = (TextView) convertView.findViewById(R.id.day_name_txt);
        CheckBox day_checkbox = (CheckBox) convertView.findViewById(R.id.day_checkbox);
//        day_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Toast.makeText(this, "Clicked on Day :" + "State: " + isChecked, Toast.LENGTH_SHORT).show();
//            }
//        });
//        day_checkbox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final boolean isChecked = day_checkbox.isChecked();
//                // Do something here.
//            }
//        });


        //TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        // Populate the data into the template view using the data object
        day_name_txt.setText(day.getName());
        day_checkbox.setChecked(day.isActive());

        day_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    day.setActive(isChecked);
                }

            }
        });


        //tvHome.setText(user.hometown);
        // Return the completed view to render on screen

        return convertView;
    }
}