package com.tp.timex.persitence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.tp.timex.persitence.documents.User;

public interface UserRepository extends ReactiveCrudRepository<User, String> {
//	Flux<StempActivity> findAllByUserId(String userId);
}
