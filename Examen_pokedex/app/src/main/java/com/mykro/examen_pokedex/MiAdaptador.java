package com.mykro.examen_pokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mc_mi on 03/10/2016.
 */
public class MiAdaptador extends ArrayAdapter<String> {

    private final String [] programas;
    private final String [] imagenes;
    static class ViewHolder {
        public TextView tv_programa;
        public ImageView imgV;

        //constructor que rec
        public ViewHolder(TextView programa,ImageView imagen) {
            this.tv_programa = programa;
            this.imgV = imagen;
        }
        public ViewHolder(TextView programa) {
            this.tv_programa = programa;
        }
        public ViewHolder(ImageView imagen) {this.imgV= imagen; }

    }
    /*
    LayoutInflater, sirve para "inflar" la ui en un layout declarado en un layout xml "inflar"
    es el término utilizado para convertir un xml a objetos java
     */
    private final LayoutInflater li;
    //Constructor recive, el contexto de la aplicacion
    public MiAdaptador(Context context, int resource, String[] objects){
        super(context, resource, objects);
        // guardamos el contenido de la lista
        // en el atributo programas
        this.programas = objects;
        this.imagenes = new String[objects.length];
            /*
             obtenemos el servicio "Layout infater" el cual "infla" nuestra UI
             dentro de u xml y convierte este contenido en objetos java
              */
        this.li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public MiAdaptador(Context context, int resource, String[] objects, String[] imgs){
        super(context, resource, objects);
        // guardamos el contenido de la lista
        // en el atributo programas
        this.programas = objects;
        this.imagenes = imgs;
            /*
             obtenemos el servicio "Layout infater" el cual "infla" nuestra UI
             dentro de u xml y convierte este contenido en objetos java
              */
        this.li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View vistaResultado = convertView;

        TextView tv;
        ImageView imgV;

        ViewHolder holder;
        //si no existe es la primera vez que getView
        if (vistaResultado == null) {

            vistaResultado = li.inflate(R.layout.mi_fila2, parent, false);

            tv = (TextView) vistaResultado.findViewById(R.id.mifila_textView);
            imgV = (ImageView) vistaResultado.findViewById(R.id.imgView);

            holder = new ViewHolder(tv,imgV);

            //se guarda el view holder dentro de la vista resultado
            vistaResultado.setTag(holder);
        }else {
            //en caso de ya no existir la vista se obtiene el ViewHolder
            holder = (ViewHolder) vistaResultado.getTag();
        }

        //se
        int id= vistaResultado.getResources().getIdentifier("com.mykro.examen_pokedex:drawable/"+imagenes[position],null,null);
        holder.tv_programa.setText(programas[position]);
        holder.imgV.setImageResource(id);

        return vistaResultado;
    }
}


