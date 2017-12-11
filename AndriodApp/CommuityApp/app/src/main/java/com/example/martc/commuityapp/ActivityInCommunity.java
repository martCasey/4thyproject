package com.example.martc.commuityapp;

/**
 * Created by martc on 03/11/2017.
 */

public class ActivityInCommunity {

    //variables
    private String activityName;
    private String organisation;
    private String location;
    private double time;
    private int freeSlots;

    //constructor
    public ActivityInCommunity(String activityNameIn, String organisationIn, String locationIn, double timeIn, int freeSlotsIn)
    {
        this.activityName = activityNameIn;
        this.organisation = organisationIn;
        this.location = locationIn;
        this.time = timeIn;
        this.freeSlots = freeSlotsIn;
    }

    //getters
    public String getActivityName()
    {
        return this.activityName;
    }

    public String getOrganisation()
    {
        return this.organisation;
    }

    public String getLocation()
    {
        return this.location;
    }

    public double getTime()
    {
        return this.time;
    }

    public int getFreeSlots()
    {
        return this.freeSlots;
    }

    //setters
    public void setActivityName(String activityNameIn)
    {
        this.activityName = activityNameIn;
    }

    public void setOrganisation(String organisationIn)
    {
        this.organisation = organisationIn;
    }

    public void setLocation(String locationIn)
    {
        this.location = locationIn;
    }

    public void setTime(double timeIn)
    {
        this.time = timeIn;
    }

    public void setFreeSlots(int freeSlotsIn)
    {
        this.freeSlots = freeSlotsIn;
    }

    //toString
    public String toString()
    {
        return "Activity Name: " + this.getActivityName() +
                "\nOrganisation: " + this.getOrganisation() +
                "\nLocation: " + this.getLocation() +
                "\nTime: " + this.getTime() +
                "\nFree Slots: " + this.getFreeSlots();
    }
}
