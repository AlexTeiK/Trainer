package com.universae.es;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.universae.es.entities.Reserva;
import com.universae.es.entities.Usuario;
import com.universae.es.repository.ReservaRepository;
import com.universae.es.repository.UsuarioRepository;


@SpringBootApplication
@ComponentScan(basePackageClasses = PersonalTrainerAppReservas.class)
public class PersonalTrainerAppReservas{
	
	@Autowired
	private ReservaRepository repository;
	@Autowired
	private UsuarioRepository repository2;
	
	public static void main(String[] args) {
		SpringApplication.run(PersonalTrainerAppReservas.class, args);
		
	}
	
	
	@PostConstruct
	public void initData() {
		Reserva reserva = new Reserva();
		reserva.setNombre("Alfonso Garcia");
		reserva.setDia(LocalDate.now());
		reserva.setHoraInicio(LocalTime.now());
		reserva.setHoraFin(LocalTime.now().plusMinutes(90L));
		repository.save(reserva);	
		
		Usuario usuario = new Usuario();
		usuario.setUsername("Admin");
		usuario.setPassword("Admin");
		repository2.save(usuario);
		
	}
	

	
}

