package com.example.brianofrim.as1;

/**
 * Created by brianofrim on 2016-10-02.
 */
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Calendar;

public class HabitTest {

    @Test
    public void TestHabitTitle(){
        boolean[] noDays = {false,false,false,false,false,false,false};
        Long nowInMillis = Calendar.getInstance().getTimeInMillis();
        Habit h = new Habit("Laundry", noDays, nowInMillis);
        assertEquals("Laundry", h.getTitle());
    }
    @Test
    public void TestHabitSetTitle(){
        boolean[] noDays = {false,false,false,false,false,false,false};
        Long nowInMillis = Calendar.getInstance().getTimeInMillis();
        Habit h = new Habit("Laundry", noDays, nowInMillis);
        h.setTitle("Other Title");
        assertEquals("Other Title",h.getTitle());
    }

    @Test
    public void TestHabitDateCreated(){
        boolean[] noDays = {false,false,false,false,false,false,false};
        Long nowInMillis = Calendar.getInstance().getTimeInMillis();
        Habit h = new Habit("Laundry", noDays, nowInMillis);
        Calendar dateCreated = h.getDateCreated();
        Long dateCreatedInMillis = dateCreated.getTimeInMillis();
        assertEquals(nowInMillis,dateCreatedInMillis);
    }


    @Test
    public void TestHabitDaysOfTheWeek(){
        boolean[] noDays = {false,false,false,false,false,false,false};
        Long nowInMillis = Calendar.getInstance().getTimeInMillis();
        Habit h = new Habit("Laundry", noDays, nowInMillis);
        assertEquals(noDays,h.getDaysOfTheWeek());
    }

    @Test
    public void TestHabitSetDayOfTheWeek(){
        boolean[] noDays = {false,false,false,false,false,false,false};
        Long nowInMillis = Calendar.getInstance().getTimeInMillis();
        Habit h = new Habit("Laundry", noDays, nowInMillis);
        h.setDayOfWeek(0,true);
        assertEquals(true, h.activeOnDayOfTheWeek(0));
    }

    @Test
    public void TestCompletionsList(){
        boolean[] noDays = {false,false,false,false,false,false,false};
        Long nowInMillis = Calendar.getInstance().getTimeInMillis();
        Habit h = new Habit("Laundry", noDays, nowInMillis);
        h.addHabitCompletion();
        h.addHabitCompletion();
        assertEquals(new Integer(2), h.getTimesCompleted());
    }

    @Test
    public void TestTestTodayCompletion(){
        boolean[] noDays = {false,false,false,false,false,false,false};
        Long nowInMillis = Calendar.getInstance().getTimeInMillis();
        Habit h = new Habit("Laundry", noDays, nowInMillis);
        h.addHabitCompletion();
        assertEquals(true, h.completedToday());
    }
    @Test
    public void TestTestTodayNotCompletedn(){
        boolean[] noDays = {false,false,false,false,false,false,false};
        Long nowInMillis = Calendar.getInstance().getTimeInMillis();
        Habit h = new Habit("Laundry", noDays, nowInMillis);
        assertEquals(false, h.completedToday());
    }

    @Test
    public void TestRemoveHabitCompleted(){
        boolean[] noDays = {false,false,false,false,false,false,false};
        Long nowInMillis = Calendar.getInstance().getTimeInMillis();
        Habit h = new Habit("Laundry", noDays, nowInMillis);
        Long completionTime = h.addHabitCompletion();
        h.removeHabitCompletion(completionTime);
        assertEquals(new Integer(0), h.getTimesCompleted());
    }

}
