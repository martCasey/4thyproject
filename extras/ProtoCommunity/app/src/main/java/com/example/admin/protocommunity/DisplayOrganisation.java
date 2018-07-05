package com.example.admin.protocommunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.Array;

import static com.example.admin.protocommunity.Type.ballet;
import static com.example.admin.protocommunity.Type.basketball;
import static com.example.admin.protocommunity.Type.chess;
import static com.example.admin.protocommunity.Type.football;
import static com.example.admin.protocommunity.Type.go_karting;
import static com.example.admin.protocommunity.Type.ruby;

//this section was added as the author ran into difficulty comparing strings with enums
enum activityType {football, basketball, ruby, ballet, chess, go_karting}

public class DisplayOrganisation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_organisation);

        //first need to create an array of organisations
        Organisation[] organisations = new Organisation[]
                {new Organisation("Kickers", "45 Shark Lane", football, 3),
                        new Organisation("HoopMasters", "56 Big Road", basketball, 2),
                        new Organisation("Tacklers", "77 Blue Street", ruby, 4),
                        new Organisation("Swan Toes", "66 Grace Lane", ballet, 3),
                        new Organisation("Chess Domain", "17 Oliver Park", chess, 2),
                        new Organisation("Kart Masters", "67 Speed Lane", go_karting, 1)};

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(SelectionPage.EXTRA_MESSAGE);
        //this section was added as the author ran into difficulty comparing strings with enums
        activityType actType = null;
        switch (message)
        {
            case "football":
                actType.equals(football);
                break;
            case "basketball":
                actType.equals(basketball);
                break;
            case "ruby":
                actType.equals(ruby);
                break;
            case "ballet":
                actType.equals(ballet);
                break;
            case "chess":
                actType.equals(chess);
                break;
            case "go-karting":
                actType.equals(go_karting);
                break;
                default:
                    break;
        }

        //loop to print details of organisation
        for(int i = 0; i < organisations.length; i++)
        {
            if(organisations[i].getType().equals(actType))
            {
                message = organisations[i].toString();
            }
        }

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView2);//remember the textView widget
        textView.setText(message);
    }
}
