package com.universae.es.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reservas")
@Getter
@Setter
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;   
    
    private String nombre;
    
    private LocalDate dia;
    
    private LocalTime horaInicio;
    
    private LocalTime horaFin;
    
    

}


