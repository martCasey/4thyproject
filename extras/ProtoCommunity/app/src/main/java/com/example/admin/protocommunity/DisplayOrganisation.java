package com.example.admin.protocommunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import static java.sql.Types.NULL;

//this is the changed version of the file
public class DisplayOrganisation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_organisation);
    }

    @Override
    public void onResume(){
        super.onResume();
        // put your code here...
        //strings used to display organisation details
        String name = "";
        String address = "";
        String type = "";
        String about;
        //first need to create an array of organisations
        Organisation[] organisations = new Organisation[]
                {new Organisation("Kickers", "45 Shark Lane", "football", 3),
                        new Organisation("HoopMasters", "56 Big Road", "basketball", 2),
                        new Organisation("Tacklers", "77 Blue Street", "ruby", 4),
                        new Organisation("Swan Toes", "66 Grace Lane", "ballet", 3),
                        new Organisation("Chess Domain", "17 Oliver Park", "chess", 2),
                        new Organisation("Kart Masters", "67 Speed Lane", "go_karting", 1)};

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(SelectionPage.EXTRA_MESSAGE);        //now we recieve the organisation name, not the type
        name = FindName(message, organisations);
        type = FindType(message, organisations);
        address = FindAddress(name, organisations);
        DisplayToView(name, address, type);
        //This is the fixDetails Branch
    }


    //get the type of the organisation from the message, we will only have the name of the organisation to work with
    public String FindType(String messageIn, Organisation[] arrayIn)
    {
        int checked = 0;
        for(int i = 0; i < arrayIn.length; i++)
        {
            if(messageIn.equalsIgnoreCase(arrayIn[i].getName()))
            {
                messageIn = arrayIn[i].getType();
                checked++;
            }
        }
        //If either the name or type are misspelled, then an infinite loop will occur, and the activity won't starts
        if(checked != 1)
        {
            messageIn = FindName(messageIn, arrayIn);
            messageIn = FindType(messageIn, arrayIn);
        }
        return messageIn;
    }

    //get the name of the organisation from the message, we will only have the type of the organisation to work with
    public String FindName(String messageIn, Organisation[] arrayIn)
    {
        int checked = 0;
        for(int i = 0; i < arrayIn.length; i++)
        {
            if(messageIn.equalsIgnoreCase(arrayIn[i].getType()))
            {
                messageIn = arrayIn[i].getName();
                checked++;
            }
        }
        if(checked != 1)
        {
            messageIn = FindType(messageIn, arrayIn);
            messageIn = FindName(messageIn, arrayIn);
        }
        return messageIn;
    }

    //get the address of the organisation from either the name or type you acquired in the prior methods
    public String FindAddress(String nameIn, Organisation[] arrayIn)
    {
        String addressOut = "";
        for(int i = 0; i < arrayIn.length; i++)
        {
            if(arrayIn[i].getName().equalsIgnoreCase(nameIn))
            {
                addressOut = arrayIn[i].getAddress();
            }
        }
        return addressOut;
    }

    public String GetAllOrganisationInfo(String messageIn, Organisation[] arrayIn) {
        //loop to print details of organisation
        for (int i = 0; i < arrayIn.length; i++) {
            messageIn += arrayIn[i].toString();
        }
        return messageIn;
    }

    public void DisplayToView(String nameIn, String addressIn, String typeIn) {
        // Capture the layout's TextView and set the string as its text
        TextView textView6 = findViewById(R.id.textView6);//remember the textView widget
        textView6.setText(nameIn);
        TextView textView5 = findViewById(R.id.textView5);//remember the textView widget
        //Storing link here for later reference
        //https://stackoverflow.com/questions/2394935/can-i-underline-text-in-an-android-layout
        SpannableString content = new SpannableString(addressIn);
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView5.setText(content);
        TextView textView7 = findViewById(R.id.textView7);//remember the textView widget
        SpannableString content2 = new SpannableString(typeIn);
        content2.setSpan(new UnderlineSpan(), 0, content2.length(), 0);
        textView7.setText(content2);
    }
}
