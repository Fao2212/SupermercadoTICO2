package com.example.supermercadotico.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Clase de Factura
 * tiene toda la informacion de una Factura
 * Es parceleable para poder hacer la comunicacion de los fragmentos y mandar objetos.
 */
public class Factura  implements Parcelable {


    //******************************************Atributos
    private String sucursal;
    private String usuario;
    private String fecha;
    private String productos;
    private String total;
    private String id;

    //******************************************Contructor
    public Factura(String pSucursal, String pUsuario, String pFecha, String pProductos, String pTotal, String pID) {
        this.sucursal = pSucursal;
        this.usuario = pUsuario;
        this.fecha = pFecha;
        this.productos = pProductos;
        this.total = pTotal;
        this.id = pID;
    }

    //******************************************Parcelable

    protected Factura(Parcel in) {
        sucursal = in.readString();
        usuario = in.readString();
        fecha = in.readString();
        productos = in.readString();
        total = in.readString();
        id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sucursal);
        dest.writeString(usuario);
        dest.writeString(fecha);
        dest.writeString(productos);
        dest.writeString(total);
        dest.writeString(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Factura> CREATOR = new Creator<Factura>() {
        @Override
        public Factura createFromParcel(Parcel in) {
            return new Factura(in);
        }

        @Override
        public Factura[] newArray(int size) {
            return new Factura[size];
        }
    };


    //******************************************Setters y Getters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }


    //******************************************toString

    @Override
    public String toString() {
        return "Factura{" +
                "sucursal='" + sucursal + '\'' +
                ", usuario='" + usuario + '\'' +
                ", fecha='" + fecha + '\'' +
                ", productos='" + productos + '\'' +
                ", total='" + total + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
