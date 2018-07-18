package com.example.admin.protocommunity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.admin.protocommunity.SelectionPage.EXTRA_MESSAGE;
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
        final String[] organisationsNames = new String[]
                {new String("Kickers"),
                        new String("HoopMasters"),
                        new String("Tacklers"),
                        new String("Swan Toes"),
                        new String("Chess Domain"),
                        new String("Kart Masters")};

        //https://stackoverflow.com/questions/12437196/you-must-supply-a-resource-id-for-a-textview
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(), android.R.layout.simple_list_item_1, organisationsNames);
        setListAdapter(adapter);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Toast.makeText(ListResults.this,organisationsNames[position],Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ListResults.this, DisplayOrganisation.class);
                String message = organisationsNames[position].toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });

        /*getListView().setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position){
                ItemClicked item = adapter.getItemAtPosition(position);

                Intent intent = new Intent(Activity.this,destinationActivity.class);
                //based on item add info to intent
                startActivity(intent);
            }
        });*/

    }


}
