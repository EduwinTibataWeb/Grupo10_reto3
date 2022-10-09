/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Grupo10.Repositorio;
import com.demo.Grupo10.Modelo.Message;
import com.demo.Grupo10.Repositorio.crud.MessageCrudRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Eduwin Tibata
 */
@Repository
public class MessageRepositorio {
    @Autowired
    private MessageCrudRepositorio messageCrudRepositorio;
    
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepositorio.findAll();
    }
    
    public Optional<Message> getMessage(int id){
        return messageCrudRepositorio.findById(id);
    }
    
    public Message save(Message p){
        return messageCrudRepositorio.save(p);
    }
}
