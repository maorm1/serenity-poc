package com.maor.serenitypoc.controller;

import com.maor.serenitypoc.data.User;
import com.maor.serenitypoc.repo.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

	private final UsersRepository usersRepository;

	@GetMapping
	public List<User> getUsers() {
		return usersRepository.getAllUsers();
	}
}
