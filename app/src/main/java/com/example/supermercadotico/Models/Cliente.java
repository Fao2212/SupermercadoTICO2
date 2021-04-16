package com.example.supermercadotico.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Cliente implements Parcelable {

    //******************************************Atributos
    private String imagenPerfilCliente;
    private String nombreUsuario;
    private String nombre;
    private String apellido;
    private String direccion;
    private String email;
    private String contrasena;


    //******************************************Contructor
    public Cliente(String pImagenPerfilCliente, String pNombreUsuario, String pNombre, String pApellido, String pDireccion, String pEmail, String pContrasena) {
        this.imagenPerfilCliente = pImagenPerfilCliente;
        this.nombreUsuario = pNombreUsuario;
        this.nombre = pNombre;
        this.apellido = pApellido;
        this.direccion = pDireccion;
        this.email = pEmail;
        this.contrasena = pContrasena;
    }
    //******************************************Parcelable

    protected Cliente(Parcel in) {
        imagenPerfilCliente = in.readString();
        nombreUsuario = in.readString();
        nombre = in.readString();
        apellido = in.readString();
        direccion = in.readString();
        email = in.readString();
        contrasena = in.readString();
    }

    public static final Creator<Cliente> CREATOR = new Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel in) {
            return new Cliente(in);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imagenPerfilCliente);
        dest.writeString(nombreUsuario);
        dest.writeString(nombre);
        dest.writeString(apellido);
        dest.writeString(direccion);
        dest.writeString(email);
        dest.writeString(contrasena);
    }

    //******************************************Setters y Getters


    public String getImagenPerfilCliente() {
        return imagenPerfilCliente;
    }

    public void setImagenPerfilCliente(String imagenPerfilCliente) {
        this.imagenPerfilCliente = imagenPerfilCliente;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    //******************************************toString
    @Override
    public String toString() {
        return "Cliente{" +
                "imagenPerfilCliente='" + imagenPerfilCliente + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
