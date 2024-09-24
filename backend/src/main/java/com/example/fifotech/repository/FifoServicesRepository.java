package com.example.fifotech.repository;

import com.example.fifotech.entity.FifoServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FifoServicesRepository extends JpaRepository<FifoServices, Integer> {
}
