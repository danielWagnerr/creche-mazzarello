package br.com.tis.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.tis.domain.Feed;
import br.com.tis.services.FeedService;

@RestController
public class FeedController {

	@Autowired
	private FeedService service;

	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public ModelAndView findAll() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("feed");
		return modelAndView;
	}

	@GetMapping("/add")
	public ModelAndView add(Feed feed) {

		ModelAndView mv = new ModelAndView("/feedAdd");
		mv.addObject("feed", feed);

		return mv;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {

		service.delete(id);

		return findAll();
	}

	@PostMapping("/newPost")
	public RedirectView save(@Valid Feed feed, BindingResult result) {
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("localhost:8080/noticias");

		if (result.hasErrors()) {
			System.out.println(feed);
			System.out.println("DEU MERDA AQUUI");
			return redirectView;
		}
			

		service.save(feed);
	    return redirectView;
	}

}
