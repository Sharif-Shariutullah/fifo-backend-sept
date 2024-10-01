package com.example.fifotech.repository.pdf;

import com.example.fifotech.entity.pdf.Pdf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdfRepository extends JpaRepository<Pdf, Long> {

}
