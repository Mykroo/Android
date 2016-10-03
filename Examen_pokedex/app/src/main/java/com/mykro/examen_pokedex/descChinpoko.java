package com.mykro.examen_pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class descChinpoko extends AppCompatActivity {
    private TextView tv[];
    private ImageView iv;
    private int id_pkm;
    private String datos[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desc_chinpoko);
        initDesc();
    }
    public void initDesc(){
        String[] imgns,nombres;
        int pos = getIntent().getIntExtra("pos",404);
        imgns= getResources().getStringArray(R.array.files);
        nombres= getResources().getStringArray(R.array.pokomons);
        iv= (ImageView) findViewById(R.id.imgn);
        tv = new TextView[6];
        tv[0] = (TextView) findViewById(R.id.nombre);
        tv[1] = (TextView) findViewById(R.id.tipo);
        tv[2] = (TextView) findViewById(R.id.descripcion);
        tv[3] = (TextView) findViewById(R.id.altura);
        tv[4] = (TextView) findViewById(R.id.peso);
        tv[5] = (TextView) findViewById(R.id.debilidades);
        //tv[4] = (TextView) findViewById(R.id.debilidades);
        //tv.setText(getIntent().getExtras().getString("chinpoko"));
        id_pkm = this.getResources().getIdentifier("chinpokomon_"+pos,"array", this.getPackageName());
        datos = this.getResources().getStringArray(id_pkm); //getResources().getStringArray(R.array.chinpokomon_0); //
        //tv[0].setText("00"+datos.length );
        for (int i=0; i < datos.length; i++ ){
            tv[i].setText(datos[i]);
        }
        tv[0].setText(nombres[pos]);
        iv.setImageResource(getResources().getIdentifier(imgns[pos],"drawable",this.getPackageName()));
        //iv.setImageResource(R.drawable.ic_unlock_cpm_accountafish);



    }
}
