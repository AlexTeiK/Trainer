package com.universae.es.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universae.es.dto.CreateReservaDto;
import com.universae.es.dto.ReservaDto;
import com.universae.es.entities.Reserva;
import com.universae.es.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ReservaDto> getAllReservas() {
		List<Reserva> reservas = reservaRepository.findAll();
		return reservas.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public ReservaDto getReservaById(int id) {
		Optional<Reserva> optionalReserva = reservaRepository.findById(id);
		return optionalReserva.map(this::convertToDTO).orElse(null);
	}

	@Override
	public ReservaDto createReserva(ReservaDto reservaDTO) {
		
		Reserva reserva = convertToEntity(reservaDTO);
		
		boolean previas = reservaRepository.existsReservaEnHora(reservaDTO.getDia(), reservaDTO.getHoraInicio());
		
		if (!previas) {
			Reserva createdReserva = reservaRepository.save(reserva);
			return convertToDTO(createdReserva);
		}
		else {			
			return null;
		}
	}
	
	@Override
	public ReservaDto createReserva(CreateReservaDto reservaDTO) {
		
		Reserva reserva = new Reserva();
		reserva.setNombre(reservaDTO.getNombre());
		reserva.setDia(reservaDTO.getFechaHoraInicio().toLocalDate());
		reserva.setHoraInicio(reservaDTO.getFechaHoraInicio().toLocalTime());
		reserva.setHoraFin(reservaDTO.getFechaHoraFin().toLocalTime());
		
		boolean previas = reservaRepository.existsReservaEnHora(reserva.getDia(), reserva.getHoraInicio());
		
		if (!previas) {
			Reserva createdReserva = reservaRepository.save(reserva);
			return convertToDTO(createdReserva);
		}
		else {			
			return null;
		}	

	}

	@Override
	public ReservaDto updateReserva(int id, ReservaDto reservaDTO) {
		Optional<Reserva> optionalReserva = reservaRepository.findById(id);
		if (optionalReserva.isPresent()) {
			Reserva reserva = convertToEntity(reservaDTO);
			reserva.setId(id);
			Reserva updatedReserva = reservaRepository.save(reserva);
			return convertToDTO(updatedReserva);
		}
		return null;
	}

	@Override
	public void deleteReserva(int id) {
		reservaRepository.deleteById(id);
	}

	private ReservaDto convertToDTO(Reserva reserva) {
		return modelMapper.map(reserva, ReservaDto.class);
	}

	private Reserva convertToEntity(ReservaDto reservaDto) {
		return modelMapper.map(reservaDto, Reserva.class);
	}
}
