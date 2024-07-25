package com.itv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itv.models.Job;
import com.itv.repo.JobRepo;

@Service
public class JobService {
	
	@Autowired
	JobRepo repo;
	
	public String saveJob(Job job) {
		repo.save(job);
		return "Job details saved";
	}

	public List<Job> getJobs() {
		return repo.findAll();
	}

	public List<Job> updateJob(Job job) {
		repo.save(job);
		return repo.findAll(); 
	}

	public List<Job> deleteJob(int id) {
		
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return repo.findAll();
		} else {
			return null;
		}
	}

	public List<Job> fetchByIdAndSalary(int id, double salary) {
		return repo.findByIdAndSalary(id, salary);
	}

	public List<Job> getJobsByTitle(String title) {
		return repo.getByTitle(title);
	}

}
