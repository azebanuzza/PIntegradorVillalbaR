
package com.portfoliorv.rodvil.Service;

import com.portfoliorv.rodvil.Entity.Educacion;
import com.portfoliorv.rodvil.Repository.REducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion {
    @Autowired
    REducacion rEducacion;
    
    //Esto refiere a la Entity Educación y arma una lista con todas las Educacions que encuentre
    public List<Educacion> list() {
        return rEducacion.findAll();
    }
    
    public Optional<Educacion> getOne(int id) {
        return rEducacion.findById(id);
    }
    
    public Optional<Educacion> getByTituloEdu(String tituloEdu) {
        return rEducacion.findByTituloEdu(tituloEdu);
    }
    
    public void save (Educacion edu) {
        rEducacion.save(edu);
    }
    
    public void delete (int id) {
        rEducacion.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return rEducacion.existsById(id);
    }
    
    public boolean existsByTituloEdu(String tituloEdu) {
        return rEducacion.existsByTituloEdu(tituloEdu);
    }
}
