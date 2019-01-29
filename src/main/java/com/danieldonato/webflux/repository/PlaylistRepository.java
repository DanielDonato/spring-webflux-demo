package com.danieldonato.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.danieldonato.webflux.documents.Playlist;

@Repository
public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {

}
