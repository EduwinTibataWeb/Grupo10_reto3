/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Grupo10.Repositorio;
import com.demo.Grupo10.Modelo.Client;
import com.demo.Grupo10.Modelo.DTOs.CountClient;
import com.demo.Grupo10.Modelo.Reservation;
import com.demo.Grupo10.Repositorio.crud.ReservationCrudRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Eduwin Tibata
 */
@Repository
public class ReservationRepositorio {
    @Autowired
    private ReservationCrudRepositorio reservationCrudRepositorio;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepositorio.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepositorio.findById(id);
    }
    
    public Reservation save(Reservation p){
        return reservationCrudRepositorio.save(p);
    }
    
    public void delete(Reservation c){
        reservationCrudRepositorio.delete(c);
    }
    
    //Reto 5
    public List<CountClient> getClientesTop(){
        List<CountClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = reservationCrudRepositorio.countTotalReservationsByClient();
        for(int i = 0; i < reporte.size(); i++){
            respuesta.add(new CountClient((Long)reporte.get(i)[1],(Client) reporte.get(i)[0]));
        }
        return respuesta;
    }
    
    public List<Reservation> getReservationsBetweenDates(Date a, Date b){
        return reservationCrudRepositorio.findAllByStartDateAfterAndStartDateBefore(a, b);
    }
    
    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepositorio.findAllByStatus(status);
    }
    
}
