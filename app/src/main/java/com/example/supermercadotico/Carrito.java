package com.example.supermercadotico;

import com.example.supermercadotico.Models.Factura;
import com.example.supermercadotico.Models.Producto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Carrito {

    ArrayList<Producto> productos;
    boolean confirmado;
    boolean cancelable;
    int time;

    public Carrito() {
        this.confirmado = false;
        this.cancelable = true;
        this.time = 5*60;
        this.productos = new ArrayList<>();
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public boolean isCancelable() {
        return cancelable;
    }

    public void setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void addProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public Factura generarFactura(String sucursal,String username) {
        double total = 0;
        int id  = 0;
        String date;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        date = dateFormat.format(Calendar.getInstance());
        for (Producto producto :productos
             ) {
           total += Double.valueOf(producto.getPrecio());
        }
        //return new Factura(sucursal,username,date,productos,total,id);
        return null;
    }
}
