package com.tp.timex.persitence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.tp.timex.persitence.documents.StempActivity;

import reactor.core.publisher.Flux;

public interface StempActivityRepository extends ReactiveCrudRepository<StempActivity, String> {
	Flux<StempActivity> findAllByUserId(String userId);
}
