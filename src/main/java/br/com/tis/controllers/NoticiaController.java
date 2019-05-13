package br.com.tis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/noticias")
public class NoticiaController{
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView noticias() {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("noticias");
        return modelAndView;
	}
}
