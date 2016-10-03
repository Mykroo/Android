package com.mykro.examen_pokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mc_mi on 03/10/2016.
 */
public class AdaptadorImagenes extends BaseAdapter {
    private Context context;

    public AdaptadorImagenes(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Chinpoko.ITEMS.length;
    }

    @Override
    public Chinpoko getItem(int position) {
        return Chinpoko.ITEMS[position];
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, viewGroup, false);
        }

        ImageView imagenChinpoko = (ImageView) view.findViewById(R.id.imagen_chinpoko);
        TextView nombreChinpoko = (TextView) view.findViewById(R.id.nombre_chinpoko);

        final Chinpoko item = getItem(position);
        imagenChinpoko.setImageResource(item.getIdDrawable());
        nombreChinpoko.setText(item.getNombre());

        return view;
    }

}
