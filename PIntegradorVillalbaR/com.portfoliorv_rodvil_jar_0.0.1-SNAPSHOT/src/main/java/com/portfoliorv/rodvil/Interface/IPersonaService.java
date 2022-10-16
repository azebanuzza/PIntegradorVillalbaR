package com.portfoliorv.rodvil.Interface;

import com.portfoliorv.rodvil.Entity.Persona;
import java.util.List;

public interface IPersonaService {
   
    public List<Persona> getPersona();
   
    
    //Guardar un objeto de tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto/usuario, pero lo buscamos por ID
    public void deletePersona(Long id);
    
    //Buscar una persona por ID
    public Persona findPersona(Long id);
}
