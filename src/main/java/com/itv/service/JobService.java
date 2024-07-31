package com.itv.service;

import java.util.List;

import com.itv.models.Job;

public interface JobService {
	
	String saveJob(Job job);
	
	List<Job> getJobs(int pageNo, int pageSize);
	
	List<Job> updateJob(Job job);
	
	List<Job> deleteJob(int id);
	
	List<Job> fetchByIdAndSalary(int id, double salary);
	
	List<Job> getJobsByTitle(String title);
	
}
