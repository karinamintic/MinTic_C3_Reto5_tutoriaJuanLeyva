package com.retos.mireto4.Repositorio;

import java.util.List;
import java.util.Optional;

import com.retos.mireto4.Interface.ClienteInterface;
import com.retos.mireto4.Modelo.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepositorio
{
    @Autowired
    private ClienteInterface crud1;

    public List<Cliente> getAll(){
        return (List<Cliente>) crud1.findAll();
    }
    public Optional <Cliente> getCliente(int id){
        return crud1.findById(id);
    }
    public Cliente save(Cliente cliente){
        return crud1.save(cliente);
    }
     public void delete(Cliente cliente){
        crud1.delete(cliente);
    }
}
