package com.itv.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itv.models.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer> {
	
	public List<Job> findByIdAndSalary(int id, double salary);

	@Query(value = "select * from job where title = ?1", nativeQuery = true)
	public List<Job> getByTitle(String title);
	
}
