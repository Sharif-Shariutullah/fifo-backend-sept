package com.example.fifotech.repository;

import com.example.fifotech.entity.GlobalBPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalBpoRepository extends JpaRepository<GlobalBPO, Integer> {
}
