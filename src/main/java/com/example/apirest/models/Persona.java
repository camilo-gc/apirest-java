package com.example.apirest.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombres;
    private String apellidos;
    private String tipoIdentificacion;
    private Integer identificacion;
    @JsonFormat(pattern = "dd/mm/yyyy" )
    private Date nacimiento;
    private String correo;
    private String numCelular;


    public Persona() {
    }


    public Persona(Integer id, String nombres, String apellidos, String tipoIdentificacion, Integer identificacion, Date nacimiento, String correo, String numCelular) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoIdentificacion = tipoIdentificacion;
        this.identificacion = identificacion;
        this.nacimiento = nacimiento;
        this.correo = correo;
        this.numCelular = numCelular;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }


    public void setNombres(String nombres) {
        this.nombres = nombres;
    }


    public String getApellidos() {
        return apellidos;
    }


    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }


    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }


    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }


    public Date getNacimiento() {
        return nacimiento;
    }


    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }

    public int getEdad() {
        return calcularEdad(this.nacimiento);
    }


    private int calcularEdad(Date nacimiento){

        Date fechaActual = new Date();
        final long anioInMiliseg = 31557600000L;//31536000000L;

        long edadEnMiliseg = fechaActual.getTime() - nacimiento.getTime();
        int edad = Math.round(edadEnMiliseg/anioInMiliseg);

        return edad;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombres + '\'' +
                ", apellido='" + apellidos + '\'' +
                ", tipo_identificacion=" + tipoIdentificacion +
                ", identificacion=" + identificacion +
                ", nacimiento=" + nacimiento +
                ", edad=" + getEdad() +
                ", correo=" + correo +
                ", numCelular=" + numCelular +
                '}';
    }

}
