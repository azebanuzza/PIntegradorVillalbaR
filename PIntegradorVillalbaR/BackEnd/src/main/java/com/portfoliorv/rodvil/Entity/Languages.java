
package com.portfoliorv.rodvil.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Languages {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nivel;
    private String description;
    private String imgLang;
    private String altImg;

    public Languages() {
    }

    public Languages(String name, String nivel, String description, String imgLang, String altImg) {
        this.name = name;
        this.nivel = nivel;
        this.description = description;
        this.imgLang = imgLang;
        this.altImg = altImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgLang() {
        return imgLang;
    }

    public void setImgLang(String imgLang) {
        this.imgLang = imgLang;
    }

    public String getAltImg() {
        return altImg;
    }

    public void setAltImg(String altImg) {
        this.altImg = altImg;
    }
    
    
}
