package com.wordpress.davidng.truerandom;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener{
    private Button btnRandomNumber;
    private Button btnRandomText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRandomNumber = (Button) findViewById(R.id.btnNumberRandom);
        btnRandomText = (Button) findViewById(R.id.btnTextRandom);
        btnRandomNumber.setOnClickListener(this);
        btnRandomText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnNumberRandom:
                randomNumber();
                break;
            case R.id.btnTextRandom:
                randomText();
                break;
        }
    }

    private void randomNumber(){
        Intent i = new Intent(MainActivity.this, RandomNumberActivity.class);
        startActivity(i);
    }
    private void randomText(){
        Intent i = new Intent(MainActivity.this, RandomTextActivity.class);
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.About) {
            Intent i = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


}
