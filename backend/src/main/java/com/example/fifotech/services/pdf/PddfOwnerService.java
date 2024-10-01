package com.example.fifotech.services.pdf;

import com.example.fifotech.entity.pdf.Pdf;
import com.example.fifotech.entity.pdf.PdfOwner;
import com.example.fifotech.repository.pdf.PdfOwnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PddfOwnerService {


//    @Autowired
//    private PdfOwnerRepository pdfOwnerRepository;
//
//
//
//    public PdfOwner savePdfOwner (String name, String email, String phone, MultipartFile file) throws IOException {
//
//
//
//        // Create Resume entity from the file
//        Pdf pdf = new Pdf();
//        pdf.setFileName(file.getOriginalFilename());
//        pdf.setFileType(file.getContentType());
////        pdf.setSize(file.getSize());
//        pdf.setData(file.getBytes());
//
//
//
//        // Create Applicant entity
//        PdfOwner pdfOwner = new PdfOwner();
//        pdfOwner.setName(name);
//        pdfOwner.setEmail(email);
//        pdfOwner.setPhone(phone);
//        pdfOwner.setResume(pdf);
//
//        // Save Applicant (resume will also be saved due to cascade)
//        return pdfOwnerRepository.save(pdfOwner);
//    }

}
