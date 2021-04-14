package com.example.supermercadotico.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Clase de Producto
 * tiene toda la informacion de un producto
 * Es parceleable para poder hacer la comunicacion de los fragmentos y mandar objetos.
 */
public class Producto implements Parcelable {
    //******************************************Atributos
    private String imagen_Producto;
    private String nombre;
    private String precio;
    private String inventario;
    private String descripcion;
    private String categoria;
    private String proveedor;

    //******************************************Contructor
    public Producto(String pImagen_Producto, String pNombre, String pPrecio, String pInventario, String pDescripcion, String pCategoria, String pProveedor) {
        this.imagen_Producto = pImagen_Producto;
        this.nombre = pNombre;
        this.precio = pPrecio;
        this.inventario = pInventario;
        this.descripcion = pDescripcion;
        this.categoria = pCategoria;
        this.proveedor = pProveedor;
    }

    //******************************************Parcelable
    protected Producto(Parcel in) {
        imagen_Producto = in.readString();
        nombre = in.readString();
        precio = in.readString();
        inventario = in.readString();
        descripcion = in.readString();
        categoria = in.readString();
        proveedor = in.readString();
    }

    public static final Creator<Producto> CREATOR = new Creator<Producto>() {
        @Override
        public Producto createFromParcel(Parcel in) {
            return new Producto(in);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };

    //******************************************Setters y Getters
    public String getImagen_Producto() {
        return imagen_Producto;
    }

    public void setImagen_Producto(String imagen_Producto) {
        this.imagen_Producto = imagen_Producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getInventario() {
        return inventario;
    }

    public void setInventario(String inventario) {
        this.inventario = inventario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    //******************************************toString
    @Override
    public String toString() {
        return "Producto{" +
                "imagen_Producto='" + imagen_Producto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio='" + precio + '\'' +
                ", inventario='" + inventario + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", categoria='" + categoria + '\'' +
                ", proveedor='" + proveedor + '\'' +
                '}';
    }

    //******************************************Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imagen_Producto);
        dest.writeString(nombre);
        dest.writeString(precio);
        dest.writeString(inventario);
        dest.writeString(descripcion);
        dest.writeString(categoria);
        dest.writeString(proveedor);
    }
}
