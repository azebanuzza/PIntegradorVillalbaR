
package com.portfoliorv.rodvil.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona implements Serializable {
    
    /*Acá indicamos que el primer campo va a ser una ID, y el segundo va a ser autogenerado*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud.")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud.")
    private String apellido;
    
    @NotNull
    private String aboutme;

    private String img;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String aboutme, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.aboutme = aboutme;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    
}
