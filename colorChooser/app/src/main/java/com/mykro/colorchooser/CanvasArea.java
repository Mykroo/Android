package com.mykro.colorchooser;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by mc_mi on 06/11/2016.
 */
public class CanvasArea extends View {
    private float y;
    private float x;
    private Paint paint;
    private String texto;
    private Path path;
    private int action, lineCol;
    private float density;

    public CanvasArea(Context context) {
        super(context);
        inicializa();
    }

    public CanvasArea(Context context, AttributeSet attrs) {
        super(context, attrs);
        inicializa();
    }

    public CanvasArea(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inicializa();
    }

    /* Constructores provenientes de View */


    /*Metodo utilizado para inicializar los
    elementos a usar enel control*/
    private void inicializa() {
        this.lineCol=Color.MAGENTA;
        this.paint = new Paint();
        this.density = getResources()
                .getDisplayMetrics().density;
        this.texto = "";
        //posicion por defecto del circulo
        this.x = 50;
        this.y = 50;
        this.action = -1;
        this.path = new Path();
        paint.setAntiAlias(true);
        this.setBackgroundColor(Color.LTGRAY);
    }

    private float toDpi(float value) {
        return value * this.density;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        //dibujado del circulo rojo
        canvas.drawCircle(this.x, this.y,
                toDpi(10), paint);

        paint.setColor(Color.BLACK);
        paint.setTextSize(toDpi(20));

        //dibujado del texto mostrando la posicion x,
        // y actual del circulo
        /*canvas.drawText("x= " + this.x, toDpi(40),
                toDpi(20), paint);
        canvas.drawText("y= " + this.y, toDpi(40),
                toDpi(40), paint);
        canvas.drawText(this.texto, toDpi(40),
                toDpi(70), paint);
        */
        //dibujado del path almacenado
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(toDpi(3));
        paint.setColor(lineCol);

        if (action == MotionEvent.ACTION_DOWN) {
            //rewind es usuado para "rebobinar"
            // el objeto Path
            path.rewind();
            path.moveTo(x, y);
        } else if (action == MotionEvent.ACTION_MOVE) {
            //crear una linea del ultimo
            // punto almacenado
            //a la posicion x,y especificada
            path.lineTo(x, y);
        }

        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //onTouchEvent es llamado automaticamente
        this.x = event.getX();
        this.y = event.getY();
        this.action = event.getAction();

        //dependiendo de la accion del usuario
        // se despliega un texto diferente
        if (event.getAction()
                == MotionEvent.ACTION_DOWN) {
            this.texto = "Action down";
        } else if (event.getAction()
                == MotionEvent.ACTION_UP) {
            this.texto = "Action up";
        } else if (event.getAction()
                == MotionEvent.ACTION_MOVE) {
            this.texto = "Action move";
        }

        //usado para avisarle al control
        //que debe repintarse
        this.invalidate();

        return true;
    }
    public void setCol(int col){
        this.lineCol = col;
    }
}
