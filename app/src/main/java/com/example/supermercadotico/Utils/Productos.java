package com.example.supermercadotico.Utils;

import android.net.Uri;

import com.example.supermercadotico.Models.Categoria;
import com.example.supermercadotico.Models.Cliente;
import com.example.supermercadotico.Models.Factura;
import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.R;

import java.util.ArrayList;

/**
 * Clase utilitaria solo para guardar productos, y que se puedan cargar en memoria, no se va para el github, al final se cargo en el github
 */
public class Productos {

    public Productos() {
        CLIENTES.add(cliente1);
        CLIENTES.add(cliente2);
        CLIENTES.add(cliente3);
    }

    public Producto[] PRODUCTOS={
            Lechuga,Fresa, Jabon
    };

    public Factura[] FACTURAS={
      Fact1, Fact2, Fact3
    };

    public Categoria[] CATEGORIAS={
            Cat1, Cat2, Cat3
    };

    public ArrayList<Cliente> CLIENTES= new ArrayList<Cliente>();

    /*
    Cliente
     */
    public static final  Cliente cliente1 = new Cliente("https://www.volunteeringsolutions.com/asset/uploads/img/page_header_image/costa_rica/san_jose/651/651_costarica.jpg",
            "Alex01",
            "Alex",
            "Rodriguez",
            "Cartago",
            "alealex@hotmail.com",
            "1234");
    public static final  Cliente cliente2 = new Cliente("https://www.volunteeringsolutions.com/asset/uploads/img/page_header_image/costa_rica/san_jose/651/651_costarica.jpg",
            "Alex02",
            "Alex",
            "Rodriguez",
            "Cartago",
            "alealex@hotmail.com",
            "1234");
    public static final Cliente cliente3 = new Cliente("https://www.volunteeringsolutions.com/asset/uploads/img/page_header_image/costa_rica/san_jose/651/651_costarica.jpg",
            "Marco",
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

    public static final Producto Lechuga = new Producto("https://soycomocomo.es/media/2016/06/lechuga.jpg",
            "Lechuga","800","100", "Para hacer ensaladas", "002", "La lechuga feliz");
    public static final Producto Fresa = new Producto("https://img.interempresas.net/fotos/1341264.jpeg",
            "Fresa","500","200", "Es una fresa", "001", "La Fresa feliz");
    public static final Producto Jabon = new Producto("https://cdn2.cocinadelirante.com/sites/default/files/styles/gallerie/public/images/2019/12/15-ideas-de-negocio-desde-casa-con-productos-artesanales-mexico-jabon-neutro.jpg",
            "Jabon","1200","30", "Es un Jabon", "003", "El Jabon feliz");

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
