
package com.portfoliorv.rodvil.Service;

import com.portfoliorv.rodvil.Entity.HSkills;
import com.portfoliorv.rodvil.Repository.RHSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHSkills {
    @Autowired
    RHSkills rHSkills;
    
    //Esto refiere a la Entity HSkills y arma una lista con todas las hskillseriencias que encuentre
    public List<HSkills> list() {
        return rHSkills.findAll();
    }
    
    public Optional<HSkills> getOne(int id) {
        return rHSkills.findById(id);
    }
    
    public Optional<HSkills> getByNamehs(String namehs) {
        return rHSkills.findByNamehs(namehs);
    }
    
    public void save (HSkills hskills) {
        rHSkills.save(hskills);
    }
    
    public void delete (int id) {
        rHSkills.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return rHSkills.existsById(id);
    }
    
    public boolean existsByNamehs(String namehs) {
        return rHSkills.existsByNamehs(namehs);
    }
    
    
}
