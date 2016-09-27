package com.example.brianofrim.as1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by brianofrim on 2016-09-20.
 */
public class HabitList {
    private ArrayList<Habit> activeHabits;

    HabitList(){
        activeHabits = new ArrayList<Habit>();
    }

    public ArrayList<Habit> getHabits(){
        return this.activeHabits;
    }


    private boolean habitExists(String newHabitName){
        for(Iterator<Habit> h = this.activeHabits.iterator(); h.hasNext();){
            Habit habit = h.next();
            if(habit.getTitle().equals(newHabitName)){
                return true;
            }
        }
        return false;
    }

    public void addHabit(String newHabit, boolean [] daysOfWeek, long dateCreatedMillis){
        // only add unique names
        if(!this.habitExists(newHabit)){
            this.activeHabits.add(new Habit(newHabit, daysOfWeek,dateCreatedMillis));
        }else {
            //Error
        }

    }

    public void removeHabit(String habitName){
        for(Iterator<Habit> h = this.activeHabits.iterator(); h.hasNext();){
            Habit habit = h.next();
            if(habit.getTitle().equals(habitName)){
                h.remove();
            }
        }
    }

    public ArrayList<Habit> getTodaysHabits(int dayOfWeek){
        ArrayList<Habit> habitsToday = new ArrayList<Habit>();
        for (Habit h: activeHabits) {
            if(h.activeOnDayOfTheWeek(dayOfWeek)){
                habitsToday.add(h);
            }
        }
        return habitsToday;
    }
}
