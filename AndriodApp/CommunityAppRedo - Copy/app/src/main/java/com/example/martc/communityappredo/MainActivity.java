package com.example.martc.communityappredo;
//Main entry point for app, (like with main() in C++)
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.communityappredo.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button
     *  Needs to have only one View parameter */
    public void sendMessage(View view)
    {
        //Do something in response to button
        /**An Intent is an object that provides runtime binding between separate components, such as two activities
         * The intent represents an apps "intent to do something"
         * Using here to start another activity
         */
        Intent intent = new Intent(this, DisplayMessageActivity.class);//Intent constructor needs 2 parameters
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);//putExtra method adds the EditText's value to the Intent
        startActivity(intent);//Starts an instance of DisplayMessageActivity, specified by the Intent
    }
}
