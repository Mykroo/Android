package com.mykro.controltxtview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by mc_mi on 05/10/2016.
 */
public class SlideChou extends LinearLayout {

    private OnClickListener onClckLis;
    private ImageButton prev,next;
    private ImageView imgView;
    private int[] images;
    private int index,nImagenes;
    private Context context;

    public SlideChou(Context context) {
        super(context);
        this.context=context;
        inicializa();
    }

    public SlideChou(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        inicializa();
    }

    public SlideChou(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        inicializa();
    }

    public void inicializa(){
        index=0;

        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        li.inflate(R.layout.control_slide_chou,this , true);

        next = (ImageButton) findViewById(R.id.prev);
        prev = (ImageButton) findViewById(R.id.next);
        imgView = (ImageView) findViewById(R.id.imgV);
        this.escuchadores();
        //this.next.setImageResource(R.drawable.next);
        //this.prev.setImageResource(R.drawable.next);
        //this.imgView.setImageResource(R.drawable.gta);
        this.updtImgns();
    }

    private void escuchadores(){
        onClckLis=new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.prev) {
                    Log.d("Listener", "Olitl prev \t"+images.length);
                    nextImg();
                    updtImgns();
                }else{
                    Log.d("Listener", "Olitl next \t" + R.drawable.i1 +"\t "+images[index]);
                    prevImg();
                    updtImgns();
                    //imgView.setBackgroundResource(R.drawable.i1);
                }
            }
        };
        this.next.setOnClickListener(onClckLis);
        this.prev.setOnClickListener(onClckLis);
    }
    private void nextImg() {
        if (images.length > 0) {
            if (index < images.length) {
                index++;
            }
            //updtImgns();
        }
    }
    private void prevImg(){
        if (images.length > 0) {
            if (index > 0) {
                index--;
            }
            //updtImgns();
        }
    }

    private void updtImgns(){

        if (nImagenes == 0){
            this.prev.setBackgroundResource(R.drawable.dis);
            this.next.setBackgroundResource(R.drawable.dis);
            this.imgView.setBackgroundResource(R.drawable.gta);
        }else if (index < nImagenes && index > nImagenes){
            this.imgView.setBackgroundResource(R.drawable.i1);
        }


    }


    public void setImagesArray(int[] imgs){
        this.images=imgs;
        this.nImagenes=imgs.length;
    }


}
