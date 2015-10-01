package com.wordpress.davidng.truerandom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by admin on 10/1/2015.
 */
public class RandomTextActivity extends Activity implements View.OnClickListener{
    private EditText input, NText, resultTextRandom;
    private Button generateTextRandom;

    private Random randomText = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_text_layout);
        getControls();
    }

    private void getControls() {
        input = (EditText) findViewById(R.id.etInputText);
        NText = (EditText) findViewById(R.id.etNText);
        resultTextRandom = (EditText) findViewById(R.id.etOutputText);
        generateTextRandom = (Button) findViewById(R.id.btnGenerateRandomText);
        generateTextRandom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnGenerateRandomText:
                doRandomText();
                break;
        }
    }

    private void doRandomText() {
        String inputString = input.getText().toString();
        String outputString = "";
        try{
            int nText = Integer.parseInt(NText.getText().toString());
            String[] arrayResult = inputString.trim().split(" ");
            for(int i=0; i<nText; i++){
                int random = randomText.nextInt(arrayResult.length);
                outputString += arrayResult[random] + "   ";
            }
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }
        resultTextRandom.setText(outputString);
    }
}
