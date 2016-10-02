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
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by brianofrim on 2016-09-28.
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
        TextView completion_text = (TextView) convertView.findViewById(R.id.completion_datetime_textview);
        completion_text.setText(completionItem.toString());

        Button delete_btn= (Button) convertView.findViewById(R.id.delete_completion_btn);

        delete_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                completionsList.remove(position);
                notifyDataSetChanged();
                HabitListController.saveInFile();
            }
        });

        return convertView;
    }

}
