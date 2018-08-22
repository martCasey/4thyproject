package com.example.admin.protocommunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
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

import static java.sql.Types.NULL;

//this is the changed version of the file
public class DisplayOrganisation extends AppCompatActivity {

    private TextView nameView;
    private TextView addressView;
    private TextView typeView;
    private RequestQueue mQueue;

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
        //setup textviews
        nameView = findViewById(R.id.orgName);
        addressView = findViewById(R.id.orgAddress);
        typeView = findViewById(R.id.orgType);

        //set up volley instance
        mQueue = Volley.newRequestQueue(this);
        JsonParse();
    }

    //JSON Code
    //Something is going on here
    private void JsonParse()
    {
        String url = "https://api.myjson.com/bins/1fef5c";//fine
        //our file is a JSON object, so we need this request type
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Get the Intent that started this activity and extract the string
                            Intent intent = getIntent();
                            final String message = intent.getStringExtra(SelectionPage.EXTRA_MESSAGE);        //now we recieve the organisation name, not the type
                            String name = "";
                            String address = "";
                            String type = "";
                            //JSONArray jsonArray = response.getJSONArray("organisations");   //remember this is the name of the array in your JSON file
                            String in = "";
                            JSONObject org = response.getJSONObject("organisation");
                            name = org.getString("name");
                            address = org.getString("address");
                            type = org.getString("type");
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
        mQueue.add(request);
    }

    //value to return index position of array
    public int ReturnJSONArrayIndex(String message, JSONArray array)
    {
        int returnValue = -1;
        try
        {
            for(int i = 0; i < array.length(); i++)
            {
                JSONObject tempObject = array.getJSONObject(i);
                String checkName = tempObject.getString("name");
                if(checkName == message)
                {
                    returnValue = i;
                }
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return returnValue;
    }

    public void DisplayToView(String nameIn, String addressIn, String typeIn) {
        nameView.setText(nameIn);
        addressView.setText(addressIn);
        typeView.setText(typeIn);
    }

    //volley code is likely to go here and make use of the text view
}
