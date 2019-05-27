//package br.com.tis.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import br.com.tis.services.FeedService;
//
//@Controller
//@RequestMapping(value = "/noticias")
//public class NoticiaController{
//	
//	@Autowired
//	private FeedService service;
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public ModelAndView noticias() {
//		ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("noticias");
//        modelAndView.addObject("feeds", service.findAll());
//        return modelAndView;
//	}
//}
