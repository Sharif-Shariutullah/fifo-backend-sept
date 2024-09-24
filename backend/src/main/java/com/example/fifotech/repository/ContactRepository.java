package com.example.fifotech.repository;

import com.example.fifotech.entity.ClientsContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ClientsContact, Long>{

}
