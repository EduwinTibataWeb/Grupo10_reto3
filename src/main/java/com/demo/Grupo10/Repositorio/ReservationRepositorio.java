/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Grupo10.Repositorio;
import com.demo.Grupo10.Modelo.Reservation;
import com.demo.Grupo10.Repositorio.crud.ReservationCrudRepositorio;
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
}
