//package com.puyakul.prin.psychic_shopping;
//
//import android.content.Context;
//import android.content.Intent;
//import android.database.Cursor;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.ListAdapter;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.sql.Time;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainListsDetail extends AppCompatActivity {
//
//    private Button btn_deleteItem, btn_editListName;
//    private EditText editText_ListName, editText_addNewItemName;
//    private TextView textView_listName;
//    private ListView ListView_ListDetail;
//
//    private DatabaseHelper db;
//
//    private String selectedList;
//    private int selectedID;
//
//    public ArrayList<String> listDetailData = new ArrayList<>();
//
//    //Time stamp code, matching current time zone
//    //private Time today = new Time(Time.getCurrentTimezone());
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_lists_detail);
//
//        //declare layout elements
//        ListView_ListDetail = findViewById(R.id.ListView_ListDetail);
//        textView_listName = findViewById(R.id.textVie_listName);
//        editText_addNewItemName = findViewById(R.id.editText_addNewItemName);
//
//
//
//        //declare database
//        db = new DatabaseHelper(this);
//
//        //get the intent extra from MainListView
//        Intent receivedIntent = getIntent();
//
//        //now get the listID we passed on extra
//        selectedID = receivedIntent.getIntExtra("id",0); // -1 for the default value
//
//        //now get the name we passed on extra
//        selectedList = receivedIntent.getStringExtra("name");
//
//        //set text to show the current selected name
//        textView_listName.setText(selectedList);
//
//
////        ArrayAdapter aa = new ArrayAdapter(..., itemsList);
////        ArrayAdapter itemListAdapter = new ArrayAdapter();
//        ListView_ListDetail.setAdapter(new ListItemAdapter(this, R.layout.activity_item_detail_list, listDetailData));
//        getListDetail();
//
//
//        btn_editListName = findViewById(R.id.btn_addNewItem);
//        btn_editListName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addItem();
//                editText_addNewItemName.getText().clear();
//            }
//        });
//    }
//
//    public void addItem(){
//
//        String newItemName = editText_addNewItemName.getText().toString().trim();
//
//
//        //Getter Setter
//        ShoppingItem s = new ShoppingItem();
//        s.setID(1);
//        s.setCatagory("aaa");
//
//
//        if(TextUtils.isEmpty(newItemName)){
//            Toast.makeText(this, "Please enter a new item", Toast.LENGTH_SHORT).show();
//            // ****Must have return to make it work****
//            return;
//        }
//
//        if(db.addListsItem(newItemName,selectedID)){
//
//            Toast.makeText(this, "New item added to the list", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            Toast.makeText(this, "Error, no item add to the list", Toast.LENGTH_SHORT).show();
//        }
//
//        getListDetail();
//
//    }
//
//    public void getListDetail(){
//
//        listDetailData.clear();
//
//        Cursor cursor = db.getListDetail(selectedID);
//        //Log.d("TAG", "selected ID" +selectedID);
//        //ArrayList<String> listDetailData = new ArrayList<>();
//        while(cursor.moveToNext()){
//            listDetailData.add(cursor.getString(0));
//        }
//
//        //ListAdapter listDetailAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, listDetailData);
//        //ListView_ListDetail.setAdapter(listDetailAdapter);
//
//
//        ((ArrayAdapter<String>)ListView_ListDetail.getAdapter()).notifyDataSetChanged();
//    }
//
//    //=============Simple Test==================
////    ShoppingItem item = new ShoppingItem();
////    public ShoppingItem getShoppingItem(){
////        ShoppingItem i = new ShoppingItem();
////        DatabaseHelper db = new DatabaseHelper(this);
////        Cursor c = db.getList();
////        //set parameters
////        String name = null;
////        int id = 0;
////        int listId = 0;
////        if (c.moveToFirst()){
////            id = c.getInt(0);
////            i.setID(id);
////            i.getID();
////        }
////        while (c.moveToFirst()){
////
////        }
////    }
//
//
//}
