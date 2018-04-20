package com.puyakul.prin.psychic_shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper db;
    private Button btn_createNewList, btn_showLists;
    private EditText editText_newListName;
    private Toolbar top_toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        editText_newListName = findViewById(R.id.editText_newListName);

        top_toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(top_toolBar);
        getSupportActionBar().setTitle("Welcome");
        getSupportActionBar().setSubtitle("create a shopping list");

        //Create a new list button
        btn_createNewList = findViewById(R.id.btn_createNewList);
        btn_createNewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewList();
                editText_newListName.getText().clear();
            }
        });

        //Change to MainListView page
        btn_showLists = findViewById(R.id.btn_showLists);
        btn_showLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainListView.class);
                startActivity(intent);
            }
        });
    }



    //Create menu bar on top
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        //Passed 2 things first is Menu resource and menu object
        menuInflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    //Set onClickListener to selected menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.list_menu){
            Intent menuListIntent = new Intent(MainActivity.this, MainListView.class);
            startActivity(menuListIntent);
        }
        return super.onOptionsItemSelected(item);
    }




    public void createNewList(){

       String listName =  editText_newListName.getText().toString().trim();

       //Check is the editText is empty
        if(TextUtils.isEmpty(listName)){
            Toast.makeText(this, "Please enter a List name", Toast.LENGTH_LONG).show();
            return;
        }

       //Check if the editText is filled Return true
        if (db.addLists(listName)){
            Toast.makeText(this, "New list created", Toast.LENGTH_LONG).show();
        }
       //Return false
        else{
            Toast.makeText(this, "Error, no list created", Toast.LENGTH_LONG).show();
        }


    }
}
