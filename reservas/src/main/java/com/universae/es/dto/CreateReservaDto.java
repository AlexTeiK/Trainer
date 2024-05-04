package com.universae.es.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReservaDto {
   
	@NotEmpty
    private String nombre;   
  
	@NotEmpty
    private LocalDateTime fechaHoraInicio;
    
	@NotEmpty
    private LocalDateTime fechaHoraFin;    
    
     
}


