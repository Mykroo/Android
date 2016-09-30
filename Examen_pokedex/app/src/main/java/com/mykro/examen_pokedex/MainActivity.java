package com.mykro.examen_pokedex;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Handler hndlr;
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.list_chinpokos);

        lista=(ListView) findViewById(R.id.listView);
        ListAdapter adapta= ArrayAdapter.createFromResource(getBaseContext(),R.array.pokomons,android.R.layout.simple_list_item_1);
        lista.setAdapter(adapta);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Toast.makeText(getBaseContext(),
                        "Launching",
                        Toast.LENGTH_SHORT).show();


                //setContentView(R.layout.list_chinpokos);
            }
        }, 3000);
    }

}
