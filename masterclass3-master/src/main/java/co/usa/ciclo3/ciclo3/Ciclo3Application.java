package co.usa.ciclo3.ciclo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"co.usa.ciclo3.ciclo3.model"})
@SpringBootApplication
public class Ciclo3Application {
//TODOS A SUBIR RETO 3, 4 y 5!!!
	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
	}

}
