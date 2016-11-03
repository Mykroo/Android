package com.mykro.controltxtview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    txtView tv;
    Context context;
    SlideChou sChou;
    int[] imgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.imgs= new int[] {R.drawable.i1, R.drawable.i2, R.drawable.i4 };
        this.context=getBaseContext();
        tv = (txtView) findViewById(R.id.tv);
        btn = (Button) findViewById(R.id.btn);
        sChou = (SlideChou) findViewById(R.id.slideShow);
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

        this.sChou.setImagesArray(imgs);
    }

}
