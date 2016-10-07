package com.mykro.controltxtview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by mc_mi on 05/10/2016.
 */
public class SlideChou extends LinearLayout {

    private OnClickListener onClckLis;
    private ImageButton prev,next;
    private ImageView imgView;
    private String[] images;

    public SlideChou(Context context) {
        super(context);
        inicializa();
    }

    public SlideChou(Context context, AttributeSet attrs) {
        super(context, attrs);
        inicializa();
    }

    public SlideChou(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inicializa();
    }

    public void inicializa(){
        prev = (ImageButton) findViewById(R.id.prev);
        next = (ImageButton) findViewById(R.id.prev);
        imgView = (ImageView) findViewById(R.id.imgV);

        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        li.inflate(R.layout.control_slide_chou,this , true);

        this.escuchadores();
    }

    private void escuchadores(){
        onClckLis=new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };

    }
    public void setImagesArray(String[] imgs){
        
    }


}
