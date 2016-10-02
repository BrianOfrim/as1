package com.example.brianofrim.as1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by brianofrim on 2016-10-02.
 */
public class HabitListTest {
    @Test
    public void TestAddHabit(){
        boolean[] noDays = {false,false,false,false,false,false,false};
        Long nowInMillis = Calendar.getInstance().getTimeInMillis();
        HabitList hl = new HabitList();
        hl.addHabit("Laundry",noDays,nowInMillis);
        hl.addHabit("Run",noDays,nowInMillis);
        assertEquals(2, hl.getNumberOfHabits());
    }

    @Test
    public void TestRemoveHabit(){
        boolean[] noDays = {false,false,false,false,false,false,false};
        Long nowInMillis = Calendar.getInstance().getTimeInMillis();
        HabitList hl = new HabitList();
        hl.addHabit("Laundry",noDays,nowInMillis);
        hl.removeHabit("Laundry");
        assertEquals(0,hl.getNumberOfHabits());
    }

    @Test
    public void TestUniqueHabitName(){
        boolean[] noDays = {false,false,false,false,false,false,false};
        Long nowInMillis = Calendar.getInstance().getTimeInMillis();
        HabitList hl = new HabitList();
        hl.addHabit("Laundry",noDays,nowInMillis);
        hl.addHabit("Laundry",noDays,nowInMillis);
        assertEquals(1,hl.getNumberOfHabits());
    }

    @Test
    public void TestGetHabitAt(){
        boolean[] noDays = {false,false,false,false,false,false,false};
        Long nowInMillis = Calendar.getInstance().getTimeInMillis();
        HabitList hl = new HabitList();
        hl.addHabit("Laundry",noDays,nowInMillis);
        Habit h = hl.getHabitAt(0);
        assertEquals("Laundry",h.getTitle());
    }

    @Test
    public void TestGetHabitList(){
        boolean[] noDays = {false,false,false,false,false,false,false};
        Long nowInMillis = Calendar.getInstance().getTimeInMillis();
        HabitList hl = new HabitList();
        hl.addHabit("Laundry",noDays,nowInMillis);
        hl.addHabit("Run",noDays,nowInMillis);
        hl.addHabit("Eat vegatables",noDays,nowInMillis);

        ArrayList<Habit> al = hl.getHabits();
        assertEquals(3,al.size());
    }

}
