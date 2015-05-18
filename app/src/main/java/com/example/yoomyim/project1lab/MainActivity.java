package com.example.yoomyim.project1lab;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.util.SparseArray;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.graphics.Typeface;


public class MainActivity extends ActionBarActivity {
    CourseDBHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*// Font path
        String fontPath = "font/Chalkduster.ttf";
        // text view label
        Button txtTest = (Button) findViewById(R.id.btadd);
        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        // Applying font
        txtTest.setTypeface(tf);
        // set font
        txtTest.setText("+ ADD");*/
    }
        public void buttonClicked(View v) {
            int id = v.getId();
            Intent i;

            switch (id) {
                case R.id.btadd:
                    i = new Intent(this, AddActivity.class);
                    startActivityForResult(i,88);
                    break;
                case R.id.btshow:
                    i = new Intent(this, ListActivity.class);
                    startActivity(i);
                    break;
              }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 88) {
            if (resultCode == RESULT_OK) {
                String d = data.getStringExtra("day");
                String s = data.getStringExtra("subject");
                String l = data.getStringExtra("location");
                String t = data.getStringExtra("time");

       System.out.println(d+s+l+t);

                helper = new CourseDBHelper(this);
                SQLiteDatabase db = helper.getWritableDatabase();
                ContentValues r = new ContentValues();
                r.put("day",d);
                r.put("subject",s);
                r.put("location",l);
                r.put("time", t);

                long new_id = db.insert("class", null, r);

      System.out.println("Hello" + new_id);

            }
        }

        Log.d("class", "onActivityResult");

    }
 @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
