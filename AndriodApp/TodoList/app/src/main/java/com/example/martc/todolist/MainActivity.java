package com.example.martc.todolist;         //this will reflect your package name

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";       //Need to create a this TAG constant to log the class you are logging
    private ListView mTaskListView;     //private instance of ListView item
    private ArrayAdapter<String> mAdapter;      //private instance of an array adapter.  Will help populate the ListView with data.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);         //points to the activity_main.xml file

        mHelper = new TaskDbHelper(this);
        mTaskListView = (ListView) findViewById(R.id.list_todo);
        updateUI();
        cursor.close();
        db.close();
    }//When you run the application, LogCat will show a list of all the tasks stored in the database.

    private void updateUI()
    {
        ArrayList<String> taskList = new ArrayList();
        SQLiteDatabase db = mHelper.getReadableDatabase();      //Fetch all data from the Database
        Cursor cursor = db.query(TaskContract.TaskEntry.TABLE,
                new String[]{TaskContract.TaskEntry._ID,
                        TaskContract.TaskEntry.COL_TASK_TITLE},
                null, null, null, null, null);
        while(cursor.moveToNext())
        {
            int idx = cursor.getColumnIndex(com.aziflaj.todolist.db.TaskContract.TaskEntry.COL_TASK_TITLE);
            Log.d(TAG, "TASK: " +  cursor.getString(idx));
        }

        if(mAdapter == null)
        {
            mAdapter = new ArrayAdapter<>(this,
                    R.layout.item_todo,     //What view to use for the items
                    R.id.task_title,        //Where to put the string of data
                    taskList);              //Where to get all the data
            mTaskListView.setAdapter(mAdpater);     //Set it as the adapter of the ListView instance
        }
        else
        {
            mAdapter.clear();
            m.Adapter.addAll(taskList);
            m.Adapter.notifyDataSetChanged();
        }
        cursor.close();
        db.close();
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
                final EditText taskEditText = new EditText(this);
                AlertDialog dialog = new AlertDialog.Builder(this)//When add item button is clicked AlterDialog gets the task from the user
                        .setTitle("Add a new task")
                        .setMessage("What do you want to do next?")
                        .setView(taskEditText)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                String task = String.valueOf(taskEditText.getText());       //Code to store data in the Database
                                SQLiteDatabase db = mHelper.getWritableDatabase();
                                ContentValues values = new ContentValues();
                                values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
                                db.insertWithOnConflict(TaskContract.TaskEntry.TABLE,
                                        null,
                                        values,
                                        SQLiteDatabase.CONFLICT_REPLACE);
                                db.close();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                updateUI();
                dialog.show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void deleteTask(View view)       //Delete a task from the list
    {
        View parent = (View) view.getParent();
        TextView taskView = (TextView) parent.findViewById(R.id.task_title);
        String task = String.valueOf(taskTextView.getText());
        SQLiteDatabase db = mHelper.getWritableDatabase();
        db.delete(TaskContract.TaskEntry.COL_TASK_TITLE + " = ?",
                new String[]{task});
        db.close();
        updateUI();
    }
}
