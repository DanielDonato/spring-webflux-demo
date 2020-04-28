package com.danieldonato.webflux.services;

import com.danieldonato.webflux.documents.Playlist;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaylistService {
	
	Flux<Playlist> findAll(); //varios
	
	Mono<Playlist> findById(String id); //0 ou 1 elemento
	
	Mono<Playlist> save(Playlist playlist);
	
}
