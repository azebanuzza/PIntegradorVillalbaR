
package com.portfoliorv.rodvil.Security.Repository;

import com.portfoliorv.rodvil.Security.Entity.Rol;
import com.portfoliorv.rodvil.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Interfaz que llama de "Rol" y el id es un integer.
@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
