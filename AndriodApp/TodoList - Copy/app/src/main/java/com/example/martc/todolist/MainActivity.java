package com.example.martc.todolist;         //this will reflect your package name

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";       //Need to create a this TAG constant to log the class you are logging

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);         //points to the activity_main.xml file
    }

    //The 2 methods below refer to the functions of a menu view
    @Override
    public boolean onCreateOptionsMenu(Menu menu)       //renders the menu in the main activity
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)     //react to different user interactions with the menu
    {
        switch (item.getItemId())
        {
            case R.id.action_add_task:
                Log.d(TAG, "Add a new task");
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
