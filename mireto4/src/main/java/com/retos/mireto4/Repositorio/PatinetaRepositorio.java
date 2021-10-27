package com.retos.mireto4.Repositorio;

import java.util.List;
import java.util.Optional;

import com.retos.mireto4.Interface.PatinetaInterface;
import com.retos.mireto4.Modelo.Patineta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PatinetaRepositorio
{
    @Autowired
    private PatinetaInterface crud;

    public List<Patineta> getAll(){
        return (List<Patineta>) crud.findAll();
    }

    public Optional <Patineta> getSkate(int id){
        return crud.findById(id);
    }

    public Patineta save(Patineta skate){
        return crud.save(skate);
    }
     public void delete(Patineta skate){
        crud.delete(skate);
    }

}
