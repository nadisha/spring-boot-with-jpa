package com.nadisha.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(
		name = "Students",
		uniqueConstraints = {
				@UniqueConstraint(name = "student_email_unique", columnNames = "email")
		}
)
@Data
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(
			name = "first_name",
			nullable = false,
			columnDefinition = "TEXT"
	)
	private String firstName;
		
	@Column(
			name = "last_name",
			nullable = false
	)
	private String lastName;
	
	@Column(
			nullable = false
	)
	private String email;
	
	@Column(
			name = "age",
			nullable = false
	)
	private Integer age;
	
	
	@OneToMany(
			mappedBy = "student",
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
			fetch = FetchType.LAZY			
	)
	@JsonManagedReference
	private List<Book> books = new ArrayList<>();
	
	@OneToOne(
			mappedBy = "student", 
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
			fetch = FetchType.LAZY
	)
	private StudentIdCard studentIdCard;
	
	@OneToMany(
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
			mappedBy = "student"
	)
	private List<Enrolment> enrolments = new ArrayList<>();

	public Student(Long id) {
		super();
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(age, other.age) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, email, firstName, id, lastName);
	}
}
