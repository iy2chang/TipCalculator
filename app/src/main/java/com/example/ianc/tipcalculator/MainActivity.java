package com.example.ianc.tipcalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCalculate(View view){

        if(view.getId() == R.id.BCalc){
            EditText a1 = (EditText) findViewById(R.id.TFAmount);
            EditText a2 = (EditText) findViewById(R.id.TFPercent);
            Double num1 = 0.0, num2 = 0.0;
            try {
                num1 = Double.parseDouble(a1.getText().toString());
                num2 = Double.parseDouble(a2.getText().toString());
            }
            catch(NumberFormatException nfe){
                // dialog box for error input
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Error");
                alertDialog.setMessage("Please enter a number");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){

                    }
                });
                alertDialog.show();
                System.out.println("please enter numbers");
            }
            double answer = 0;
            answer = (num1 * num2) / 100 + num1;

            TextView tw = (TextView) findViewById(R.id.TFResult);
            tw.setText(""+answer);
        }

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
