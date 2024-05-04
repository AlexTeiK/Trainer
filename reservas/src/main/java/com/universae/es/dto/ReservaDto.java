package com.universae.es.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservaDto {
	
	private String id;
   
    private String nombre;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dia;
          
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime horaInicio;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime horaFin;
    
    @JsonIgnore
    private LocalDateTime fechaHoraInicio;
    @JsonIgnore
    private LocalDateTime fechaHoraFin;    
    
     
}


