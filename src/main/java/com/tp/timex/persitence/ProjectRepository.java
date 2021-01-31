package com.tp.timex.persitence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.tp.timex.persitence.documents.Project;

public interface ProjectRepository extends ReactiveCrudRepository<Project, String> {
//	Flux<StempActivity> findAllByUserId(String userId);
}
