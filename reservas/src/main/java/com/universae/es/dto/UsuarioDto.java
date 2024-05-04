package com.universae.es.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {
		
	private String username;
	
	private LocalDateTime lastLogin;
	
	

}
