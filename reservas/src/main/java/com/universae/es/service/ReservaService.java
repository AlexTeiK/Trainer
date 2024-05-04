package com.universae.es.service;

import java.util.List;

import com.universae.es.dto.CreateReservaDto;
import com.universae.es.dto.ReservaDto;

public interface ReservaService {

	List<ReservaDto> getAllReservas();

	ReservaDto getReservaById(int id);

	ReservaDto createReserva(ReservaDto reservaDTO);
	
	ReservaDto createReserva(CreateReservaDto reservaDTO);

	ReservaDto updateReserva(int id, ReservaDto reservaDTO);

	void deleteReserva(int id);

}