/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Grupo10.Repositorio;

import com.demo.Grupo10.Modelo.Client;
import com.demo.Grupo10.Repositorio.crud.ClientCrudRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Eduwin Tibata
 */
@Repository
public class ClientRepositorio {
    
    @Autowired
    private ClientCrudRepositorio clientCrudRepositorio;
    
    public List<Client> getAll(){
        return (List<Client>) clientCrudRepositorio.findAll();
    }
    
    public Optional<Client> getCliente(int id){
        return clientCrudRepositorio.findById(id);
    }
    
    public Client save(Client p){
        return clientCrudRepositorio.save(p);
    }
    
    public void delete(Client c){
        clientCrudRepositorio.delete(c);
    }
    
}
