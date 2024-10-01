package com.example.fifotech.services.pdf;

import com.example.fifotech.entity.JobApplicant;
import com.example.fifotech.entity.pdf.Pdf;
import com.example.fifotech.repository.pdf.PdfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdfService {


    @Autowired
    private PdfRepository pdfRepository;


// ------------ apply job ---------------- 01
public Pdf applyForJob(Pdf pdf){

    return pdfRepository.save(pdf);
}


// ------------ List job applicant ---------------- 02

// ------------ upload CV ---------------- 03

// ------------ download CV ---------------- 04










//    public JobApplicant applyForNewJob(JobApplicant jobApplicant) {
//
//
//        return applicantRepository.save(jobApplicant);
//    }
//
//    ;
//
//
//    // show from db to website
//    public List<JobApplicant> getAllJobApplicant() {
//        return (List<JobApplicant>) applicantRepository.findAll();
//    }
//}









//    public FileEntity saveFile(MultipartFile file, FileEntity fileEntity) throws IOException {
//        String fileName = file.getOriginalFilename();
// parseByte(file);

//        FileEntity fileEntity = new FileEntity();
//        fileEntity.setName(fileName);
//        fileEntity.setType(file.getContentType());
//        fileEntity.setData(file.getBytes());
//        return fileRepository.save(fileEntity);
//    }
//
//
//    public Optional<FileEntity> getFile(Long id) {
//        return fileRepository.findById(id);
//    }
//
//    // New method to get all files
//    public List<FileEntity> getAllFiles() {
//        return fileRepository.findAll();
//    }
//
//
//    // New method to get all files with Base64 encoded data
//    public List<Map<String, String>> getAllFilesWithBase64() {
//        return fileRepository.findAll().stream().map(file -> {
//            Map<String, String> fileMap = new HashMap<>();
//            fileMap.put("id", file.getId().toString());
//            fileMap.put("name", file.getName());
//            fileMap.put("type", file.getType());
//            String base64Image = Base64.getEncoder().encodeToString(file.getData());
//            fileMap.put("imageData", base64Image);
//            return fileMap;
//        }).collect(Collectors.toList());
//    }





}
