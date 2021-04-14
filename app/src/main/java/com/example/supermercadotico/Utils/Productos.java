package com.example.supermercadotico.Utils;

import android.net.Uri;

import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.R;

/**
 * Clase utilitaria solo para guardar productos, y que se puedan cargar en memoria, no se va para el github
 */
public class Productos {
    public Producto[] PRODUCTOS={
            Banano,Fresa, Pina
    };

    /*
    Frutas
     */

    public static final Producto Banano = new Producto("https://hdstatic.net/gridfs/holadoctor/55803ef0b93795c1498b4567-1593215415,863.jpg",
            "Banano","800","100", "p o t a s i o", "Fruta", "El banano feliz");

    public static final Producto Fresa = new Producto("https://img.interempresas.net/fotos/1341264.jpeg",
            "Fresa","500","200", "Es una fresa", "Fruta", "La Fresa feliz");

    public static final Producto Pina = new Producto("https://okdiario.com/img/recetas/2016/06/28/beneficios-pina.jpg",
            "Piña","1200","30", "Es una piña", "Fruta", "La Piña feliz");
}
