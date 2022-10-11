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
    
    public Client update(Client c){
        if(c.getIdClient()!=null){
            Optional<Client>g=clientRepositorio.getCliente(c.getIdClient());
            if(!g.isEmpty()){
                if(c.getName()!=null){
                    g.get().setName(c.getName());
                }
                if(c.getEmail()!=null){
                    g.get().setEmail(c.getEmail());
                }
                if(c.getPassword()!=null){
                    g.get().setPassword(c.getPassword());
                }
                if(c.getAge()!=null){
                    g.get().setAge(c.getAge());
                }
                return clientRepositorio.save(g.get());
            }
        }
        return c;
    }
    //Forma 2
    public boolean deleteClient(int id){
        Optional<Client> c=getCliente(id);
        if(!c.isEmpty()){
            clientRepositorio.delete(c.get());
            return true;
        }
        return false;
    }
}
