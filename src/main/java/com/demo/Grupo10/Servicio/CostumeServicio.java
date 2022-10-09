/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Grupo10.Servicio;

import com.demo.Grupo10.Modelo.Costume;
import com.demo.Grupo10.Repositorio.CostumeRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Eduwin Tibata
 */
@Service
public class CostumeServicio {
    @Autowired
    private CostumeRepositorio costumeRepositorio;
    
    public List<Costume> getAll(){
        return costumeRepositorio.getAll();
    }
    
    public Optional<Costume> getCostume(int id){
        return costumeRepositorio.getCostume(id);
    }
    
    public Costume save(Costume p){
        if(p.getId()==null){
            return costumeRepositorio.save(p);
        }else{
            Optional<Costume> caux=costumeRepositorio.getCostume(p.getId());
            if(caux.isEmpty()){
                return costumeRepositorio.save(p);
            }else{
                return p;
            }
        }
    }
}
