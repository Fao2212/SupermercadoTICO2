package com.example.supermercadotico.Utils;

import android.net.Uri;

import com.example.supermercadotico.Models.Categoria;
import com.example.supermercadotico.Models.Cliente;
import com.example.supermercadotico.Models.Factura;
import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.R;

/**
 * Clase utilitaria solo para guardar productos, y que se puedan cargar en memoria, no se va para el github, al final se cargo en el github
 */
public class Productos {
    public Producto[] PRODUCTOS={
            Banano,Fresa, Pina
    };

    public Factura[] FACTURAS={
      Fact1, Fact2, Fact3
    };

    public Categoria[] CATEGORIAS={
            Cat1, Cat2, Cat3
    };

    /*
    Cliente
     */
    public  Cliente cliente1 = new Cliente("https://www.volunteeringsolutions.com/asset/uploads/img/page_header_image/costa_rica/san_jose/651/651_costarica.jpg",
            "Alex01",
            "Alex",
            "Rodriguez",
            "Cartago",
            "alealex@hotmail.com",
            "1234");

    public Cliente getCliente1() {
        return cliente1;
    }

    /*
    PRODUCTOS
     */

    public static final Producto Banano = new Producto("https://hdstatic.net/gridfs/holadoctor/55803ef0b93795c1498b4567-1593215415,863.jpg",
            "Banano","800","100", "p o t a s i o", "Fruta", "El banano feliz");
    public static final Producto Fresa = new Producto("https://img.interempresas.net/fotos/1341264.jpeg",
            "Fresa","500","200", "Es una fresa", "Fruta", "La Fresa feliz");
    public static final Producto Pina = new Producto("https://okdiario.com/img/recetas/2016/06/28/beneficios-pina.jpg",
            "Piña","1200","30", "Es una piña", "Fruta", "La Piña feliz");

    /*
    FACTURAS
     */

    public static final Factura Fact1 = new Factura("SanJose","Alex01","1/1/2021","Sandía x1 9900","9900","0001");
    public static final Factura Fact2 = new Factura("Alaueja","Alex01","2/2/2021","Sandía x2 19800","19800","0002");
    public static final Factura Fact3 = new Factura("Guanacaste","Alex01","3/3/2021","Sandía x3 29700","29700", "0003");


    /*
    Categorias
     */

    public static final Categoria Cat1 = new Categoria("Frutas", "https://i2.wp.com/www.buenmercadoacasa.com/blog/wp-content/uploads/2016/09/curiosidades-frutas-buenmercadoacasa.jpg?resize=1080%2C675&ssl=1","001");
    public static final Categoria Cat2 = new Categoria("Vegetales", "https://static3.abc.es/media/salud/2019/08/20/vegetales-esclerosis-kQO--620x349@abc.jpg","002");
    public static final Categoria Cat3 = new Categoria("Limpieza", "https://static3.abc.es/media/bienestar/2020/08/05/cada-cuanto-limpiar-k0vE--620x349@abc.jpeg","003");
}
