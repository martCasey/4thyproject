package com.example.admin.protocommunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
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
        String about = "";
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
        name = GetOrganisationInfo(name, message, organisations, 1);
        address = GetOrganisationInfo(address, message, organisations, 2);
        type = GetOrganisationInfo(type, message, organisations, 3);
        DisplayToView(name, address, type);
        //This is the fixDetails Branch
    }


    public String GetOrganisationInfo(String info, String typeIn, Organisation[] arrayIn, int section) {
        switch (section)
        {
            case 0:
                info = GetAllOrganisationInfo(typeIn, arrayIn);
                break;
            case 1://section 1
                //loop to print details of organisation
                for (int i = 0; i < arrayIn.length; i++) {
                    if (arrayIn[i].getType().equalsIgnoreCase(typeIn)) {
                        info = arrayIn[i].getName();
                    }
                }
                break;
            case 2://section 2
                //loop to print details of organisation
                for (int i = 0; i < arrayIn.length; i++) {
                    if (arrayIn[i].getType().equalsIgnoreCase(typeIn)) {
                        info = arrayIn[i].getAddress();
                    }
                }
                break;
            case 3://section 3
                //loop to print details of organisation
                for (int i = 0; i < arrayIn.length; i++) {
                    if (arrayIn[i].getType().equalsIgnoreCase(typeIn)) {
                        info = arrayIn[i].getType();
                    }
                }
                break;
            case 4://section 4
                //loop to print details of organisation
                for (int i = 0; i < arrayIn.length; i++) {
                    if (arrayIn[i].getType().equalsIgnoreCase(typeIn)) {
                        info = "Will be replaced later";
                    }
                }
                break;
                default://section 5
                    break;
        }
        return info;
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
