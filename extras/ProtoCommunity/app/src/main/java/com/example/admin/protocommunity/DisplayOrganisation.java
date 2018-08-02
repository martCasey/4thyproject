package com.example.admin.protocommunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        JsonParse();
    }

    //JSON Code
    private void JsonParse()
    {
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        final String message = intent.getStringExtra(SelectionPage.EXTRA_MESSAGE);        //now we recieve the organisation name, not the type
        String url = "https://api.myjson.com/bins/1fv6e0";//fine
        //our file is a JSON object, so we need this request type
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String name = "";
                            String address = "";
                            String type = "";
                            JSONArray jsonArray = response.getJSONArray("organisations");   //remember this is the name of the array in your JSON file

                            //here we get the values of each JSON object one at a time
                            for(int i = 0; i < jsonArray.length(); i++) {
                                //need this JSON object to store values
                                Log.d("Loop", "Please see me");
                                JSONObject organisation = jsonArray.getJSONObject(i);
                                //we need these variables to store the values
                                name = organisation.getString("name");
                                address = organisation.getString("address");
                                type = organisation.getString("type");

                                //end loop if match is found
                                if (name == message) {
                                    break;
                                }
                            }

                                //display json object to text view
                            DisplayToView(name, address, type);

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

    //volley code is likely to go here and make use of the text view
}
