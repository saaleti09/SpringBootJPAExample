package com.aaleti.springbootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fares")
public class FareController {

	@Autowired
	Environment enviornment;

	@GetMapping("/get")
	public String getFare() {

		for (String option : enviornment.getDefaultProfiles()) {

			System.out.println("FareController option name is" + enviornment.getProperty("MyOwnProperty") + enviornment.getProperty("MyOwnProperty"));
		}

		return "No Flights due to COVID - Pandemic";

	}

}
