
package com.portfoliorv.rodvil.Security.Service;

import com.portfoliorv.rodvil.Security.Entity.Rol;
import com.portfoliorv.rodvil.Security.Enums.RolNombre;
import com.portfoliorv.rodvil.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional //Mantiene la persistencia entre esto y la base de datos
public class RolService {
    
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
