/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Grupo10.Servicio;

import com.demo.Grupo10.Modelo.Reservation;
import com.demo.Grupo10.Repositorio.ReservationRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduwin Tibata
 */
@Service
public class ReservationServicio {
    @Autowired
    private ReservationRepositorio reservationRepositorio;
    
    public List<Reservation> getAll(){
        return reservationRepositorio.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationRepositorio.getReservation(id);
    }
    
    public Reservation save(Reservation p){
        if(p.getIdReservation()==null){
            return reservationRepositorio.save(p);
        }else{
            Optional<Reservation> caux=reservationRepositorio.getReservation(p.getIdReservation());
            if(caux.isEmpty()){
                return reservationRepositorio.save(p);
            }else{
                return p;
            }
        }
    }
    
    public Reservation update(Reservation c){
        if(c.getIdReservation()!=null){
            Optional<Reservation>g=reservationRepositorio.getReservation(c.getIdReservation());
            if(!g.isEmpty()){
                if(c.getStartDate()!=null){
                    g.get().setStartDate(c.getStartDate());
                }
                if(c.getDevolutionDate()!=null){
                    g.get().setDevolutionDate(c.getDevolutionDate());
                }
                if(c.getStatus()!=null){
                    g.get().setStatus(c.getStatus());
                }
                return reservationRepositorio.save(g.get());
            }
        }
        return c;
    }
    //Forma 2
    public boolean deleteReservation (int id){
        Boolean d = getReservation(id).map(reservation -> {
            reservationRepositorio.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }
}
