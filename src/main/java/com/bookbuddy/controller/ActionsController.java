package com.bookbuddy.controller;

import java.io.IOException;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/actions/")
public class ActionsController {
	private Logger logger = LoggerFactory.getLogger(ActionsController.class);
	
	@PostMapping
	public ResponseEntity<?> executePostAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("--- executePostAction ---");
		
		String body = request.getReader().lines().collect(Collectors.joining());
		
		logger.info(new JSONObject(body).toString(4));
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> executeGetAction() {
		return new ResponseEntity<String>("This endpoint only accepts POST requests from Google Assistant", HttpStatus.OK);
	}
}