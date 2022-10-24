
package com.portfoliorv.rodvil.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProject {
    @NotBlank
    private String proName;
    private String proDescription;
    private String proImg;
    private String opUrl;
    private String altImg;
    private String repository;

    public dtoProject() {
    }

    public dtoProject(String proName, String proDescription, String proImg, String opUrl, String altImg, String repository) {
        this.proName = proName;
        this.proDescription = proDescription;
        this.proImg = proImg;
        this.opUrl = opUrl;
        this.altImg = altImg;
        this.repository = repository;
    }

    public String getAltImg() {
        return altImg;
    }

    public void setAltImg(String altImg) {
        this.altImg = altImg;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDescription() {
        return proDescription;
    }

    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }

    public String getProImg() {
        return proImg;
    }

    public void setProImg(String proImg) {
        this.proImg = proImg;
    }

    public String getOpUrl() {
        return opUrl;
    }

    public void setOpUrl(String opUrl) {
        this.opUrl = opUrl;
    }
    
    
}
