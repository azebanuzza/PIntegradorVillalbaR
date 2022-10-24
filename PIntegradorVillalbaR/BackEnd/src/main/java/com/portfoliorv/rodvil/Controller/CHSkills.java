
package com.portfoliorv.rodvil.Controller;

import com.portfoliorv.rodvil.Dto.dtoHSkills;
import com.portfoliorv.rodvil.Entity.HSkills;
import com.portfoliorv.rodvil.Security.Controller.Mensaje;
import com.portfoliorv.rodvil.Service.SHSkills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hskills")
@CrossOrigin(origins = "http://localhost:4200")
public class CHSkills {
    @Autowired
    SHSkills sHSkills;
            
     @GetMapping("/lista")
    public ResponseEntity<List<HSkills>> list() {
        List<HSkills> list = sHSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<HSkills> getById(@PathVariable("id") int id) {
        if (!sHSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("La hard skill no existe."), HttpStatus.NOT_FOUND);
        }
        HSkills hskills = sHSkills.getOne(id).get();
        return new ResponseEntity(hskills, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHSkills dtohskills) {
        if (StringUtils.isBlank(dtohskills.getNamehs())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        if (sHSkills.existsByNamehs(dtohskills.getNamehs())) {
            return new ResponseEntity(new Mensaje("Esa hard skill ya existe."), HttpStatus.BAD_REQUEST);
        }

        HSkills hskill = new HSkills(dtohskills.getNamehs(), dtohskills.getPercentage(), dtohskills.getIcon(), dtohskills.getColor());
        sHSkills.save(hskill);

        return new ResponseEntity(new Mensaje("Habilidad agregada."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHSkills dtohskills) {

        //Valida si existe el ID
        if (!sHSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        //Compara nombres de item hskills
        if (sHSkills.existsByNamehs(dtohskills.getNamehs()) && sHSkills.getByNamehs(dtohskills.getNamehs()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa hard skill ya existe."), HttpStatus.BAD_REQUEST);
        }

        //El campo no puede estar vacío
        if (StringUtils.isBlank(dtohskills.getNamehs())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco."), HttpStatus.BAD_REQUEST);
        }

        HSkills hskills = sHSkills.getOne(id).get();
        //Busca el nombre del dto y lo setea al objeto nombreexp
        hskills.setNamehs(dtohskills.getNamehs());
        hskills.setPercentage(dtohskills.getPercentage());
        hskills.setIcon(dtohskills.getIcon());
        hskills.setColor(dtohskills.getColor());

        sHSkills.save(hskills);
        return new ResponseEntity(new Mensaje("Hard skill actualizada."), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validar que el ID exista
        if (!sHSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }

        sHSkills.delete(id);

        return new ResponseEntity(new Mensaje("El item de tipo 'hard skill' fue borrado."), HttpStatus.OK);
    }       
    
}
