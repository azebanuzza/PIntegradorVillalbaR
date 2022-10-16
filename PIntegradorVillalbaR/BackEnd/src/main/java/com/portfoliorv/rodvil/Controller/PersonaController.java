
package com.portfoliorv.rodvil.Controller;

import com.portfoliorv.rodvil.Dto.dtoPersona;
import com.portfoliorv.rodvil.Entity.Persona;
import com.portfoliorv.rodvil.Security.Controller.Mensaje;
import com.portfoliorv.rodvil.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RequestMapping ("/personas")
@RestController
public class PersonaController {
@Autowired
    ImpPersonaService iPersonaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = iPersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!iPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existen datos."), HttpStatus.NOT_FOUND);
        }
        Persona experiencia = iPersonaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    /*@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona) {
        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        if (iPersonaService.existsByNombre(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa ID de persona ya existe."), HttpStatus.BAD_REQUEST);
        }

        Persona experiencia = new Persona(dtopersona.getNombre(), dtopersona.getDescripcion());
        iPersonaService.save(experiencia);

        return new ResponseEntity(new Mensaje("Persona agregada."), HttpStatus.OK);
    }*/

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona) {

        //Valida si existe el ID
        if (!iPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        //Compara nombres de item experiencia
        if (iPersonaService.existsByNombre(dtopersona.getNombre()) && iPersonaService.getByNombreExp(dtopersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa ID de persona ya existe."), HttpStatus.BAD_REQUEST);
        }

        //El campo no puede estar vacío
        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco."), HttpStatus.BAD_REQUEST);
        }

        Persona persona = iPersonaService.getOne(id).get();
        //Busca el nombre del dto y lo setea al objeto nombreexp
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setAboutme(dtopersona.getAboutme());
        persona.setImg(dtopersona.getImg());

        iPersonaService.save(persona);
        return new ResponseEntity(new Mensaje("Información de persona actualizada."), HttpStatus.OK);
    }

    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validar que el ID exista
        if (!iPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }

        iPersonaService.delete(id);

        return new ResponseEntity(new Mensaje("El item 'persona' fue borrado."), HttpStatus.OK);
    }*/
}
