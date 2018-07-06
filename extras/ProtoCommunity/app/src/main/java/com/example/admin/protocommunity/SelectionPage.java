package com.example.admin.protocommunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class SelectionPage extends AppCompatActivity {

    //public static final String EXTRA_MESSAGE = "com.example.protoCommunity.MESSAGE";
    public static final String EXTRA_MESSAGE = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_page);
    }

    //Called when the user taps the Display all button
    public void displayAll(View view)
    {
        Intent intent = new Intent(this, DisplayOrganisation.class);
        startActivity(intent);
    }

    //Called when the user taps the search button
    public void search(View view)
    {
        Intent intent = new Intent(this, DisplayOrganisation.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** Called when the user taps the Send button
     public void sendMessage(View view) {
     // Do something in response to button   //home      //Class you are using the intent to access
     Intent intent = new Intent(this, DisplayMessageActivity.class);
     EditText editText = (EditText) findViewById(R.id.editText);
     String message = editText.getText().toString();
     intent.putExtra(EXTRA_MESSAGE, message);
     startActivity(intent);
     }
     */


}
