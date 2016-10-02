package com.example.brianofrim.as1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by brianofrim on 2016-09-20.
 */
// based off https://github.com/abramhindle/student-picker/blob/master/src/ca/softwareprocess/studentpicker/StudentList.java

public class HabitList implements Serializable{
    private ArrayList<Habit> activeHabits;
    protected transient ArrayList<Listener> listeners = null;

    HabitList(ArrayList<Habit> habits) {
        activeHabits = habits;
    }
    HabitList(){
        activeHabits = new ArrayList<Habit>();
        listeners = new ArrayList<Listener>();
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
        if(!this.habitExists(newHabit)) {
            this.activeHabits.add(new Habit(newHabit, daysOfWeek, dateCreatedMillis));
        }
        notifyListeners();
    }

    public int getNumberOfHabits(){
        return this.activeHabits.size();
    }


    public void removeHabit(String habitName){
        for(Iterator<Habit> h = this.activeHabits.iterator(); h.hasNext();){
            Habit habit = h.next();
            if(habit.getTitle().equals(habitName)){
                h.remove();
            }
        }
        notifyListeners();
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

    public Habit getHabitAt(int index){
        return activeHabits.get(index);
    }

    private ArrayList<Listener> getListeners() {
        if (listeners == null ) {
            listeners = new ArrayList<Listener>();
        }
        return listeners;
    }

    private void notifyListeners() {
        for (Listener  listener : getListeners()) {
            listener.update();
        }
    }

    public void addListener(Listener l) {
        getListeners().add(l);

    }

    public void removeListener(Listener l) {
        getListeners().remove(l);

    }
}
