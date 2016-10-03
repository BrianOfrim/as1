package com.example.brianofrim.as1;

import android.app.Activity;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by brianofrim on 2016-09-26.
 */
// singleton design pattern
// based on the student picker for android tutorial by Abram Hindle
//https://www.youtube.com/watch?v=uLnoI7mbuEo&feature=youtu.be
//https://www.youtube.com/watch?v=gmNfc6u1qk0
// LICENSE : https://github.com/abramhindle/student-picker/blob/master/LICENSE

// File I/O based on Lonely Twitter by Joshua Charles Campbell
// https://github.com/joshua2ua/lonelyTwitter

/*
 * A controller that implements a singleton design pattern for HabitList
 * all methods and variable are static
 * this controller handles file I/O for the app
 */

public class HabitListController {
    private static HabitList habitList = null;
    private static final String FILENAME = "habits2.sav";
    private static Activity baseActivity;

    static public void setBaseActivity(Activity activity){
        baseActivity = activity; // activity to be used for context
    }

    static public HabitList getHabitList(){
        if(habitList == null){
            habitList = loadFromFile();
            habitList.addListener(new Listener() {
                @Override
                public void update() {
                    saveInFile();
                }
            });
        }
        return habitList;
    }

    static public void addHabitToList(String newHabit, boolean [] daysOfWeek, long dateCreatedInMillis){
        getHabitList().addHabit(newHabit,daysOfWeek,dateCreatedInMillis);

    }

    static public void removeHabitFromList(String habitName){
        getHabitList().removeHabit(habitName);
    }

    static public ArrayList<Habit> getTodaysHabits(int dayOfWeek){
        return getHabitList().getTodaysHabits(dayOfWeek);
    }

    static public Habit getHabitAt(int index){
        return getHabitList().getHabitAt(index);
    }
    // code from lonelyTwitter
    static private HabitList loadFromFile() {
        HabitList newHabitList;
        try {

            FileInputStream fis = baseActivity.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            // Code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            Type listType = new TypeToken<ArrayList<Habit>>(){}.getType();

            ArrayList<Habit> habits = gson.fromJson(in,listType) ;

            newHabitList = new HabitList(habits);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            newHabitList = new HabitList();
        } catch (IOException e) {
            // TODO Auto-generated catch block

            throw new RuntimeException();
        }
        return newHabitList;
    }

    // code from lonelyTwitter
    static public void saveInFile() {
        if(baseActivity == null){ // if the baseActivity is not set then dont continue
            return;
        }
        try {
            FileOutputStream fos = baseActivity.openFileOutput(FILENAME, 0);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            ArrayList<Habit> habits = habitList.getHabits();
            gson.toJson(habits, out	);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }
}

