package com.mykro.examen_pokedex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class menuActivity extends AppCompatActivity {
    private Button btn_lis, btn_gal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);
        initMenu();
    }

    public void initMenu(){
        btn_gal= (Button) findViewById(R.id.galeria);
        btn_lis= (Button) findViewById(R.id.lista);

        btn_lis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(menuActivity.this,"Lista lanzada ", Toast.LENGTH_SHORT).show();
                Intent intent=new  Intent().setClass(menuActivity.this, listaActivity.class);
                startActivity(intent);

            }
        });
        btn_gal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(menuActivity.this,"Lista lanzada ", Toast.LENGTH_SHORT).show();
                Intent intent=new  Intent().setClass(menuActivity.this, galeria.class);
                startActivity(intent);

            }
        });
    }
}
