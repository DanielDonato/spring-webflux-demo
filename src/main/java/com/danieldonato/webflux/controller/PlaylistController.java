package com.danieldonato.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danieldonato.webflux.documents.Playlist;
import com.danieldonato.webflux.services.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/playlist")
public class PlaylistController {
	
	@Autowired
	private PlaylistService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Flux<Playlist>> findAll(){
		Flux<Playlist> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Mono<Playlist>> findById(@PathVariable String id){
		Mono<Playlist> obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Mono<Playlist>> save(@RequestBody Playlist obj){
		Mono<Playlist> mono = service.save(obj);
		return ResponseEntity.created(null).body(mono);
	}
}
