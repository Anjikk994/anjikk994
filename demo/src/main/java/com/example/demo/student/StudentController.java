package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/v1/student")
public class StudentController {
	@GetMapping()
	public Student getStudent() {
		
	}

}
