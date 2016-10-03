package com.mykro.examen_pokedex;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class listaActivity extends AppCompatActivity {
    private ListView lista;
    private EditText inTxt;
    private ListAdapter adapta;
    private Context context;
    private String[] chinpokos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_chinpokos);
        initLista();
    }
    public void initLista(){
        context = this.getBaseContext();
        lista = (ListView) findViewById(R.id.listView);
        inTxt = (EditText) findViewById(R.id.srch_in);
        chinpokos = getResources().getStringArray(R.array.pokomons);
        adapta= ArrayAdapter.createFromResource(this.getBaseContext(),R.array.pokomons,android.R.layout.simple_list_item_1);
        lista.setAdapter(adapta);

        inTxt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                lista.clearTextFilter();
                lista.setTextFilterEnabled(true);
                lista.setFilterText(inTxt.getText().toString());
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) { }

            @Override
            public void afterTextChanged(Editable arg0) {}
        });

        this.lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                //Mostramos una notificación Toast
                //con la opcion seleccionada
                String str=(String)parent.getItemAtPosition(position);
                position=findPos(str);
                if (position!=404) {
                    //Toast.makeText(context, "Chinpoko: " + position + str, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent().setClass(listaActivity.this, descChinpoko.class);
                    intent.putExtra("chinpoko", chinpokos[position]);

                    intent.putExtra("pos", position);
                    startActivity(intent);
                }else
                    Toast.makeText(context, "Chinpoko no encontrado " + position , Toast.LENGTH_SHORT).show();

            }
        });
    }
    public  int findPos(String str){
        for (int i = 0; i < chinpokos.length; i++){
            if (chinpokos[i].equals(str))
                return i;
        }
        return 404;
    }


}
