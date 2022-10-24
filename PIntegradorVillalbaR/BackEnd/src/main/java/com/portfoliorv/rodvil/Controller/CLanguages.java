
package com.portfoliorv.rodvil.Controller;

import com.portfoliorv.rodvil.Dto.dtoLanguages;
import com.portfoliorv.rodvil.Entity.Languages;
import com.portfoliorv.rodvil.Security.Controller.Mensaje;
import com.portfoliorv.rodvil.Service.SLanguages;
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
@RequestMapping("/lang")
@CrossOrigin(origins = "http://localhost:4200")
public class CLanguages {
    @Autowired
    SLanguages sLanguages;
            
    @GetMapping("/lista")
    public ResponseEntity<List<Languages>> list() {
        List<Languages> list = sLanguages.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Languages> getById(@PathVariable("id") int id) {
        if (!sLanguages.existsById(id)) {
            return new ResponseEntity(new Mensaje("El lenguaje no existe."), HttpStatus.NOT_FOUND);
        }
        Languages languages = sLanguages.getOne(id).get();
        return new ResponseEntity(languages, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoLanguages dtolang) {
        if (StringUtils.isBlank(dtolang.getName())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        if (sLanguages.existsByName(dtolang.getName())) {
            return new ResponseEntity(new Mensaje("Ese lenguaje ya existe."), HttpStatus.BAD_REQUEST);
        }

        Languages languages = new Languages(dtolang.getName(), dtolang.getNivel(), dtolang.getDescription(), dtolang.getImgLang(), dtolang.getAltImg());
        sLanguages.save(languages);

        return new ResponseEntity(new Mensaje("Lenguaje agregado."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoLanguages dtolang) {

        //Valida si existe el ID
        if (!sLanguages.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        //Compara nombres de ítem educación
        if (sLanguages.existsByName(dtolang.getName()) && sLanguages.getByName(dtolang.getName()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese lenguaje ya existe."), HttpStatus.BAD_REQUEST);
        }

        //El campo no puede estar vacío
        if (StringUtils.isBlank(dtolang.getName())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco."), HttpStatus.BAD_REQUEST);
        }

        Languages languages = sLanguages.getOne(id).get();
        //Busca el nombre del dto y lo setea al objeto name
        languages.setName(dtolang.getName());
        languages.setNivel(dtolang.getNivel());
        languages.setDescription(dtolang.getDescription());
        languages.setImgLang(dtolang.getImgLang());
        languages.setAltImg(dtolang.getAltImg());

        sLanguages.save(languages);
        return new ResponseEntity(new Mensaje("Lenguaje actualizado."), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validar que el ID exista
        if (!sLanguages.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }

        sLanguages.delete(id);

        return new ResponseEntity(new Mensaje("El item 'lenguaje' fue borrado."), HttpStatus.OK);
    }
}
