package com.example.fifotech.repository.pdf;

import com.example.fifotech.entity.pdf.PdfOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdfOwnerRepository extends JpaRepository<PdfOwner, Long> {


}
