package com.mykro.examen_pokedex;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Handler hndlr;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        intent = new Intent().setClass(MainActivity.this, menuActivity.class);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Toast.makeText(getBaseContext(),
                        "Launching",
                        Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();


                //setContentView(R.layout.list_chinpokos);
            }
        }, 2000);
    }
}
