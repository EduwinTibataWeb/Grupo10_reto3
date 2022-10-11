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
    
    public Message update(Message c){
        if(c.getIdMessage()!=null){
            Optional<Message>g=messageRepositorio.getMessage(c.getIdMessage());
            if(!g.isEmpty()){
                if(c.getMessageText()!=null){
                    g.get().setMessageText(c.getMessageText());
                }
                
                return messageRepositorio.save(g.get());
            }
        }
        return c;
    }
    //Forma 2
    public boolean deleteMessage(int id){
        Optional<Message> c=getMessage(id);
        if(!c.isEmpty()){
            messageRepositorio.delete(c.get());
            return true;
        }
        return false;
    }
}
