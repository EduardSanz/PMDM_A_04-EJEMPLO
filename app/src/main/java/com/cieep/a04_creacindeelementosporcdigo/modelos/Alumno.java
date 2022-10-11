package com.cieep.a04_creacindeelementosporcdigo.modelos;

import java.io.Serializable;

public class Alumno implements Serializable {

    private String nombre;
    private String apellidos;
    private String ciclo;
    private char grupo;

    public Alumno(String nombre, String apellidos, String ciclo, char grupo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciclo = ciclo;
        this.grupo = grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public char getGrupo() {
        return grupo;
    }

    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", ciclo='" + ciclo + '\'' +
                ", grupo=" + grupo +
                '}';
    }
}
