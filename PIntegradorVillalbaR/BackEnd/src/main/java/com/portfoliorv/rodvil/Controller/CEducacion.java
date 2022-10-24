
package com.portfoliorv.rodvil.Controller;

import com.portfoliorv.rodvil.Dto.dtoEducacion;
import com.portfoliorv.rodvil.Entity.Educacion;
import com.portfoliorv.rodvil.Security.Controller.Mensaje;
import com.portfoliorv.rodvil.Service.SEducacion;
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
@RequestMapping("/educa")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    @Autowired
    SEducacion sEducacion;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("La educación no existe."), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu) {
        if (StringUtils.isBlank(dtoedu.getTituloEdu())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        if (sEducacion.existsByTituloEdu(dtoedu.getTituloEdu())) {
            return new ResponseEntity(new Mensaje("Esa educación ya existe."), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(dtoedu.getTituloEdu(), dtoedu.getDescripcionEdu(), dtoedu.getFechaEdu(), dtoedu.getAltImgEdu(), dtoedu.getImgEdu());
        sEducacion.save(educacion);

        return new ResponseEntity(new Mensaje("Educación agregada."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu) {

        //Valida si existe el ID
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        //Compara nombres de ítem educación
        if (sEducacion.existsByTituloEdu(dtoedu.getTituloEdu()) && sEducacion.getByTituloEdu(dtoedu.getTituloEdu()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa educación ya existe."), HttpStatus.BAD_REQUEST);
        }

        //El campo no puede estar vacío
        if (StringUtils.isBlank(dtoedu.getTituloEdu())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco."), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = sEducacion.getOne(id).get();
        //Busca el nombre del dto y lo setea al objeto tituloEdu
        educacion.setTituloEdu(dtoedu.getTituloEdu());
        educacion.setDescripcionEdu(dtoedu.getDescripcionEdu());
        educacion.setFechaEdu(dtoedu.getFechaEdu());
        educacion.setAltImgEdu(dtoedu.getAltImgEdu());
        educacion.setImgEdu(dtoedu.getImgEdu());

        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educación actualizada."), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validar que el ID exista
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }

        sEducacion.delete(id);

        return new ResponseEntity(new Mensaje("El item 'educación' fue borrado."), HttpStatus.OK);
    }
}
