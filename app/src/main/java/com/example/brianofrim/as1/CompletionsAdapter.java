package com.example.brianofrim.as1;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by brianofrim on 2016-09-28.
 */

/*
 * Adapter for displaying and controlling completions
 */
public class CompletionsAdapter  extends ArrayAdapter<Long> {
    private ArrayList<Long> completionsList;
    private Context currContext;
    public CompletionsAdapter(Context context, ArrayList<Long> completions){
        super(context,0,completions);
        completionsList = completions;
        currContext = context;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.completion_item, parent, false);
        }
        Long completionItem = getItem(position);
        final Calendar currCal = Calendar.getInstance();
        currCal.setTimeInMillis(completionItem);
        TextView completion_text = (TextView) convertView.findViewById(R.id.completion_datetime_textview);

        SimpleDateFormat completionFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
        completionFormat.setTimeZone(currCal.getTimeZone());
        completion_text.setText(completionFormat.format(currCal.getTime()));

        Button delete_btn= (Button) convertView.findViewById(R.id.delete_completion_btn);

        delete_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                completionsList.remove(position);

                if(currContext instanceof HabitDetailActivity){
                    ((HabitDetailActivity) currContext).numCompletionsUpdate();
                }
                notifyDataSetChanged();
                HabitListController.saveInFile();
            }
        });

        return convertView;
    }

}
