/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Grupo10.Repositorio;


import com.demo.Grupo10.Modelo.Costume;
import com.demo.Grupo10.Repositorio.crud.CostumeCrudRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Eduwin Tibata
 */
@Repository
public class CostumeRepositorio {
    @Autowired
    private CostumeCrudRepositorio costumeCrudRepositorio;
    
    public List<Costume> getAll(){
        return (List<Costume>) costumeCrudRepositorio.findAll();
    }
    
    public Optional<Costume> getCostume(int id){
        return costumeCrudRepositorio.findById(id);
    }
    
    public Costume save(Costume p){
        return costumeCrudRepositorio.save(p);
    }
}
