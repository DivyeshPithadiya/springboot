package com.itv.models;

import org.hibernate.validator.constraints.CreditCardNumber;

import com.itv.validations.DepartmentValidation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column
	@NotBlank(message = "Title can not be blank")
	private String title;

	@Column
	@Min(value = 0, message = "Salary an not be empty")
	private double salary;

	@Column
	@NotBlank(message = "Description can not be blank")
	private String description;

	@Min(value = 18, message = "Age must be greater than 18")
	@Max(value = 40, message = "Age must be less than 40")
	private int ageLimit;

	@Email(message = "Email is invalid")
	private String email;

	@Pattern(regexp = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}", message = "Phone number is invalid")
	private String phone;

	@DepartmentValidation
	private String department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAgeLimit() {
		return ageLimit;
	}

	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Job(int id, @NotBlank(message = "Title can not be blank") String title,
			@Min(value = 0, message = "Salary an not be empty") double salary,
			@NotBlank(message = "Description can not be blank") String description,
			@Min(value = 18, message = "Age must be greater than 18") @Max(value = 40, message = "Age must be less than 40") int ageLimit,
			@Email(message = "Email is invalid") String email,
			@Pattern(regexp = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}", message = "Phone number is invalid") String phone,
			String department) {
		super();
		this.id = id;
		this.title = title;
		this.salary = salary;
		this.description = description;
		this.ageLimit = ageLimit;
		this.email = email;
		this.phone = phone;
		this.department = department;
	}

}
