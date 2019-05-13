package br.com.tis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/idosos")
public class IdososController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView idosos() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("idosos");
		return modelAndView;
	}
	
	@RequestMapping(value = "/atividades", method = RequestMethod.GET)
	public ModelAndView atividades() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("atividades-idosos");
		return modelAndView;
	}
}
