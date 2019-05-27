package br.com.tis.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tis.domain.Feed;
import br.com.tis.domain.Role;
import br.com.tis.domain.User;
import br.com.tis.repositories.FeedRepository;

@Service("feedService")
public class FeedService {
	
	@Autowired
	private FeedRepository repository;
	
	public List<Feed> findAll() {
		return repository.findAll();
	}
	
	public void save(Feed feed) {
		repository.save(feed);
    }
	
//	public void delete(Long id) {
//		repository.deleteById(id);
//	}
}