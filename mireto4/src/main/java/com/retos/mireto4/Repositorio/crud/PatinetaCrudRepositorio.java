package com.retos.mireto4.Repositorio.crud;

import java.util.List;
import java.util.Date;

import com.retos.mireto4.Modelo.Patineta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PatinetaCrudRepositorio extends CrudRepository<Patineta,Integer>{

    //JPQL
    @Query("select c.categoria, COUNT(c.categoria) from Papeleria AS c group by c.categoria order by COUNT(c.categoria) desc")
    public List<Object[]> countTotalPapeleriaByCategoria();

    public List<Patineta> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);

    public List<Patineta> findAllByDescription(String description );

}
