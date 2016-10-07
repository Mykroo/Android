package com.mykro.controltxtview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by mc_mi on 05/10/2016.
 */
public class txtView extends TextView{

    private Paint p1;
    private float densidad;
    private int borderType;
    private float width,height;

    private String txt;

    public txtView(Context context){
        super(context);
        this.inicializa();
    }


    public txtView(Context context, AttributeSet attrs){
        super(context, attrs);
        this.inicializa();
    }

    public txtView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.inicializa();
    }

    private void inicializa(){
        //String infServvice = Context.LAYOUT_INFLATER_SERVICE;
        this.densidad=1;
        this.borderType = 0;
        this.p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.p1.setColor(Color.BLUE);
        this.p1.setStyle(Paint.Style.FILL_AND_STROKE);
        this.p1.setStrokeWidth(3);

        // this.p2.setTextSize(20);

        this.densidad = getResources()
                .getDisplayMetrics().density;
    }
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        float puntos[] = {0,height,width,height, 0,0,width,0, 0,0,0,height, width,0,width,height};;
        this.height=this.getHeight();
        this.width=this.getWidth();

        this.setText(width+", "+height+". "+densidad);
        switch (borderType){
            case 0:
                //p1.setColor(Color.BLUE);
                canvas.drawLines(puntos,p1);
                break;
            case 1:
                canvas.drawLine(0,height,width,height,p1);
                break;
            case 2:
                int aux=p1.getColor();
                p1.setColor(this.getSolidColor());
                canvas.drawLines(puntos,p1);
                p1.setColor(aux);
                break;
        }
    }
    public void setBorderType(int s){
        borderType = s;
    }
    public int getBorderType(){
        return this.borderType;
    }

}
