package com.nadisha.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Books")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

	@Id
	@SequenceGenerator(
			name="book_seq",
			sequenceName = "book_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "book_seq"
	)
	private Long id;
	
    @Column(
            name = "book_name",
            nullable = false
    )	
	private String bookName;
	
    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )	
	private LocalDateTime createdAt;
    
    @ManyToOne
    @JoinColumn(
    		name = "student_id",
    		nullable = false,
    		referencedColumnName = "id",
    		foreignKey = @ForeignKey(
    				name = "student_book_fk"
    		)    		
    )
    @JsonBackReference
    private Student student;
}
