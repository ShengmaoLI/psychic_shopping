//package com.puyakul.prin.psychic_shopping;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//public class DatabaseHelper extends SQLiteOpenHelper {
//
//    private static final String DB_NAME = "shoppinglist";
//    private static final int DN_VERSION = 2;
//
//    public DatabaseHelper(Context context){
//        super (context,DB_NAME, null, DN_VERSION);
//
//    }
//
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String sqlLists = "CREATE TABLE lists(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR)";
//        String sqlItems = "CREATE TABLE items(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, list_id INTEGER, FOREIGN KEY(list_id) REFERENCES lists(id))";
//
//        db.execSQL(sqlLists);
//        db.execSQL(sqlItems);
//    }
//
//    public boolean addLists(String name){
//        //Open database
//        SQLiteDatabase db = getReadableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name", name);
//        db.insert("lists", null, contentValues);
//        //Close database
//        db.close();
//        return true;
//    }
//
//    public boolean addListsItem(String name, int id){
//        //Open database
//        SQLiteDatabase db = getReadableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name", name);
//        contentValues.put("list_id", id);
//        db.insert("items", null, contentValues);
//        //Close database
//        db.close();
//        return true;
//    }
//
//    public  int deleteItem (String id){
//        SQLiteDatabase db= getReadableDatabase();
//        return db.delete("item", "ID = ?", new String[] {id});
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        String sqlLists = "DROP TABLE IF EXISTS lists";
//        String sqlItems = "DROP TABLE IF EXISTS items";
//        db.execSQL(sqlLists);
//        db.execSQL(sqlItems);
//        onCreate(db);
//    }
//
//    public Cursor getList(){
//        SQLiteDatabase db = this.getReadableDatabase();
//        String sql = "SELECT * FROM lists";
//        //Change the return type. Not necessary
//        return db.rawQuery(sql, null);
//    }
//
//    public Cursor getListDetail(int id){
//        SQLiteDatabase db = this.getReadableDatabase();
//        String sql = "SELECT items.name FROM items WHERE items.list_id = '" + id + "'";
//        //String sql = "SELECT items.name FROM items INNER JOIN lists ON lists.id=items.list_id WHERE items.list_id = '" + id + "'";
//        return  db.rawQuery(sql,null);
//    }
//
//    public Cursor getListID(String name){
//        SQLiteDatabase db = this.getReadableDatabase();
//        String sql = "SELECT ID FROM lists WHERE name = '" + name + "'";
//        return db.rawQuery(sql, null);
//    }
//
//
//}
