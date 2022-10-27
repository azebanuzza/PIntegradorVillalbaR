
package com.portfoliorv.rodvil.Controller;

import com.portfoliorv.rodvil.Dto.dtoProject;
import com.portfoliorv.rodvil.Entity.Project;
import com.portfoliorv.rodvil.Security.Controller.Mensaje;
import com.portfoliorv.rodvil.Service.SProject;
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
@RequestMapping("/project")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfolio-rv.web.app")
public class CProject {
    @Autowired
    SProject sProject;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Project>> list() {
        List<Project> list = sProject.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") int id) {
        if (!sProject.existsById(id)) {
            return new ResponseEntity(new Mensaje("El proyecto no existe."), HttpStatus.NOT_FOUND);
        }
        Project project = sProject.getOne(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProject dtopro) {
        if (StringUtils.isBlank(dtopro.getProName())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        if (sProject.existsByProName(dtopro.getProName())) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe."), HttpStatus.BAD_REQUEST);
        }

        Project project = new Project(dtopro.getProName(), dtopro.getProDescription(), dtopro.getProImg(), dtopro.getOpUrl(), dtopro.getAltImg(), dtopro.getRepository());
        sProject.save(project);

        return new ResponseEntity(new Mensaje("Proyecto agregado."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProject dtopro) {

        //Valida si existe el ID
        if (!sProject.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        //Compara nombres de item project
        if (sProject.existsByProName(dtopro.getProName()) && sProject.getByProName(dtopro.getProName()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe."), HttpStatus.BAD_REQUEST);
        }

        //El campo no puede estar vacío
        if (StringUtils.isBlank(dtopro.getProName())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco."), HttpStatus.BAD_REQUEST);
        }

        Project project = sProject.getOne(id).get();
        //Busca el nombre del dto y lo setea al objeto
        project.setProName(dtopro.getProName());
        project.setProDescription(dtopro.getProDescription());
        project.setProImg(dtopro.getProImg());
        project.setOpUrl(dtopro.getOpUrl());
        project.setAltImg(dtopro.getAltImg());
        project.setRepository(dtopro.getRepository());

        sProject.save(project);
        return new ResponseEntity(new Mensaje("Proyecto actualizado."), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validar que el ID exista
        if (!sProject.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }

        sProject.delete(id);

        return new ResponseEntity(new Mensaje("El item 'proyecto' fue borrado."), HttpStatus.OK);
    }
    
}
