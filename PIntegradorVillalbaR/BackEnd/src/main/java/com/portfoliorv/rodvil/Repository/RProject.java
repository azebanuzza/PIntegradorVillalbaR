
package com.portfoliorv.rodvil.Repository;

import com.portfoliorv.rodvil.Entity.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProject extends JpaRepository<Project, Integer>{
    public Optional<Project> findByProName(String proName);
    
    public boolean existsByProName(String proName);
}
