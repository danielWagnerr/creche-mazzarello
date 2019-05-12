package br.com.tis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tis.domain.Feed;
import br.com.tis.repositories.FeedRepository;

@Service
public class FeedService {
	
	@Autowired
	private FeedRepository repository;
	
	public List<Feed> findAll() {
		return repository.findAll();
	}
	
	public Feed save(Feed feed) {
		return repository.saveAndFlush(feed);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
