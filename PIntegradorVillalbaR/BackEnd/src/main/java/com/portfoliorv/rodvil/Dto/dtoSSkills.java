
package com.portfoliorv.rodvil.Dto;

import javax.validation.constraints.NotBlank;


public class dtoSSkills {
    @NotBlank
    private String namess;
    @NotBlank
    private int percentage;
    @NotBlank
    private String icon;
    @NotBlank
    private String color;

    public dtoSSkills() {
    }

    public dtoSSkills(String namess, int percentage, String icon, String color) {
        this.namess = namess;
        this.percentage = percentage;
        this.icon = icon;
        this.color = color;
    }

    public String getNamess() {
        return namess;
    }

    public void setNamess(String namess) {
        this.namess = namess;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
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
