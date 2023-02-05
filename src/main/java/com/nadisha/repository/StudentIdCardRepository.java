package com.nadisha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nadisha.entity.StudentIdCard;

@Repository
public interface StudentIdCardRepository extends JpaRepository<StudentIdCard, Long> {

}
