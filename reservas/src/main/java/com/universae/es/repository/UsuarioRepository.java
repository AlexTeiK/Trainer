/**package com.universae.es.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.universae.es.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
	
	@Query("SELECT COUNT(u) > 0 FROM Usuarios u WHERE u.password = :enteredPassword")
	boolean esUsuarioValido(@Param("enteredPassword") String contraseñaIngresada);
	
} */


