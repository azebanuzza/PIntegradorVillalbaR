
package com.portfoliorv.rodvil.Dto;

import javax.validation.constraints.NotBlank;



    public class dtoEducacion {
    @NotBlank
    private String tituloEdu;
    @NotBlank
    private String descripcionEdu;
    @NotBlank
    private String fechaEdu;
    @NotBlank
    private String altImgEdu;
    @NotBlank
    private String imgEdu;
    
    //Constructor

    public dtoEducacion() {
    }

    public dtoEducacion(String tituloEdu, String descripcionEdu, String fechaEdu, String altImgEdu, String imgEdu) {
        this.tituloEdu = tituloEdu;
        this.descripcionEdu = descripcionEdu;
        this.fechaEdu = fechaEdu;
        this.altImgEdu = altImgEdu;
        this.imgEdu = imgEdu;
    }
    
    //Getters y setters

    public String getTituloEdu() {
        return tituloEdu;
    }

    public void setTituloEdu(String tituloEdu) {
        this.tituloEdu = tituloEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }

    public String getFechaEdu() {
        return fechaEdu;
    }

    public void setFechaEdu(String fechaEdu) {
        this.fechaEdu = fechaEdu;
    }

        public String getAltImgEdu() {
        return altImgEdu;
    }

    public void setAltImgEdu(String altImgEdu) {
        this.altImgEdu = altImgEdu;
    }
    
     public String getImgEdu() {
        return imgEdu;
    }

    public void setImgEdu(String imgEdu) {
        this.imgEdu = imgEdu;
    }
    


    
}