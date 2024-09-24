package com.example.fifotech.repository;

import com.example.fifotech.entity.JobApplicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<JobApplicant, Long> {

}
