
package com.portfoliorv.rodvil.Controller;

import com.portfoliorv.rodvil.Dto.dtoSSkills;
import com.portfoliorv.rodvil.Entity.SSkills;
import com.portfoliorv.rodvil.Security.Controller.Mensaje;
import com.portfoliorv.rodvil.Service.SSSkills;
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
@RequestMapping("/sskills")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfolio-rv.web.app")
public class CSSkills {
    @Autowired
    SSSkills sSSkills;
            
     @GetMapping("/lista")
    public ResponseEntity<List<SSkills>> list() {
        List<SSkills> list = sSSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<SSkills> getById(@PathVariable("id") int id) {
        if (!sSSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("La soft skill no existe."), HttpStatus.NOT_FOUND);
        }
        SSkills sskills = sSSkills.getOne(id).get();
        return new ResponseEntity(sskills, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSSkills dtosskills) {
        if (StringUtils.isBlank(dtosskills.getNamess())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        if (sSSkills.existsByNamess(dtosskills.getNamess())) {
            return new ResponseEntity(new Mensaje("Esa soft skill ya existe."), HttpStatus.BAD_REQUEST);
        }

        SSkills hskill = new SSkills(dtosskills.getNamess(), dtosskills.getPercentage(), dtosskills.getIcon(), dtosskills.getColor());
        sSSkills.save(hskill);

        return new ResponseEntity(new Mensaje("Habilidad agregada."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSSkills dtosskills) {

        //Valida si existe el ID
        if (!sSSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        //Compara nombres de item sskills
        if (sSSkills.existsByNamess(dtosskills.getNamess()) && sSSkills.getByNamess(dtosskills.getNamess()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa soft skill ya existe."), HttpStatus.BAD_REQUEST);
        }

        //El campo no puede estar vacío
        if (StringUtils.isBlank(dtosskills.getNamess())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco."), HttpStatus.BAD_REQUEST);
        }

        SSkills sskills = sSSkills.getOne(id).get();
        //Busca el nombre del dto y lo setea al objeto nombreexp
        sskills.setNamess(dtosskills.getNamess());
        sskills.setPercentage(dtosskills.getPercentage());
        sskills.setIcon(dtosskills.getIcon());
        sskills.setColor(dtosskills.getColor());

        sSSkills.save(sskills);
        return new ResponseEntity(new Mensaje("Hard skill actualizada."), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validar que el ID exista
        if (!sSSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }

        sSSkills.delete(id);

        return new ResponseEntity(new Mensaje("El item de tipo 'soft skill' fue borrado."), HttpStatus.OK);
    }       
    
}
