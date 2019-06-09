package br.com.tis.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.tis.domain.Feed;
import br.com.tis.services.FeedService;

@Controller
public class FeedController{
	
	@Autowired
	private FeedService service;
	
	@GetMapping("noticias")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("noticias");
		mv.addObject("feeds", service.findAll());
		
		return mv;
}

	@GetMapping("/add")
	public ModelAndView add(Feed feed) {

		ModelAndView mv = new ModelAndView("/feedAdd");
		mv.addObject("feed", feed);

		return mv;
	}

	@GetMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") Long id) {
		service.delete(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/noticias");

		return redirectView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String save(@Valid Feed feed, BindingResult result) {
		ModelAndView mv = new ModelAndView("/feedAdd");
		mv.addObject("feed", feed);

		if (result.hasErrors()) {
			return "redirect:noticias";
		}
		service.save(feed);
		return "redirect:noticias";
	}
}
