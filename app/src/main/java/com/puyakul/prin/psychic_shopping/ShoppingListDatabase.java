package com.puyakul.prin.psychic_shopping;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

public class ShoppingListDatabase {

    private static final String TAG = "ShoppingListDatabase";
    private static final String DATABASE_NAME = "ShoppingListDatabase";
    private static final int DATABASE_VERSION = 2;

    private SQLiteDatabase mDb;
    private DatabaseHelper mDbHealper;
    private final Context mCtx;

    public ShoppingListDatabase(Context ctx){
        this.mCtx = ctx;
    }

    /**
     * DatabaseHelper class.
     *
     * Database helper class to manage connections with the database.
     */
    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(TAG, "DatabaseHelper onCreate");
            db.execSQL(ShoppingListItemTable.CREATE_STATEMENT);
            db.execSQL(ShoppingListTable.CREATE_STATEMENT);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d(TAG, "DatabaseHelper onUpgrade");
            db.execSQL("DROP TABLE IF EXISTS " + ShoppingListItemTable.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + ShoppingListTable.TABLE_NAME);
            onCreate(db); //this will recreate the database as if it were new
        }
    }

    public SQLiteDatabase open(){
        mDbHealper = new DatabaseHelper(mCtx);
        mDb = mDbHealper.getReadableDatabase();
        return mDb;
    }

    public void close(){
        mDb = null;
    }

}
