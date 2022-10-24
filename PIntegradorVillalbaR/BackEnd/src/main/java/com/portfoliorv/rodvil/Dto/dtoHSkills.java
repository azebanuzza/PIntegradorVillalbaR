
package com.portfoliorv.rodvil.Dto;

import javax.validation.constraints.NotBlank;


public class dtoHSkills {
    @NotBlank
    private String namehs;
    @NotBlank
    private String percentage;
    @NotBlank
    private String icon;
    @NotBlank
    private String color;
    
    
    //Constructor

    public dtoHSkills() {
    }

    public dtoHSkills(String namehs, String percentage, String icon, String color) {
        this.namehs = namehs;
        this.percentage = percentage;
        this.icon = icon;
        this.color = color;
    }
    
    
    //GyS

    public String getNamehs() {
        return namehs;
    }

    public void setNamehs(String namehs) {
        this.namehs = namehs;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
