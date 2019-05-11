package br.com.tis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tis.domain.Atividade;
import br.com.tis.services.TrabalhoService;

@RestController
@RequestMapping(value="/trabalhos")
public class TrabalhoController {
	
	@Autowired
	private TrabalhoService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String trabalhos() {
		return "RETORNAR PAGINA PRINCIPAL DOS TRABALHOS OFERECIDOS PELA CRECHE";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find (@PathVariable Integer id){
		Atividade trabalho = service.buscar(id);
		return ResponseEntity.ok(trabalho);
	}
}
