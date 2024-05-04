package com.universae.es.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universae.es.dto.CreateReservaDto;
import com.universae.es.dto.ReservaDto;
import com.universae.es.service.ReservaService;

@RestController
@RequestMapping("/api/reserva")
@CrossOrigin
public class ReservaApiRestController {

    @Autowired
    private ReservaService reservaService; 

    @GetMapping
    public ResponseEntity<List<ReservaDto>> getAllReservas() {
        List<ReservaDto> reservas = reservaService.getAllReservas();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDto> getReservaById(@PathVariable int id) {
        ReservaDto reserva = reservaService.getReservaById(id);
        return new ResponseEntity<>(reserva, reserva != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ReservaDto> createReserva(@RequestBody @Valid CreateReservaDto reserva) {
    	ReservaDto createdReserva = reservaService.createReserva(reserva);
        return new ResponseEntity<>(createdReserva, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDto> updateReserva(@PathVariable int id, @RequestBody ReservaDto reserva) {
    	ReservaDto updatedReserva = reservaService.updateReserva(id, reserva);
        return new ResponseEntity<>(updatedReserva, updatedReserva != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable int id) {
        reservaService.deleteReserva(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
