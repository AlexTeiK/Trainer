package com.universae.es.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universae.es.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
	
	public Usuario findByUsernameAndPassword(String username, String password);
	
} 


