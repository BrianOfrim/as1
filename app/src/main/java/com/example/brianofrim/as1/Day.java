package com.example.brianofrim.as1;

/**
 * Created by brianofrim on 2016-09-20.
 */
public class Day {
    private String name;

    private boolean active;

    Day(String dayName, boolean dayActive){
        this.name = dayName;
        this.active = dayActive;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
