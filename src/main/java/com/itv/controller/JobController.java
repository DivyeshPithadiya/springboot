package com.itv.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itv.exceptions.JobNotFoundException;
import com.itv.models.Job;
import com.itv.service.JobService;

import jakarta.validation.Valid;

@RestController
//@Controller
//@ResponseBody
@RequestMapping("/api")
public class JobController {

	@Autowired
	JobService service;

//	@PostMapping("/job")
	@RequestMapping(method = RequestMethod.POST, path = "/job")
	public String saveJobDetails(@RequestBody @Valid Job job) {
		return service.saveJob(job);
	}

	@GetMapping("/jobs")
	public ResponseEntity<List<Job>> getJobs() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getJobs());
	}

	@PutMapping("/job")
	public ResponseEntity<List<Job>> updateJob(@RequestBody @Valid Job job) {
		return ResponseEntity.status(HttpStatus.OK).body(service.updateJob(job));
	}

	@DeleteMapping("/job/{id}")
	public List<Job> deleteJob(@PathVariable int id) {

		List<Job> jobs = service.deleteJob(id);

		if (jobs != null) {
			return jobs;
		} else {
			throw new JobNotFoundException("Job not found");
		}
	}

	@GetMapping("/jobs/{id}/{salary}")
	public List<Job> fetchByIdAndSalary(@PathVariable int id, @PathVariable double salary) {
		return service.fetchByIdAndSalary(id, salary);
	}

	@GetMapping("/jobs/{title}")
	public List<Job> getByTitle(@PathVariable String title) {
		return service.getJobsByTitle(title);
	}

}
