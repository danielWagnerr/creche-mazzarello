package br.com.tis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/catequese")
public class CatequeseController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView catequese() {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("catequese");
        return modelAndView;
	}
	
	@RequestMapping(value = "/atividades", method = RequestMethod.GET)
	public ModelAndView atividades() {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("atividades-catequese");
        return modelAndView;
	}
}
