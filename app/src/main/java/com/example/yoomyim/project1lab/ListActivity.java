package com.example.yoomyim.project1lab;
import java.util.ArrayList;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseArray;
import android.view.Menu;
import android.widget.ExpandableListView;

import com.example.yoomyim.project1lab.MyExpandableListAdapter;

public class ListActivity extends ActionBarActivity {

    SparseArray<group> groups = new SparseArray<group>();
    CourseDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        createData();
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.listView);

        helper = new CourseDBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        //MONDAY
        Cursor cursor = db.rawQuery("SELECT time , subject, location FROM class WHERE day = 'Monday' ORDER BY time ASC;", null);
        for(int i = 0; i < cursor.getCount();i++) {
            cursor.moveToFirst();
            group g1 = new group("MONDAY");
            groups.append(0, g1);
            do {
                String m = cursor.getString(0);
                String m1 = cursor.getString(1);
                String m2 = cursor.getString(2);
                g1.children.add(m + "   " + m1 + "\n" + "Room : " + m2);

            } while (cursor.moveToNext());
        }
        // TUESDAY
        Cursor cursor1 = db.rawQuery("SELECT time , subject, location FROM class WHERE day = 'Tuesday' ORDER BY time ASC;", null);
        for(int i = 0; i < cursor1.getCount();i++) {
            cursor1.moveToFirst();
            group g2 = new group("TUESDAY");
            groups.append(1, g2);
            do {
                String tu = cursor1.getString(0);
                String tu1 = cursor1.getString(1);
                String tu2 = cursor1.getString(2);
                g2.children.add(tu + "   " + tu1 + "\n" + "Room : " + tu2);

            } while (cursor1.moveToNext());
        }

        ///// WEDNESDAY
        Cursor cursor2 = db.rawQuery("SELECT time , subject, location FROM class WHERE day = 'Wednesday' ORDER BY time ASC;", null);
        for(int i = 0; i < cursor2.getCount();i++) {
            cursor2.moveToFirst();
            group g3 = new group("WEDNESDAY");
            groups.append(2, g3);
            do {
                String w = cursor2.getString(0);
                String w1 = cursor2.getString(1);
                String w2 = cursor2.getString(2);

                g3.children.add(w + "   " + w1 + "\n" + "Room : " + w2);
            } while (cursor2.moveToNext());
        }


            //THURSDAY
            Cursor cursor3 = db.rawQuery("SELECT time, subject, location FROM class WHERE day = 'Thursday' ORDER BY time ASC;", null);
           for(int i = 0; i < cursor3.getCount();i++) {
            cursor3.moveToFirst();
            group g4 = new group("THURSDAY");
            groups.append(3, g4);
            do {
                String uu = cursor3.getString(0);
                String u1 = cursor3.getString(1);
                String u2 = cursor3.getString(2);
                g4.children.add(uu + "   " + u1 + "\n" + "Room : " + u2);
            } while (cursor3.moveToNext());
        }
        //FRIDAY
        Cursor cursor4 = db.rawQuery("SELECT time, subject, location FROM class WHERE day = 'Friday' ORDER BY time ASC;", null);
        for(int i = 0; i < cursor4.getCount();i++) {
        cursor4.moveToFirst();
        group g5 = new group("FRIDAY");
        groups.append(4, g5);
            do {
                String ff = cursor4.getString(0);
                String f1 = cursor4.getString(1);
                String f2 = cursor4.getString(2);
                g5.children.add(ff + "   " + f1 + "\n" + "Room : " + f2);
            } while (cursor4.moveToNext());
        }

         MyExpandableListAdapter adapter = new MyExpandableListAdapter(this, groups);
         listView.setAdapter(adapter);

        }


    public void createData() {
        for (int j = 0; j <5  ; j++) {
            group group = new group("Test " + j);
            for (int i = 0; i < 7; i++) {
                group.children.add("Sub Item" + i);
            }
            groups.append(j, group);
        }
    }

} 
