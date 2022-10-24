
package com.portfoliorv.rodvil.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tituloEdu;
    private String descripcionEdu;
    private String fechaEdu;
    private String imgEdu;
    private String altImgEdu;
    
    
    //Constructores

    public Educacion() {
    }

    public Educacion(String tituloEdu, String descripcionEdu, String fechaEdu, String altImgEdu, String imgEdu) {
        this.tituloEdu = tituloEdu;
        this.descripcionEdu = descripcionEdu;
        this.fechaEdu = fechaEdu;
        this.altImgEdu = altImgEdu;
        this.imgEdu = imgEdu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
