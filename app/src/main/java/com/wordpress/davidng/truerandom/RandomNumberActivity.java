package com.wordpress.davidng.truerandom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by admin on 10/1/2015.
 */
public class RandomNumberActivity extends Activity implements View.OnClickListener{
    private EditText minValue, maxValue, numberOfRandom, result;
    private Button generate;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_number_layout);
        getControls();
    }

    private void getControls(){
        minValue = (EditText) findViewById(R.id.etNumberMin);
        maxValue = (EditText) findViewById(R.id.etNumberMax);
        numberOfRandom = (EditText) findViewById(R.id.etNumberOfRandom);
        result = (EditText) findViewById(R.id.result);
        generate = (Button) findViewById(R.id.btnGenerateRandomNumber);
        generate.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnGenerateRandomNumber:
                doRandomNumber();
                break;
        }
    }
    private void doRandomNumber() {
        String resultString = "";
        try{
            long min = Long.parseLong(minValue.getText().toString());
            long max = Long.parseLong(maxValue.getText().toString());
            int n = Integer.parseInt(numberOfRandom.getText().toString());
            for(int i=0; i<n; i++){

                //long randomNumber = ThreadLocalRandom.current().nextLong(min, max+1);
                long randomNumber = min + (long)(Math.random() * ((max - min) + 1));
                resultString += ""+randomNumber + "   ";
            }
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }
        result.setText(resultString);
    }
}
