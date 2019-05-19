package br.com.tis.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class FeedController {

	@Autowired
	private FeedService service;

	//	@RequestMapping(method = RequestMethod.GET)
	//	public ModelAndView findAll() {
	//		ModelAndView modelAndView = new ModelAndView();
	//		modelAndView.setViewName("feed");
	//		return modelAndView;
	//}

	@GetMapping("/add")
	public ModelAndView add(Feed feed) {

		ModelAndView mv = new ModelAndView("/feedAdd");
		mv.addObject("feed", feed);

		return mv;
	}

//	@GetMapping("/delete/{id}")
//	public RedirectView delete(@PathVariable("id") Long id) {
//		RedirectView redirectView = new RedirectView();
//		redirectView.setUrl("localhost:8080/noticias");
//		service.delete(id);
//
//		return redirectView;
//	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView save(@Valid Feed feed, BindingResult result) {
		ModelAndView mv = new ModelAndView("/feedAdd");
		mv.addObject("feed", feed);

		if (result.hasErrors()) {
			System.out.println("deu merda");
			return mv;
		}
		service.save(feed);
		return mv;
	}
}
