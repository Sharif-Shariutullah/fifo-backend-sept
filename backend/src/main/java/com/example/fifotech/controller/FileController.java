package com.example.fifotech.controller;

import com.example.fifotech.entity.FileEntity;
import com.example.fifotech.services.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private final FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            fileService.saveFile(file);
            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("File upload failed: " + e.getMessage());
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long id) {
        return fileService.getFile(id)
                .map(file -> ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(file.getType()))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                        .body(new ByteArrayResource(file.getData())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    // New endpoint to get all files
    @GetMapping("/all")
    public ResponseEntity<List<FileEntity>> getAllFiles() {
        List<FileEntity> files = fileService.getAllFiles();
        return ResponseEntity.ok(files);
    }

    // New endpoint to return all files with Base64 image data
    @GetMapping("/allWithBase64")
    public ResponseEntity<List<Map<String, String>>> getAllFilesWithBase64() {
        return ResponseEntity.ok(fileService.getAllFilesWithBase64());
    }











}


    // newly added--------------


//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(
//            @RequestParam("file") MultipartFile file,
//            @RequestParam("newsTitle") String title,
//            @RequestParam("newsSubtitle") String subtitle,
//            @RequestParam("postDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date postDate,
//            @RequestParam("newsDescription") String description) {
//
//        try {
//            fileService.saveFile(file, title, subtitle, postDate, description);
//            return ResponseEntity.ok("File uploaded successfully");
//        } catch (IOException e) {
//            return ResponseEntity.status(500).body("File upload failed: " + e.getMessage());
//        }
//    }
//
//    @GetMapping("/files")
//    public ResponseEntity<List<FileEntity>> getAllFiles() {
//        List<FileEntity> files = fileService.getAllFiles();
//        return ResponseEntity.ok(files);
//    }
//
////    @GetMapping("/details/{id}")
////    public ResponseEntity<FileEntity> getFileDetails(@PathVariable Long id) {
////        return fileService.getFile(id)
////                .map(ResponseEntity::ok)
////                .orElseGet(() -> ResponseEntity.notFound().build());
////    }
//
//
//    @GetMapping("/{id}")
//    public ResponseEntity<FileEntity> getFileDetails(@PathVariable Long id) {
//        return fileService.getFile(id)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
