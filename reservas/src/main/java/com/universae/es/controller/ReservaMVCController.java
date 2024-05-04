package com.universae.es.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.universae.es.dto.ReservaDto;
import com.universae.es.dto.UsuarioDto;
import com.universae.es.service.ReservaService;

@Controller
@RequestMapping("/reserva")
@CrossOrigin
@SessionAttributes("usuario")
public class ReservaMVCController {

    @Autowired
    private ReservaService reservaService; 
    
    @Autowired
    private HttpSession session;

   
    @GetMapping
    public String getFormularioAltaReserva(Model model) {
    	    	
    	UsuarioDto user = (UsuarioDto) session.getAttribute("usuario");

    	if(user==null) {    		
    		 return "redirect:/login";
    	}   
    	
    	model.addAttribute("reserva",new ReservaDto());
    	
    	 List<ReservaDto> listaReservas = reservaService.getAllReservas();
         /*hago esto para adaptar la salida al objeto fullcalendar de js*/
         listaReservas.forEach(r->{
         	r.setFechaHoraInicio(r.getDia().atTime(r.getHoraInicio()));
         	r.setFechaHoraFin(r.getDia().atTime(r.getHoraFin()));
         });        
       
         model.addAttribute("listaReservas", listaReservas);
       
        return "reserva";
    }
    

    @GetMapping("/index")
    public String getIndex() {

        return "index";
    }
    
    @GetMapping("/all")
    public String mostrarListaReservas(Model model) {
    	
    	UsuarioDto user = (UsuarioDto) session.getAttribute("usuario");

    	if(user==null) {    		
    		 return "redirect:/login"; 
    	} 
    	
      
        List<ReservaDto> listaReservas = reservaService.getAllReservas();
        /*hago esto para adaptar la salida al objeto fullcalendar de js*/
        listaReservas.forEach(r->{
        	r.setFechaHoraInicio(r.getDia().atTime(r.getHoraInicio()));
        	r.setFechaHoraFin(r.getDia().atTime(r.getHoraFin()));
        });        
      
        model.addAttribute("listaReservas", listaReservas);

        return "calendario";
    }
    
    @PostMapping
    public String createReserva(ReservaDto reserva, RedirectAttributes redirectAttributes) {
    	   	    	    	
    	if(reservaService.createReserva(reserva)==null) {
    		redirectAttributes.addFlashAttribute("mensaje", "Esta hora no esta disponible");
    		  return "redirect:/reserva/all";
    	}else {
    		redirectAttributes.addFlashAttribute("mensaje", "Reserva creada exitosamente.");
    		  return "redirect:/reserva/all";
    	}
   
    }
    
    

}
