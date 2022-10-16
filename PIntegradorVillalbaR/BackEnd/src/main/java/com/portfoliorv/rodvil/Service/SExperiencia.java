
package com.portfoliorv.rodvil.Service;

import com.portfoliorv.rodvil.Entity.Experiencia;
import com.portfoliorv.rodvil.Repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
    @Autowired
    RExperiencia rExperiencia;
    
    //Esto refiere a la Entity Experiencia y arma una lista con todas las experiencias que encuentre
    public List<Experiencia> list() {
        return rExperiencia.findAll();
    }
    
    public Optional<Experiencia> getOne(int id) {
        return rExperiencia.findById(id);
    }
    
    public Optional<Experiencia> getByTitulo(String titulo) {
        return rExperiencia.findByTitulo(titulo);
    }
    
    public void save (Experiencia exp) {
        rExperiencia.save(exp);
    }
    
    public void delete (int id) {
        rExperiencia.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return rExperiencia.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo) {
        return rExperiencia.existsByTitulo(titulo);
    }
    
    
}
