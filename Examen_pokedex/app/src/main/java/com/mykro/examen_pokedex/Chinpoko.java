package com.mykro.examen_pokedex;

/**
 * Created by mc_mi on 03/10/2016.
 */
public class Chinpoko {
    private String nombre;
    private int idDrawable;

    public Chinpoko(String nombre, int idDrawable) {
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }

    public static Chinpoko[] ITEMS = {
            new Chinpoko("Accountafish", R.drawable.ic_unlock_cpm_accountafish),
            new Chinpoko("Beetlebot", R.drawable.ic_unlock_cpm_beetlebot),
            new Chinpoko("Biebersaurus", R.drawable.ic_unlock_cpm_biebersaurus),
            new Chinpoko("Brocorri", R.drawable.ic_unlock_cpm_brocorri),
            new Chinpoko("Chu-chu Nezumi", R.drawable.ic_unlock_cpm_ccnesme),
            new Chinpoko("Cosmonewt", R.drawable.ic_unlock_cpm_cosmonewt),
            new Chinpoko("Donkeytron", R.drawable.ic_unlock_cpm_donkeytron),
            new Chinpoko("Fatdactyl", R.drawable.ic_unlock_cpm_fatdactyl),
            new Chinpoko("Feligor", R.drawable.ic_unlock_cpm_feligor),
            new Chinpoko("Ferasnarf", R.drawable.ic_unlock_cpm_ferasnarf),
            new Chinpoko("Fetuswami", R.drawable.ic_unlock_cpm_fetuswami),
            new Chinpoko("Flowerpotamus", R.drawable.ic_unlock_cpm_flowerpotamus),
            new Chinpoko("Furrycat", R.drawable.ic_unlock_cpm_furrycat),
            new Chinpoko("Gerbitoad", R.drawable.ic_unlock_cpm_gerbitoad),
            new Chinpoko("Gunrilla", R.drawable.ic_unlock_cpm_gunrilla),
            new Chinpoko("Herbil", R.drawable.ic_unlock_cpm_herbil),
            new Chinpoko("Konefin", R.drawable.konefin),
            new Chinpoko("Lambtron", R.drawable.ic_unlock_cpm_lambtron),
            new Chinpoko("Monkay", R.drawable.ic_unlock_cpm_monkay),
            new Chinpoko("Pengin", R.drawable.ic_unlock_cpm_pengin),
            new Chinpoko("Poodlesaurus", R.drawable.ic_unlock_cpm_poodlesaurus),
            new Chinpoko("Pterdaken", R.drawable.ic_unlock_cpm_pterdaken),
            new Chinpoko("Rabbitech", R.drawable.ic_unlock_cpm_rabbitech),
            new Chinpoko("Roidrat", R.drawable.ic_unlock_cpm_roiderat),
            new Chinpoko("Roo-stor", R.drawable.ic_unlock_cpm_roostor),
            new Chinpoko("Shoe", R.drawable.ic_unlock_cpm_shoe),
            new Chinpoko("Sna-kat", R.drawable.ic_unlock_cpm_snakat),
            new Chinpoko("Stegmata", R.drawable.ic_unlock_cpm_stegmata),
            new Chinpoko("Terribovine", R.drawable.ic_unlock_cpm_terribovine),
            new Chinpoko("Vamporko", R.drawable.ic_unlock_cpm_vamporko),
            new Chinpoko("Velocirapstar", R.drawable.ic_unlock_cpm_velocirapstar),
    };









    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Chinpoko
     */
    public static Chinpoko getItem(int id) {
        for (Chinpoko item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
