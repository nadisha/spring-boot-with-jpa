package com.nadisha.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(
		name = "StudentIdCards",
		uniqueConstraints = {
				@UniqueConstraint(name = "student_id_card_number_unique", columnNames = "card_number")
			}
		)
public class StudentIdCard {
	
	@Id
	@SequenceGenerator(
			name = "student_id_card_seq",
			sequenceName = "student_id_card_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, 
			generator = "student_id_card_seq"
	)
	private Long id;
	
	@Column(
			name = "card_number", 
			nullable = false, 
			length = 15	
	)
	private String cardNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(
			name = "student_id", 
			referencedColumnName = "id",
			foreignKey = @ForeignKey(
					name = "student_id_fk"
			)
	)
	private Student student;
}
