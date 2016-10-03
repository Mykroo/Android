package com.mykro.examen_pokedex;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class galeria extends AppCompatActivity {
    private GridView gv;
    private Context context;
    private String []chinpokos;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galeria);
        initGaleria();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void initGaleria() {
        context=this.getBaseContext();
        gv = (GridView) findViewById(R.id.grid);
        chinpokos = getResources().getStringArray(R.array.pokomons);
        String[] datos = getResources().getStringArray(R.array.pokomons);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);

        gv.setAdapter(adaptador);

        this.gv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                //Mostramos una notificación Toast
                //con la opcion seleccionada
                Toast.makeText(context,"Chinpoko: "+chinpokos[position], Toast.LENGTH_SHORT).show();
                Intent intent=new Intent().setClass(galeria.this, descChinpoko.class);;
                intent.putExtra("chinpoko",chinpokos[position]);
                intent.putExtra("pos",position);
                startActivity(intent);
            }
        });
    }
}
