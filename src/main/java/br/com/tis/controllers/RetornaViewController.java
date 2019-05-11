package br.com.tis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class RetornaViewController{

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/criancas", method = RequestMethod.GET)
	public String criancas() {
		return "criancas";
	}
	
	@RequestMapping(value = "/agenda", method = RequestMethod.GET)
	public String store() {
		return "store";
	}
}
 	