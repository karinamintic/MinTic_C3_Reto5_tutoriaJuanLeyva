package com.retos.mireto4.Repositorio;

import java.util.List;
import java.util.Optional;

import com.retos.mireto4.Interface.CategoriaInterface;
import com.retos.mireto4.Modelo.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaRepositorio
{
    @Autowired
    private CategoriaInterface crud2;

     public List<Categoria> getAll(){
        return (List<Categoria>) crud2. findAll();
    }

    public Optional <Categoria> getCategoria(int id){
        return crud2.findById(id);
    }

    public Categoria save(Categoria categoria){
        return crud2.save(categoria);
    }
     public void delete(Categoria categoria){
        crud2.delete(categoria);
    }
}
