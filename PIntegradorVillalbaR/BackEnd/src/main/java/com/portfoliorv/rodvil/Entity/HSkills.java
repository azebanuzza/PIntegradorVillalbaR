
package com.portfoliorv.rodvil.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class HSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String namehs;
    @NotNull
    private String percentage;
    @NotNull
    private String icon;
    @NotNull
    private String color;

    public HSkills() {
    }

    //Constructor
    public HSkills(String namehs, String percentage, String icon, String color) {
        this.namehs = namehs;
        this.percentage = percentage;
        this.icon = icon;
        this.color = color;
    }

    
    //GyS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
