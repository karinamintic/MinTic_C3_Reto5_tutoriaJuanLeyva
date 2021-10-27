package com.retos.mireto4.Servicios;

import java.util.List;
import java.util.Optional;

import com.retos.mireto4.Modelo.Patineta;
import com.retos.mireto4.Repositorio.PatinetaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatinetaServicios
{
    @Autowired
    private PatinetaRepositorio metodosCrud;

    public List<Patineta> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Patineta> getSkate(int idSkate){
        return metodosCrud.getSkate(idSkate);
    }

    public Patineta save(Patineta skate){
        if(skate.getId()==null){
            return metodosCrud.save(skate);
        }else{
            Optional<Patineta> evt=metodosCrud.getSkate(skate.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(skate);
            }else{
                return skate;
            }
        }
    }

    public Patineta update(Patineta skate){
        if(skate.getId()!=null){
            Optional<Patineta> e=metodosCrud.getSkate(skate.getId());
            if(!e.isEmpty()){
                if(skate.getName()!=null){
                    e.get().setName(skate.getName());
                }
                if(skate.getBrand()!=null){
                    e.get().setBrand(skate.getBrand());
                }
                if(skate.getYear()!=null){
                    e.get().setYear(skate.getYear());
                }
                if(skate.getDescription()!=null){
                    e.get().setDescription(skate.getDescription());
                }
                if(skate.getCategory()!=null){
                    e.get().setCategory(skate.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return skate;
            }
        }else{
            return skate;
        }
    }


    public boolean deleteSkate(int skateId) {
        Boolean aBoolean = getSkate(skateId).map(skate -> {
            metodosCrud.delete(skate);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
