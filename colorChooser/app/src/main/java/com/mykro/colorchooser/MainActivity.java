package com.mykro.colorchooser;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private SeekBar[] sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVars();
        //ColorPickerDialog color = new ColorPickerDialog(this,this, "picker",Color.BLACK, Color.WHITE);
        //color.show();


    }

    private void initVars(){
        sb = (SeekBar)  {findViewById(R.id.sb_R), findViewById(R.id.sb_G),findViewById(R.id.sb_B)};
    }

}
