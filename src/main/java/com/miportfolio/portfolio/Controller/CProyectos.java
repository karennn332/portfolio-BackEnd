
package com.miportfolio.portfolio.Controller;

import com.miportfolio.portfolio.Dto.dtoProyectos;
import com.miportfolio.portfolio.Entity.Proyectos;
import com.miportfolio.portfolio.Security.Controller.Mensaje;
import com.miportfolio.portfolio.Service.Sproyectos;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "https://frontendkd-1523f.web.app")
public class CProyectos {
   @Autowired
   Sproyectos sProyectos;
   
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        
        Proyectos experiencia = sProyectos.getOne(id).get();
        
        return new ResponseEntity(experiencia,HttpStatus.OK);
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoexp){
        if(StringUtils.isBlank(dtoexp.getNombreP()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sProyectos.existsByNombreP(dtoexp.getNombreP()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = new Proyectos(dtoexp.getNombreP(), dtoexp.getDescripcionP());
        sProyectos.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyectos agregada "), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyectos){
        //validamos si esxiste el id
        if(!sProyectos.existsById(id))
          return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);   
        
        //Compara nombre de experiencia
        if(sProyectos.existsByNombreP(dtoproyectos.getNombreP()) && sProyectos.getByNombreP(dtoproyectos.getNombreP()).get().getId() != id)
             return new ResponseEntity(new Mensaje("Esa nombre proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
        //no puede estar vacio el campo 
        if(StringUtils.isBlank(dtoproyectos.getNombreP()))
             return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = sProyectos.getOne(id).get();
        proyectos.setNombreP(dtoproyectos.getNombreP());
        proyectos.setDescripcionP((dtoproyectos.getDescripcionP()));
        
        sProyectos.save(proyectos);
         return new ResponseEntity(new Mensaje("Proyectos actualizada"), HttpStatus.OK);
    }
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
}
