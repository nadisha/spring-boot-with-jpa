package com.nadisha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentIdCardDto {
	
	private Long id;
	
	private String cardNumber;
}
