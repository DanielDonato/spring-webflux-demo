package com.danieldonato.webflux.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danieldonato.webflux.documents.Playlist;
import com.danieldonato.webflux.services.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping(value = "/playlist")
public class PlaylistController {
	
	@Autowired
	private PlaylistService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public Flux<Playlist> findAll(){
		Flux<Playlist> obj = service.findAll();
		return obj;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Mono<Playlist> findById(@PathVariable String id){
		Mono<Playlist> obj = service.findById(id);
		return obj;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Mono<Playlist> save(@RequestBody Playlist obj){
		Mono<Playlist> mono = service.save(obj);
		return mono;
	}
	
	@GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Playlist>> getPlaylistByEvents() {
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
		Flux<Playlist> events = service.findAll();
		return Flux.zip(interval, events);
	}
}
