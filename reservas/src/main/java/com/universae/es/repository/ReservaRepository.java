package com.universae.es.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.universae.es.entities.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
		
	@Query("SELECT COUNT(r) > 0 FROM Reserva r WHERE r.dia = :dia AND :hora BETWEEN r.horaInicio AND r.horaFin")
	boolean existsReservaEnHora(@Param("dia") LocalDate dia,@Param("hora") LocalTime hora);			
    
}
