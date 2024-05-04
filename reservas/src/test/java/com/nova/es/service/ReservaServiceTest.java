package com.nova.es.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.universae.es.service.ReservaService;

@SpringBootTest
class ReservaServiceTest {

	@Autowired
	ReservaService service;
	
	@Test
	void testGetAllReservas() {	
		
		assertNotNull(service.getAllReservas());

	}

}
