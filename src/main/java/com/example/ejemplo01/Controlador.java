package com.example.ejemplo01;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class Controlador {
    @Autowired
    PersonaService service;
    
    @GetMapping("/personas")
    public List<Persona> listar(){
        return service.listar();
    }
    
    @PostMapping("/personas")
    public Persona agregar(@RequestBody Persona p){
        return service.agregar(p);
    }
    
    @GetMapping(path={"personas/{id}"})
    public Persona listarId(@PathVariable("id") int id){
        return service.listarId(id);
    }
    
    @PutMapping(path={"personas/{id}"})
    public Persona editar(@RequestBody Persona p, @PathVariable("id") int id){
        p.setId(id);
        return service.editar(p);
    }
    
    @DeleteMapping(path={"personas/{id}"})
    public Persona delete(@PathVariable("id") int id){
        return service.eliminar(id);
    }
}
