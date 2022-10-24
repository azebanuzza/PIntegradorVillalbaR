
package com.portfoliorv.rodvil.Repository;

import com.portfoliorv.rodvil.Entity.Languages;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RLanguage extends JpaRepository <Languages, Integer> {
    public Optional<Languages> findByName (String name);
    public boolean existsByName(String name);
}
