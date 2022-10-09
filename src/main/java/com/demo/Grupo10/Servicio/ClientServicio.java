/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Grupo10.Servicio;

import com.demo.Grupo10.Modelo.Client;
import com.demo.Grupo10.Repositorio.ClientRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduwin Tibata
 */
@Service
public class ClientServicio {
    
    @Autowired
    private ClientRepositorio clientRepositorio;
    
    public List<Client> getAll(){
        return clientRepositorio.getAll();
    }
    
    public Optional<Client> getCliente(int id){
        return clientRepositorio.getCliente(id);
    }
    
    public Client save(Client p){
        if(p.getIdClient()==null){
            return clientRepositorio.save(p);
        }else{
            Optional<Client> caux=clientRepositorio.getCliente(p.getIdClient());
            if(caux.isEmpty()){
                return clientRepositorio.save(p);
            }else{
                return p;
            }
        }
    }
}
