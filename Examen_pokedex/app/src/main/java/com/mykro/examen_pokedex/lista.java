package com.mykro.examen_pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class lista extends AppCompatActivity {
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_chinpokos);
        lista=(ListView) findViewById(R.id.listView);
        ListAdapter adapta= ArrayAdapter.createFromResource(this.getBaseContext(),R.array.pokomons,android.R.layout.simple_list_item_1);
        lista.setAdapter(adapta);
    }
}
