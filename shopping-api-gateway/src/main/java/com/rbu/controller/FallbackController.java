package com.rbu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@GetMapping("/customerFallback")
	public ResponseEntity<String> customerServiceFallback() {
		String msg = "Customer service is taking longer than expected, please try after sometime.";
		return new ResponseEntity<String>(msg, HttpStatus.GATEWAY_TIMEOUT);
	}
}
