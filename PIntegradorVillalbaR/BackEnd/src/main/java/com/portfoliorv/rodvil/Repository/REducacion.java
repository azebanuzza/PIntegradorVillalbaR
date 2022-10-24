
package com.portfoliorv.rodvil.Repository;

import com.portfoliorv.rodvil.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByTituloEdu(String tituloEdu);
    
    public boolean existsByTituloEdu(String tituloEdu);
}
