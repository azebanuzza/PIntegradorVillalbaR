
package com.portfoliorv.rodvil.Service;

import com.portfoliorv.rodvil.Entity.Languages;
import com.portfoliorv.rodvil.Repository.RLanguage;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SLanguages {
    @Autowired
    RLanguage rLanguages;
    
    public List<Languages> list() {
        return rLanguages.findAll();
    }
    
    public Optional<Languages> getOne(int id) {
        return rLanguages.findById(id);
    }
    
    public Optional<Languages> getByName(String name) {
        return rLanguages.findByName(name);
    }
    
    public void save (Languages edu) {
        rLanguages.save(edu);
    }
    
    public void delete (int id) {
        rLanguages.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return rLanguages.existsById(id);
    }
    
    public boolean existsByName(String name) {
        return rLanguages.existsByName(name);
    }
}
