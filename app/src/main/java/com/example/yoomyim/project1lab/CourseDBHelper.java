package com.example.yoomyim.project1lab;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.ContentValues;


/**
 * Created by talek on 2/21/15 AD.
 */
public class CourseDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "timetable.sqlite3";
    private static final int version = 2;



    public CourseDBHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE class( " +
                "_id integer primary key autoincrement," +
                "day text not null," +
                "subject text not null," +
                "location text not null," +
                "time text not null);";
        db.execSQL(sql);
    }
    // Select Data

   /* public String[] SelectData(String strDays) {
        // TODO Auto-generated method stub

        try {
            String arrData[] = null;

            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            Cursor cursor = db.query(class , new String[] { "*" },
                    "_id=?",
                    new String[] { String.valueOf(strDays) }, null, null, null, null);

            if(cursor != null)
            {
                if (cursor.moveToFirst()) {
                    arrData = new String[cursor.getColumnCount()];

                    arrData[0] = cursor.getString(0);
                    arrData[1] = cursor.getString(1);
                    arrData[2] = cursor.getString(2);
                    arrData[3] = cursor.getString(3);
                    arrData[4] = cursor.getString(4);

                }
            }
            cursor.close();
            db.close();
            return arrData;

        } catch (Exception e) {
            return null;
        }

    }

    // Insert Data
    public long InsertData(String strDays,String strSubject, String strLocation, String strTime, String strClassInfo) {
        // TODO Auto-generated method stub

        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data

            ContentValues Val = new ContentValues();
            Val.put("Days", strDays);
            Val.put("Subject", strSubject);
            Val.put("Location", strLocation);
            Val.put("Time", strTime);
            Val.put("ClassInfo", strClassInfo);

            long rows = db.insert(TABLE_MEMBER, null, Val);

             db.close();
            return rows; // return rows inserted.

        } catch (Exception e) {
            return -1;
        }

    }

    // Show All Data
    public ArrayList<HashMap<String, String>> SelectAllData() {
        // TODO Auto-generated method stub

        try {

            ArrayList<HashMap<String, String>> MyArrList = new ArrayList< HashMap<String, String> >();
            HashMap<String, String> map;

            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            String strSQL = "SELECT  * FROM " + TABLE_MEMBER;
            Cursor cursor = db.rawQuery(strSQL, null);

            if(cursor != null)
            {
                if (cursor.moveToFirst()) {
                    do {
                        map = new HashMap<String, String>();

                        map.put("Days", cursor.getString(0));
                        map.put("Subject", cursor.getString(1));
                        map.put("location", cursor.getString(2));
                        map.put("Time", cursor.getString(3));
                        map.put("ClassInfo", cursor.getString(4));
                        MyArrList.add(map);
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
            db.close();
            return MyArrList;

        } catch (Exception e) {
            return null;
        }

    }

*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS class;";
        db.execSQL(sql);
        this.onCreate(db);
    }

}

