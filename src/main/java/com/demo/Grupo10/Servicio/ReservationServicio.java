/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Grupo10.Servicio;

import com.demo.Grupo10.Modelo.DTOs.CountClient;
import com.demo.Grupo10.Modelo.DTOs.CountStatus;
import com.demo.Grupo10.Modelo.Reservation;
import com.demo.Grupo10.Repositorio.ReservationRepositorio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    //Reto 5
    public List<CountClient> getClientesTop(){
        return reservationRepositorio.getClientesTop();
    }
    
    public List<Reservation> getReservationsBetweenDates(String dateA, String dateB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try{
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        }catch(ParseException error){
            error.printStackTrace();
        }
        if(a.before(b)){
            return reservationRepositorio.getReservationsBetweenDates(a, b);
        }else{
            return new ArrayList<>();
        }   
    }
    
    public CountStatus getReservationsStatus(){
        List<Reservation> reservasCompletadas = reservationRepositorio.getReservationsByStatus("completed");
        List<Reservation> reservasCanceladas = reservationRepositorio.getReservationsByStatus("cancelled");
        
        return new CountStatus((long) reservasCompletadas.size(),(long) reservasCanceladas.size());
    }
}
