
package com.miportfolio.portfolio.Service;

import com.miportfolio.portfolio.Entity.Proyectos;
import com.miportfolio.portfolio.Repository.Rproyectos;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Sproyectos {
    @Autowired
    Rproyectos rProyectos;
    
    public List<Proyectos> list(){
     return rProyectos.findAll();
 }
 
 public Optional<Proyectos> getOne(int id){
     return rProyectos.findById(id);
 }
 
     public Optional<Proyectos> getByNombreP(String nombreP){
             return rProyectos.findByNombreP(nombreP);
     }
     
     public void save(Proyectos proyectos) {
         rProyectos.save(proyectos);
     }
     
     public void delete(int id){
         rProyectos.deleteById(id);
     }
     
     public boolean existsById(int id) {
         return rProyectos.existsById(id);
     }
     
     public boolean existsByNombreP(String nombreP){
         return rProyectos.existsByNombreP(nombreP);
     }
}
