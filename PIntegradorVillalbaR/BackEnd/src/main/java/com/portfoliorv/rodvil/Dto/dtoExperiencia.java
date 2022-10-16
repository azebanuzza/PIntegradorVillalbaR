
package com.portfoliorv.rodvil.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String fecha;
    @NotBlank
    private String alt;
    @NotBlank
    private String img;
    
    //Constructor

    public dtoExperiencia() {
    }

    public dtoExperiencia(String titulo, String descripcion, String fecha, String alt, String img) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.alt = alt;
        this.img = img;
    }
    
    //Getters y setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    
    
}
