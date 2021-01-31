package com.tp.timex.persitence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.tp.timex.persitence.documents.Task;

public interface TaskRepository extends ReactiveCrudRepository<Task, String> {
//	Flux<StempActivity> findAllByUserId(String userId);
}
