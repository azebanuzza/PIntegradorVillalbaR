
package com.portfoliorv.rodvil.Service;

import com.portfoliorv.rodvil.Entity.SSkills;
import com.portfoliorv.rodvil.Repository.RSSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSSkills {
    @Autowired
    RSSkills rSSkills;
    
    public List<SSkills> list() {
        return rSSkills.findAll();
    }
    
    public Optional<SSkills> getOne(int id) {
        return rSSkills.findById(id);
    }
    
    public Optional<SSkills> getByNamess(String namess) {
        return rSSkills.findByNamess(namess);
    }
    
    public void save (SSkills hskills) {
        rSSkills.save(hskills);
    }
    
    public void delete (int id) {
        rSSkills.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return rSSkills.existsById(id);
    }
    
    public boolean existsByNamess(String namess) {
        return rSSkills.existsByNamess(namess);
    }
}
