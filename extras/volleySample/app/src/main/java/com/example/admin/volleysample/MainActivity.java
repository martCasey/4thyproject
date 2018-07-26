package com.example.admin.volleysample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting up text view
        mTextViewResult = findViewById(R.id.text_view_result);
        //set up button
        Button buttonparse = findViewById(R.id.button_parse);

        //volley instance
        mQueue = Volley.newRequestQueue(this);      //the "this" context means the queue is being used for the results of this activity

        //activated when the button is clicked on
        buttonparse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //what you want to happen after the button is pressed is coded in this method
                JsonParse();
            }
        });
    }

    private void JsonParse()
    {
        String url = "https://api.myjson.com/bins/170psq";
        //our file is a JSON object, so we need this request type
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("employees");   //remember this is the name of the array in your JSON file

                            //here we get the values of each JSON object one at a time
                            for(int i = 0; i < jsonArray.length(); i++)
                            {
                                //need this JSON object to store values
                                JSONObject employee = jsonArray.getJSONObject(i);
                                //we need these variables to store the values
                                String firstName = employee.getString("firstname");
                                int age = employee.getInt("age");
                                String mail = employee.getString("mail");

                                //display json object to text view
                                mTextViewResult.append(firstName + ", " + String.valueOf(age) + ", " + mail + "\n\n");      //at the String.valueOf(age) we are turning the value into a string for printing
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {       //called when there is an error
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
    }
}
