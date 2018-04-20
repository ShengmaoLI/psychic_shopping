package com.puyakul.prin.psychic_shopping;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainListsDetail extends AppCompatActivity {

    private Button btn_deleteList, btn_editListName;
    private EditText editText_ListName;
    private TextView textView_listName;
    private ListView ListView_ListDetail;

    private DatabaseHelper db;

    private String selectedList;
    private int selectedID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lists_detail);

        //declair layout elements
        ListView_ListDetail = findViewById(R.id.ListView_ListDetail);

        textView_listName = findViewById(R.id.textVie_listName);

        //declair database
        db = new DatabaseHelper(this);

        //get the intent extra from MainListView
        Intent receivedIntent = getIntent();

        //now get the listID we passed on extra
        selectedID = receivedIntent.getIntExtra("id",-1); // -1 for the default value

        //now get the name we passed on extra
        selectedList = receivedIntent.getStringExtra("name");

        //set text to show the current selected name
        textView_listName.setText(selectedList);

        getListDetail();
    }

    public void getListDetail(){

        Cursor cursor = db.getListDetail(selectedID);
        Log.d("TAG", "selected ID" +selectedID);
        ArrayList<Integer> listDetailData = new ArrayList<>();
        while(cursor.moveToNext()){
            listDetailData.add(cursor.getInt(1));
        }

        ListAdapter listDetailAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, listDetailData);
        ListView_ListDetail.setAdapter(listDetailAdapter);
    }
}
