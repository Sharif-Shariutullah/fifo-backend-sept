package com.example.fifotech.controller.pdf;

import com.example.fifotech.entity.pdf.PdfOwner;
import com.example.fifotech.services.pdf.PddfOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class PdfOwnerController {



//
//    @Autowired
//    private PddfOwnerService pddfOwnerService;
//
//    @PostMapping("/apply")
//    public ResponseEntity<PdfOwner> applyForJob(
//            @RequestParam("name") String name,
//            @RequestParam("email") String email,
//            @RequestParam("phone") String phone,
//            @RequestParam("resume") MultipartFile resumeFile) throws IOException {
//
//        PdfOwner pdfOwner = pddfOwnerService.savePdfOwner(name, email, phone, resumeFile);
//        return ResponseEntity.ok(pdfOwner);
//    }
}
