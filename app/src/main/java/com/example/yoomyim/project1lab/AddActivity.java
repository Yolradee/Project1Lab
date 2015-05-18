package com.example.yoomyim.project1lab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class AddActivity extends ActionBarActivity{


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitt_add);
    }

        public void addClicked(View v) {

            EditText tDay = (EditText) findViewById(R.id.text0);
            EditText tTime = (EditText) findViewById(R.id.text1);
            EditText tLocation = (EditText) findViewById(R.id.text3);
            EditText tSubject = (EditText) findViewById(R.id.text2);

            String sDay = tDay.getText().toString();
            String sSubject = tSubject.getText().toString();
            String sLocation = tLocation.getText().toString();
            String sTime = tTime.getText().toString();


            System.out.println("sDay=" + sDay + "    sSubject=" +sSubject + "    sLocation=" +sLocation + "    sTime=" +sTime );

            if (sDay.trim().length() == 0 || sSubject.trim().length() == 0 || sLocation.trim().length() == 0
                    || sTime.trim().length() == 0 ) {

                Toast t = Toast.makeText(this.getApplicationContext(),
                        "Please add information.",
                        Toast.LENGTH_SHORT);
                t.show();
            }
            else {

                Intent result = new Intent();
                result.putExtra("day", sDay);
                result.putExtra("subject", sSubject);
                result.putExtra("location", sLocation);
                result.putExtra("time", sTime);



             System.out.println("sDAY:" +sDay + "     sSubject:" +sSubject +"      sLocation:" +sLocation+"    sTime:" +sTime );

                this.setResult(RESULT_OK, result);
                this.finish();


            }
        }
    public void CancelClick (View v) {
        Intent i;
        i = new Intent(this, MainActivity.class);
        startActivityForResult(i,88);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
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


