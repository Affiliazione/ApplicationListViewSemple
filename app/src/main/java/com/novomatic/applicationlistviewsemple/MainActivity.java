package com.novomatic.applicationlistviewsemple;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class MainActivity extends Activity {
    // commit 2 3

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Fabrizio Commit

        final ListView listview = (ListView) findViewById(R.id.listView);

        ArrayList<NovoMenuItem> menuItems = new ArrayList<>();

        menuItems.add(new NovoMenuItem("Login","homeIco"));
        menuItems.add(new NovoMenuItem("Prospect","ProspectIco"));
        menuItems.add(new NovoMenuItem("Home","homeIco"));

        NovoMenuItem[] menuItemArray = new  NovoMenuItem[menuItems.size()];
        menuItemArray = menuItems.toArray(menuItemArray);

        MenuArrayAdapter adapter = new MenuArrayAdapter(this, menuItemArray);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                TextView firstLane = (TextView) view.findViewById(R.id.firstLine);

                Toast.makeText(view.getContext(), firstLane.getText(), Toast.LENGTH_LONG).show();

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
