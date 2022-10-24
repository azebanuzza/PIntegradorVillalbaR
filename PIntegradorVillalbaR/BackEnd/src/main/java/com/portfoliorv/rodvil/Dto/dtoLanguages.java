
package com.portfoliorv.rodvil.Dto;

import javax.validation.constraints.NotBlank;


public class dtoLanguages {
    @NotBlank
    private String name;
    @NotBlank
    private String nivel;
    @NotBlank
    private String description;
    @NotBlank
    private String imgLang;
    @NotBlank
    private String altImg;

    public dtoLanguages() {
    }

    public dtoLanguages(String name, String nivel, String description, String imgLang, String altImg) {
        this.name = name;
        this.nivel = nivel;
        this.description = description;
        this.imgLang = imgLang;
        this.altImg = altImg;
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
