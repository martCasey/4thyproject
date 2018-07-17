package com.example.admin.protocommunity;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static java.security.AccessController.getContext;

public class ListResults extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_results);
    }

    @Override
    public void onResume(){
        super.onResume();
        // put your code here...
        //first need to create an array of organisations
        String[] organisationsNames = new String[]
                {new String("Kickers"),
                        new String("HoopMasters"),
                        new String("Tacklers"),
                        new String("Swan Toes"),
                        new String("Chess Domain"),
                        new String("Kart Masters")};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(), android.R.layout.simple_list_item_1, organisationsNames);
        setListAdapter(adapter);

    }
}
