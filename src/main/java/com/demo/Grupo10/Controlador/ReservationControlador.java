/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Grupo10.Controlador;

import com.demo.Grupo10.Modelo.DTOs.CountClient;
import com.demo.Grupo10.Modelo.DTOs.CountStatus;
import com.demo.Grupo10.Modelo.Reservation;
import com.demo.Grupo10.Servicio.ReservationServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Eduwin Tibatá
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationControlador {
    @Autowired
    private ReservationServicio reservationServicio;
    
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationServicio.getAll();
    }
    
    @GetMapping("/{Id}")
    public Optional<Reservation> getMessage(@PathVariable("Id") int id){
        return reservationServicio.getReservation(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation p){
        return reservationServicio.save(p);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation p){
        return reservationServicio.update(p);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservationServicio.deleteReservation(id);
    }
    
    @GetMapping("/report-clients")
    public List<CountClient> getClientesTop(){
        return reservationServicio.getClientesTop();
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsBetweenDates(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return reservationServicio.getReservationsBetweenDates(dateOne, dateTwo);
    }
    
    @GetMapping("/report-status")
    public CountStatus getReportStatus(){
        return reservationServicio.getReservationsStatus();
    }
}
