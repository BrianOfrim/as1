package com.example.brianofrim.as1;

import java.util.ArrayList;

/**
 * Created by brianofrim on 2016-09-26.
 */
// singleton design pattern
// based on the student picker for android tutorial
//https://www.youtube.com/watch?v=uLnoI7mbuEo&feature=youtu.be
public class HabitListController {
    private static HabitList habitList = null;

    static public HabitList getHabitList(){
        if(habitList == null){
            habitList = new HabitList();
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
}

