package com.example.supermercadotico.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Categoria implements Parcelable {
    private String categoria;
    private String imagen_categoria;
    private String id_categoria;
//Constructor
    public Categoria(String categoria, String imagen_categoria, String id_categoria) {
        this.categoria = categoria;
        this.imagen_categoria = imagen_categoria;
        this.id_categoria = id_categoria;
    }

///Parcelable
    protected Categoria(Parcel in) {
        categoria = in.readString();
        imagen_categoria = in.readString();
        id_categoria = in.readString();
    }

    public static final Creator<Categoria> CREATOR = new Creator<Categoria>() {
        @Override
        public Categoria createFromParcel(Parcel in) {
            return new Categoria(in);
        }

        @Override
        public Categoria[] newArray(int size) {
            return new Categoria[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(categoria);
        dest.writeString(imagen_categoria);
        dest.writeString(id_categoria);
    }

    //setters / getters

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImagen_categoria() {
        return imagen_categoria;
    }

    public void setImagen_categoria(String imagen_categoria) {
        this.imagen_categoria = imagen_categoria;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    //tostring

    @Override
    public String toString() {
        return "Categoria{" +
                "categoria='" + categoria + '\'' +
                ", imagen_categoria='" + imagen_categoria + '\'' +
                ", id_categoria='" + id_categoria + '\'' +
                '}';
    }
}
