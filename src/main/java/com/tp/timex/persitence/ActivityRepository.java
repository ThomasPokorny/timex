package com.tp.timex.persitence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.tp.timex.persitence.documents.Activity;

import reactor.core.publisher.Flux;

@Repository
public interface ActivityRepository extends ReactiveCrudRepository<Activity, String> {
 
    Flux<Activity> findAllByUserId(String userId);
    //Mono<Activity> findFirstByOwner(Mono<String> owner);
}