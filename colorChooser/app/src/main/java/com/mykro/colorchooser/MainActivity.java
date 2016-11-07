package com.mykro.colorchooser;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private ColorChooser cch,cch2;
    private AlertDialog alert;
    private LayoutInflater mInflater;
    private View mView;
    private Dialog mDialog;
    private ImageButton btn;
    private CanvasArea dib;
    private Button btns[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //cch = (ColorChooser) findViewById(R.id.colCh);
        //init();

        /*ColorPickerDialog color = new ColorPickerDialog(this, new ColorPickerDialog.OnColorChangedListener() {
            @Override
            public void colorChanged(String key, int color) {
                Toast.makeText(context, "Cambio el color #"+ Integer.toHexString(color).substring(2), Toast.LENGTH_SHORT).show();
            }
        }, "picker", Color.BLACK, Color.WHITE);
        color.show();*/
    }
    public void init(){
        dib = (CanvasArea) findViewById(R.id.dibZone);
        btns= new Button[3];
        btns[0] = (Button) findViewById(R.id.btnR);
        btns[1] = (Button) findViewById(R.id.btnG);
        btns[2] = (Button) findViewById(R.id.btnB);
        cch2 = new ColorChooser(this.getBaseContext());
        btn = (ImageButton) findViewById(R.id.imageButton);
        initList();
        initDialog();
    }
    public void initList(){
        View.OnClickListener l=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnR:
                        dib.setCol(Color.RED);
                        break;
                    case R.id.btnG:
                        dib.setCol(Color.GREEN);
                        break;
                    case R.id.btnB:
                        dib.setCol(Color.BLUE);
                        break;
                }
            }
        };
        for (int i=0; i<3; i++){
            btns[i].setOnClickListener(l);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.show();
            }
        });

    }
    public void initDialog(){
        mInflater = (LayoutInflater) getBaseContext().getSystemService(
                LAYOUT_INFLATER_SERVICE);
        ContextThemeWrapper mTheme = new ContextThemeWrapper(this,
                R.style.AppTheme);

        mView = mInflater.inflate(R.layout.color_chooser, null);
        // mDialog = new Dialog(this,0); // context, theme

        mDialog = new Dialog(mTheme);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(this.cch2);
        //mDialog.show();
    }


}
