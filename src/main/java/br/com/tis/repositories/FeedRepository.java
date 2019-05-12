package br.com.tis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tis.domain.Feed;


@Repository
public interface FeedRepository extends JpaRepository<Feed, Long> { }