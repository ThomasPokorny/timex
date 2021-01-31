package com.tp.timex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.tp.timex.factory.MockUsers;
import com.tp.timex.persitence.UserRepository;
import com.tp.timex.persitence.documents.User;

import reactor.core.publisher.Flux;

@RestController
public class UserController {

	@Autowired UserRepository repository;
	
	@CrossOrigin()
	@GetMapping("/users")
	public Flux<User> getActivities(@RequestHeader("Authorization") String token) {
		String t = MockUsers.getUser(token);
		if(t == null) {
			throw new HttpUnauthorizedException();
		}
		return repository.findAll();
	}
}
