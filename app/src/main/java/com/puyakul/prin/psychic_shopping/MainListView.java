package com.puyakul.prin.psychic_shopping;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainListView extends AppCompatActivity {

    private ListView ListView_mainListView;
    private ArrayList<ShoppingList> list = new ArrayList<>();
    private ShoppingListAdapter adapter;


    //private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_view);

        ListView_mainListView = findViewById(R.id.ListView_mainListView);
        adapter = new ShoppingListAdapter(this, android.R.layout.simple_list_item_1, list);
        ListView_mainListView.setAdapter(adapter);
        Log.d("MainActivity", "List Adapter " + adapter);
        //getLists();
    }

    public void getLists(){
//        //get the data and append to a List..
//        Cursor cursor = db.getList();
//        ArrayList<String> listsData = new ArrayList<>();
//        while(cursor.moveToNext()){
//            //get the value from the database in column 1
//            //then add it to the ArrayList
//            listsData.add(cursor.getString(1));
//        }
//        //create a list adapter and set adapter
//        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listsData);
//        ListView_mainListView.setAdapter(listAdapter);
//
//        //set an onItemClickListener to a listView
//        ListView_mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String listsName = parent.getItemAtPosition(position).toString();
//
//                //get the id  that associated with data
//                Cursor cursor = db.getListID(listsName);
//
//                int listsID = -1;
//                while(cursor.moveToNext()){
//                    listsID = cursor.getInt(0);
//                }
//                if(listsID > -1){
//                    Intent listsDetailIntent = new Intent(MainListView.this, MainListsDetail.class);
//                    listsDetailIntent.putExtra("id",listsID);
//                    listsDetailIntent.putExtra("name", listsName);
//                    startActivity(listsDetailIntent);
//                }
//                else{
//                    toastMessage( "No ID associated with that name");
//                }
//            }
//        });

    }

    private void toastMessage(String message){
        Toast.makeText(this, message,Toast.LENGTH_LONG).show();
    }
}
