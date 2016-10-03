package com.example.brianofrim.as1;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by brianofrim on 2016-09-17.
 */
public class Habit implements Serializable {
    private Calendar dateCreated;
    private String title;
    private boolean[] daysOfTheWeek = {false,false,false,false,false,false,false};
    //private Integer timesCompleted;
    private ArrayList<Long> habbitCompletions; // list of completion dates in millis since Jan 1 1970


    public Habit(String newTitle, boolean[] daysOfWeek, long dateCreatedMillis){
        this.title = newTitle;
        this.dateCreated = new GregorianCalendar();
        this.dateCreated.setTimeInMillis(dateCreatedMillis);
        this.habbitCompletions= new ArrayList<Long>();
        this.daysOfTheWeek = daysOfWeek;

    }

    public Calendar getDateCreated() {
        return dateCreated;
    }

//    public void setDateCreated(Calendar dateCreated) {
//        this.dateCreated = dateCreated;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean[] getDaysOfTheWeek(){
        return this.daysOfTheWeek;
    }

    public boolean activeOnDayOfTheWeek(int dayIndex){
        return this.daysOfTheWeek[dayIndex];
    }

    public void setDayOfWeek(int dayIndex, boolean value){
        this.daysOfTheWeek[dayIndex] = value;
    }

    public ArrayList<Long> getHabitCompletions() {
        return habbitCompletions;
    }

    public long addHabitCompletion(){

        Calendar nowCal = Calendar.getInstance();
        this.habbitCompletions.add(nowCal.getTimeInMillis());
        return nowCal.getTimeInMillis();
        //System.out.println(this.habbitCompletions.get(this.habbitCompletions.size() - 1));
    }

    public void removeHabitCompletion(Long completionTime){ // competionTime is in millis since Jan 1 1970
        for(Iterator<Long> i = this.habbitCompletions.iterator(); i.hasNext();){
            Long item = i.next();
            if(item.equals(completionTime)){
                i.remove();
            }
        }
    }

    // check each day since
    public Integer getTimesCompleted(){
        return habbitCompletions.size();

    }

    public String formatDaysOfWeek(){
        String sunday_Str = (daysOfTheWeek[0])? "Sun ": "";
        String monday_Str = (daysOfTheWeek[1])? "Mon ": "";
        String tuesday_Str = (daysOfTheWeek[2])? "Tue ": "";
        String wednesday_Str = (daysOfTheWeek[3])? "Wen ": "";
        String thursday_Str = (daysOfTheWeek[4])? "Thu ": "";
        String friday_Str = (daysOfTheWeek[5])? "Fri ": "";
        String saturday_Str = (daysOfTheWeek[6])? "Sat ": "";

        return sunday_Str + monday_Str + tuesday_Str + wednesday_Str + thursday_Str + friday_Str + saturday_Str;

    }

    public String toString(){
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyy");
        return this.getTitle() + " Made On: "+ formatDate.format(dateCreated.getTime()) + " Days: " + formatDaysOfWeek();
    }

    private long getTodayInMillis(){
        Calendar todayCal =  Calendar.getInstance();
        todayCal.set(Calendar.HOUR,0);
        todayCal.set(Calendar.MINUTE,0);
        todayCal.set(Calendar.SECOND,0);
        todayCal.set(Calendar.MILLISECOND,0);
        return todayCal.getTimeInMillis();
    }



    public boolean completedToday(){
        if(habbitCompletions.size() == 0) return false;
        Long todayInMillis = getTodayInMillis();
        Long lastCompletion = habbitCompletions.get(habbitCompletions.size() -1);
        return lastCompletion > todayInMillis;
    }


}
