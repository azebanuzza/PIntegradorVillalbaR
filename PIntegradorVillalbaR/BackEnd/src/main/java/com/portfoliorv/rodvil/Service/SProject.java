
package com.portfoliorv.rodvil.Service;

import com.portfoliorv.rodvil.Entity.Project;
import com.portfoliorv.rodvil.Repository.RProject;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProject {
    @Autowired
    RProject rProject;
    
    public List<Project> list() {
        return rProject.findAll();
    }
    
    public Optional<Project> getOne(int id) {
        return rProject.findById(id);
    }
    
    public Optional<Project> getByProName(String proName) {
        return rProject.findByProName(proName);
    }
    
    public void save (Project pro) {
        rProject.save(pro);
    }
    
    public void delete (int id) {
        rProject.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return rProject.existsById(id);
    }
    
    public boolean existsByProName(String proName) {
        return rProject.existsByProName(proName);
    }
}
