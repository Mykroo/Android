package com.mykro.controltxtview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ctrl_txtView tv;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context=getBaseContext();
        tv = (ctrl_txtView) findViewById(R.id.tv);
        btn = (Button) findViewById(R.id.btn);
        btn.setText("holitl");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int brdr = tv.getBorderType();
                brdr++;
                Toast.makeText(context, "Cambio style "+(brdr-1),Toast.LENGTH_SHORT ).show();
                if (brdr>2)
                    tv.setBorderType(0);
                else
                    tv.setBorderType(brdr);
            }
        });
    }

}
