package com.nadisha.service;

import com.nadisha.entity.StudentIdCard;

public interface StudentIdCardService {
	
	public void createByStudentId(StudentIdCard idCard, Long studentId);
}
