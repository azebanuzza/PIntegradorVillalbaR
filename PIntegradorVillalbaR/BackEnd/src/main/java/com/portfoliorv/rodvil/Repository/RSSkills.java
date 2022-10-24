
package com.portfoliorv.rodvil.Repository;

import com.portfoliorv.rodvil.Entity.SSkills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RSSkills extends JpaRepository<SSkills, Integer> {
    public Optional <SSkills> findByNamess (String namess);
    
    public boolean existsByNamess(String namess);
}
