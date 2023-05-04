/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.miportfolio.portfolio.Interface;

import com.miportfolio.portfolio.Entity.Persona;
import java.util.List;

/**
 *
 * @author karen
 */
public interface IPersonaServis {
    //traer una lista de personas
    public List<Persona> getPersona();
    
    //guarder un objeto de tipo persona
    public void savePersona(Persona persona);
    
    //eliminar un objeto pero lo buscamos por id
    public void deletePersona(Long id);
    
    //buscar a una persona por id 
    public Persona findPersona(Long id);
    
}
