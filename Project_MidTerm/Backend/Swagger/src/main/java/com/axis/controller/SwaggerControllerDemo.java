package com.axis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SwaggerControllerDemo {

	@GetMapping("/hi")
	public String app() {
		return "hello";
		
	}
	@PostMapping("/add")
	public String add() {
		return "Added";
	}

}
