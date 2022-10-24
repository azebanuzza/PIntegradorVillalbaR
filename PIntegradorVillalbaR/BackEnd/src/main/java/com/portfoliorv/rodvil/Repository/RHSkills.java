
package com.portfoliorv.rodvil.Repository;

import com.portfoliorv.rodvil.Entity.HSkills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHSkills extends JpaRepository<HSkills, Integer> {
    public Optional <HSkills> findByNamehs (String namehs);
    
    public boolean existsByNamehs(String namehs);
}
