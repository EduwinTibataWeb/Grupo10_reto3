/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Grupo10.Controlador;

import com.demo.Grupo10.Modelo.Costume;
import com.demo.Grupo10.Servicio.CostumeServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Eduwin Tibatá
 */
@RestController
@RequestMapping("/api/Costume")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CostumeControlador {
    @Autowired
    private CostumeServicio costumeServicio;
    
    @GetMapping("/all")
    public List<Costume> getCostumes(){
        return costumeServicio.getAll();
    }
    
    @GetMapping("/{Id}")
    public Optional<Costume> getCostume(@PathVariable("Id") int id){
        return costumeServicio.getCostume(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume save(@RequestBody Costume p){
        return costumeServicio.save(p);
    }
}
