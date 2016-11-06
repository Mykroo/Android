package com.mykro.colorchooser;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private ColorChooser cch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cch = (ColorChooser) findViewById(R.id.colCh);
        /*ColorPickerDialog color = new ColorPickerDialog(this, new ColorPickerDialog.OnColorChangedListener() {
            @Override
            public void colorChanged(String key, int color) {
                Toast.makeText(context, "Cambio el color #"+ Integer.toHexString(color).substring(2), Toast.LENGTH_SHORT).show();
            }
        }, "picker", Color.BLACK, Color.WHITE);
        color.show();*/
    }


}
