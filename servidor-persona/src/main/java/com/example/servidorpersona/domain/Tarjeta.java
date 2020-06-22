package com.example.servidorpersona.domain;

public class Tarjeta {

    private String nombre;
    private boolean conDeuda;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isConDeuda() {
        return conDeuda;
    }

    public void setConDeuda(boolean conDeuda) {
        this.conDeuda = conDeuda;
    }

}
