package com.danieldonato.webflux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danieldonato.webflux.documents.Playlist;
import com.danieldonato.webflux.repository.PlaylistRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired
	private PlaylistRepository repo;
	
	@Override
	public Flux<Playlist> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<Playlist> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public Mono<Playlist> save(Playlist playlist) {
		return repo.save(playlist);
	}

}
