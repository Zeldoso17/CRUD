package com.example.ejemplo01;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImplement implements PersonaService{
    @Autowired
    private PersonaRepositorio repositorio;
    
    
    @Override
    public List<Persona> listar() {
        return repositorio.findAll();
    }

    @Override
    public Persona listarId(int id) {
        return repositorio.findById(id);
    }

    @Override
    public Persona agregar(Persona p) {
        return repositorio.save(p);
    }

    @Override
    public Persona editar(Persona p) {
        return repositorio.save(p);
    }

    @Override
    public Persona eliminar(int id) {
        Persona p = repositorio.findById(id);
        if(p != null){
            repositorio.delete(p);
        }
        return p;
    }
    
}
