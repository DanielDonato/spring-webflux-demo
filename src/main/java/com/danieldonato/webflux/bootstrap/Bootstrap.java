package com.danieldonato.webflux.bootstrap;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.danieldonato.webflux.documents.Playlist;
import com.danieldonato.webflux.repository.PlaylistRepository;

import reactor.core.publisher.Flux;

@Component
public class Bootstrap implements CommandLineRunner {

	@Autowired
	private PlaylistRepository playlistRepository;

	@Override
	public void run(String... args) throws Exception {
		
		playlistRepository.deleteAll()
				.thenMany(Flux.just("Just It", "Sertanejo", "Rock Nacional")
						.map(x -> new Playlist(UUID.randomUUID().toString(), x)).flatMap(playlistRepository::save))
				.subscribe(System.out::println);
		
	}

}
