/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Grupo10.Servicio;
import com.demo.Grupo10.Modelo.Message;
import com.demo.Grupo10.Repositorio.MessageRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduwin Tibata
 */
@Service
public class MessageServicio {
    @Autowired
    private MessageRepositorio messageRepositorio;
    
    public List<Message> getAll(){
        return messageRepositorio.getAll();
    }
    
    public Optional<Message> getMessage(int id){
        return messageRepositorio.getMessage(id);
    }
    
    public Message save(Message p){
        if(p.getIdMessage()==null){
            return messageRepositorio.save(p);
        }else{
            Optional<Message> caux=messageRepositorio.getMessage(p.getIdMessage());
            if(caux.isEmpty()){
                return messageRepositorio.save(p);
            }else{
                return p;
            }
        }
    }
}
