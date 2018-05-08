package com.puyakul.prin.psychic_shopping;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class ShoppingListItemTable {

    public static final String TABLE_NAME = "item";

    public static final String KEY_ITEM_ID = "item_id";
    public static final String KEY_ITEM_NAME = "name";
    public static final String KEY_LIST_ID = "list_id";

    public static final String CREATE_STATEMENT = "CREATE TABLE "
            + TABLE_NAME
            + " (" + KEY_ITEM_ID + " integer primary key autoincrement, "
            + KEY_ITEM_NAME + " string not null, "
            + KEY_LIST_ID + " int not null);";



    public static void insert(SQLiteDatabase db, ShoppingItem s){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ITEM_NAME, s.getName());
        contentValues.put(KEY_LIST_ID, s.getList_id());

        db.insert(TABLE_NAME, null, contentValues);
    }



}

