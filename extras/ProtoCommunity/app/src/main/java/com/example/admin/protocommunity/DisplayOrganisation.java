package com.example.admin.protocommunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
//this is the changed version of the file
public class DisplayOrganisation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_organisation);

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
        String message = intent.getStringExtra(SelectionPage.EXTRA_MESSAGE);
        message = GetOrganisationInfo(message, organisations);
        DisplayToView(message);
    }


    public String GetOrganisationInfo(String messageIn, Organisation[] arrayIn) {
        if (messageIn == null) {
            messageIn = GetAllOrganisationInfo(messageIn, arrayIn);
        } else {
            //loop to print details of organisation
            for (int i = 0; i < arrayIn.length; i++) {
                if (arrayIn[i].getType().equalsIgnoreCase(messageIn)) {
                    messageIn = arrayIn[i].toString();
                }
            }
        }
        return messageIn;
    }

    public String GetAllOrganisationInfo(String messageIn, Organisation[] arrayIn) {
        //loop to print details of organisation
        for (int i = 0; i < arrayIn.length; i++) {
            messageIn += arrayIn[i].toString();
        }
        return messageIn;
    }

    public void DisplayToView(String messageIn) {
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView2);//remember the textView widget
        textView.setText(messageIn);
    }
}
