package com.mykro.examen_pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class descChinpoko extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desc_chinpoko);
        initDesc();
    }
    public void initDesc(){
        tv = (TextView) findViewById(R.id.desc_txt);
        tv.setText(getIntent().getExtras().getString("chinpoko"));

    }
}
