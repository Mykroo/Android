package com.mykro.colorchooser;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by mc_mi on 06/11/2016.
 */
public class ColorChooser extends LinearLayout {
    private SeekBar[] sb;
    private TextView tv;
    private Button col;
    private int  r,g=88,b=88;
    private SeekBar.OnSeekBarChangeListener l;
    private Context context;

    public ColorChooser(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public ColorChooser(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

    public ColorChooser(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        init();
    }

    private void init(){
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext()
                .getSystemService(
                        infService);
        li.inflate(R.layout.color_chooser, this, true);

        sb = new SeekBar[3];
        sb[0] = (SeekBar) findViewById(R.id.sb_R);
        sb[1] = (SeekBar) findViewById(R.id.sb_G);
        sb[2] = (SeekBar) findViewById(R.id.sb_B);
        tv = (TextView) findViewById(R.id.textCol);
        col = (Button) findViewById(R.id.colBtn);
        initList();
    }

    public int getColorRGB() {
        return Color.rgb(r,g,b);
    }

    private void initList(){
        l = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (seekBar.getId()){
                    case R.id.sb_R:
                        r= progress;
                        break;
                    case R.id.sb_G:
                        g= progress;
                        break;
                    case R.id.sb_B:
                        b= progress;
                        break;
                }
                String hex = "#"+Integer.toHexString(Color.rgb(r,g,b)).substring(2);
                tv.setText(hex);
                col.setBackgroundColor(Color.rgb(r,g,b));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                col.setBackgroundColor(Color.rgb(r,g,b));
            }
        };
        sb[0].setOnSeekBarChangeListener(l);
        sb[1].setOnSeekBarChangeListener(l);
        sb[2].setOnSeekBarChangeListener(l);
    }
}
