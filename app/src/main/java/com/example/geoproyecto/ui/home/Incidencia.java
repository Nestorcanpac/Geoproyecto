package com.example.geoproyecto.ui.home;

public class Incidencia {
    String latitud;
    String longitud;
    String direccio;
    String nombre;

    String propina;


    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPropina() {
        return propina;
    }

    public void setPropina(String propina) {
        this.propina = propina;
    }

    public Incidencia(String latitud, String longitud, String direccio, String nombre, String propina) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccio = direccio;
        this.nombre = nombre;
        this.propina = propina;
    }

    public Incidencia() {

    }
}