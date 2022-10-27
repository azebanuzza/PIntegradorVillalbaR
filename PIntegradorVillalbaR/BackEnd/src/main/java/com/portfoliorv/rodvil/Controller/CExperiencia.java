package com.portfoliorv.rodvil.Controller;

import com.portfoliorv.rodvil.Dto.dtoExperiencia;
import com.portfoliorv.rodvil.Entity.Experiencia;
import com.portfoliorv.rodvil.Security.Controller.Mensaje;
import com.portfoliorv.rodvil.Service.SExperiencia;
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
@RequestMapping("/explab")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfolio-rv.web.app")
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("La experiencia no existe."), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp) {
        if (StringUtils.isBlank(dtoexp.getTitulo())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        if (sExperiencia.existsByTitulo(dtoexp.getTitulo())) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe."), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(dtoexp.getTitulo(), dtoexp.getDescripcion(), dtoexp.getFecha(), dtoexp.getAlt(), dtoexp.getImg());
        sExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia agregada."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp) {

        //Valida si existe el ID
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        //Compara nombres de item experiencia
        if (sExperiencia.existsByTitulo(dtoexp.getTitulo()) && sExperiencia.getByTitulo(dtoexp.getTitulo()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe."), HttpStatus.BAD_REQUEST);
        }

        //El campo no puede estar vacío
        if (StringUtils.isBlank(dtoexp.getTitulo())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco."), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = sExperiencia.getOne(id).get();
        //Busca el nombre del dto y lo setea al objeto nombreexp
        experiencia.setTitulo(dtoexp.getTitulo());
        experiencia.setDescripcion(dtoexp.getDescripcion());
        experiencia.setFecha(dtoexp.getFecha());
        experiencia.setAlt(dtoexp.getAlt());
        experiencia.setImg(dtoexp.getImg());

        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada."), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validar que el ID exista
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }

        sExperiencia.delete(id);

        return new ResponseEntity(new Mensaje("El item 'experiencia' fue borrado."), HttpStatus.OK);
    }
}
