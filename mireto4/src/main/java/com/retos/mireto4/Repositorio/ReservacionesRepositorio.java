package com.retos.mireto4.Repositorio;

import java.util.List;
import java.util.Optional;

import com.retos.mireto4.Interface.ReservacionesInterface;
import com.retos.mireto4.Modelo.Reservaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservacionesRepositorio
{
    @Autowired
    private ReservacionesInterface crud4;

    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) crud4.findAll();
    }
    public Optional<Reservaciones> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservaciones save(Reservaciones reservation){
        return crud4.save(reservation);
    }
     public void delete(Reservaciones reservacion){
        crud4.delete(reservacion);
    }
}
