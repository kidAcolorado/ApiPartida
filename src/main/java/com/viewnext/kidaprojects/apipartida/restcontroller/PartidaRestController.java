package com.viewnext.kidaprojects.apipartida.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.kidaprojects.apipartida.service.PartidaService;

@RestController
public class PartidaRestController {

	@Autowired
	private PartidaService service;
}
