package com.puyakul.prin.psychic_shopping;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ShoppingListTable {

    public static ShoppingList createFromCursor(Cursor c)
    {
        if (c == null || c.isAfterLast() || c.isBeforeFirst())
        {
            return null;
        }
        else
        {
            ShoppingList p = new ShoppingList();
            p.setId(c.getInt(c.getColumnIndex(KEY_LIST_NAME)));
            p.setName(c.getString(c.getColumnIndex(KEY_LIST_NAME)));
            return p;
        }
    }

    public static final String TABLE_NAME = "list";
    public static final String KEY_ID = "id";
    public static final String KEY_LIST_NAME = "name";

    public static final String CREATE_STATEMENT = "CREATE TABLE "
            + TABLE_NAME
            + " (" + KEY_ID + " integer primary key autoincrement, "
            + KEY_LIST_NAME + " string not null);";

    //Insert function
    public static void insert(SQLiteDatabase db, ShoppingList s){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_LIST_NAME, s.getName());

        db.insert(TABLE_NAME, null, contentValues);
    }


    //Generate ArrayList for List
    public static ArrayList<ShoppingList> selectAll(SQLiteDatabase db)
    {
        ArrayList<ShoppingList> results = new ArrayList<ShoppingList>();

        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null, null);

        if (c != null){
            c.moveToFirst();
            while (!c.isAfterLast()){
                ShoppingList s = createFromCursor(c);
                results.add(s);
                c.moveToNext();
            }
        }

        return results;
    }

    public Cursor getList(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM lists";
        //Change the return type. Not necessary
        return db.rawQuery(sql, null);
    }

}
