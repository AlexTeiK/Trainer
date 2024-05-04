package com.universae.es.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.universae.es.dto.LoginDto;
import com.universae.es.dto.UsuarioDto;
import com.universae.es.entities.Usuario;
//import com.universae.es.entities.Usuario;
//import com.universae.es.repository.UsuarioRepository;
import com.universae.es.repository.UsuarioRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
@RequestMapping("/login")
@CrossOrigin
@SessionAttributes("usuario")
public class LoginMVCController {

	private static Logger log = LoggerFactory.getLogger(LoginMVCController.class);

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping()
	public String getLoginPage(Model model) {

		log.info("Entro en el metodo getLogin");

		model.addAttribute("login", new LoginDto());

		UsuarioDto usuario = new UsuarioDto();
		model.addAttribute("usuario", usuario);

		log.info("Salgo del metodo getLogin");

		return "login";
	}
	
	@PostMapping()
	public String login(@RequestBody LoginDto dto, @ModelAttribute("usuario") UsuarioDto usuario) {

		System.out.println("Ha intentado loggearse: " + dto.getUsername());
		Usuario user = usuarioRepository.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());

		if (user != null) {
			usuario.setUsername(dto.getUsername());
			usuario.setLastLogin(LocalDateTime.now());
			return "redirect:/reserva";
		} else {
			System.out.println("Inicio de sesion fallido. Usuario o contraseña erronea.");
			return "login";
		}
	}

//	@PostMapping()
//	public String login(@RequestBody LoginDto dto, @ModelAttribute("usuario") UsuarioDto usuario) {
//
//		System.out.println("ha intentando loggearse: " + dto.getUsername());
//
//		// ahora con esos datos hay que crear el loginservice y loginrepository y la
//		// entidad usuario de bbdd
//
//		String pw = "pw";
//
//		if (dto.getPassword().equals(pw)) {
//
//			usuario.setUsername(dto.getUsername());
//			usuario.setLastLogin(LocalDateTime.now());
//
//			return "redirect:/reserva";
//
//		} else {
//
//			// en algun sitio meterias el mensaje de pw incorrecto y lo muestras
//
//			return "login";
//		}
//
//	}

	@GetMapping("/logout")
	public String logOut(@ModelAttribute("usuario") UsuarioDto usuario) {

		usuario = null;

		return "redirect:login";
	}

}
