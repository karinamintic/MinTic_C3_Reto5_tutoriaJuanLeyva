package com.retos.mireto4.Web;

import java.util.List;
import java.util.Optional;

import com.retos.mireto4.Modelo.Patineta;
import com.retos.mireto4.Servicios.PatinetaServicios;

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

@RestController
@RequestMapping("/api/Skate")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PatinetaWeb
{
    @GetMapping("/holaMundo")
    public String saludad(){
    return "Hola Mundo miReto";
    }

    @Autowired
    private PatinetaServicios servicio;
    @GetMapping("all")
    public List <Patineta> getSkate(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Patineta> getSkate(@PathVariable("id") int idSkate) {
        return servicio.getSkate(idSkate);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Patineta save(@RequestBody Patineta skate) {
        return servicio.save(skate);
    }

     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Patineta update(@RequestBody Patineta skate) {
        return servicio.update(skate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int skateId) {
        return servicio.deleteSkate(skateId);
    }

}
