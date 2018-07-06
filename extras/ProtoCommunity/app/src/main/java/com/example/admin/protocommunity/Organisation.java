package com.example.admin.protocommunity;

public class Organisation {

    //class used to store hardcoded values of organisations in the app (for now)

    //variables
    String name;
    String address;
    String type;
    int noSlots;        //number of slots available

    //default constructor
    public Organisation()
    {

    }

    //constructor
    public Organisation(String nameIn, String addressIn, String typeIn, int noSlotsIn)
    {
        this.name = nameIn;
        this.address = addressIn;
        this.type = typeIn;
        this.noSlots = noSlotsIn;
    }

    //getters
    public String getName()
    {
        return this.name;
    }

    public String getAddress()
    {
        return this.address;
    }

    public String getType()
    {
        return this.type;
    }

    public int getNoSlots()
    {
        return noSlots;
    }

    //setters
    public void setName(String nameIn)
    {
        this.name = nameIn;
    }

    public void setAddress(String addressIn)
    {
        this.address = addressIn;
    }

    public void setType(String typeIn)
    {
        this.type = typeIn;
    }

    public void setNoSlots(int noSlotsIn)
    {
        this.noSlots = noSlotsIn;
    }

    //print function
    public String toString()
    {
        return "Name: " + this.getName() +
                "\nAddress: " + this.getAddress() +
                "\nType: " + this.getType() +
                "\nNumber of Available Slots: " + this.getNoSlots()+
                "\n" + "\n";
    }
}
