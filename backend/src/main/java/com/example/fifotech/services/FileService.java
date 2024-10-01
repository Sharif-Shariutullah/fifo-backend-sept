package com.example.fifotech.services;

import com.example.fifotech.entity.FileEntity;
import com.example.fifotech.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileService {

    @Autowired
    private FileRepository fileRepository;





//    public FileEntity saveFile(MultipartFile file) throws IOException {
//        FileEntity fileEntity = new FileEntity();
//        fileEntity.setFileName(file.getOriginalFilename());
//        fileEntity.setFileType(file.getContentType());
//        fileEntity.setData(file.getBytes());
//        return fileEntity;
//    }

    public FileEntity saveFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();

        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(fileName);
        fileEntity.setType(file.getContentType());
        fileEntity.setData(file.getBytes());
        return fileRepository.save(fileEntity);
    }








    public Optional<FileEntity> getFile(Long id) {
        return fileRepository.findById(id);
    }

    // New method to get all files
    public List<FileEntity> getAllFiles() {
        return fileRepository.findAll();
    }


    // New method to get all files with Base64 encoded data
    public List<Map<String, String>> getAllFilesWithBase64() {
        return fileRepository.findAll().stream().map(file -> {
            Map<String, String> fileMap = new HashMap<>();
            fileMap.put("id", file.getId().toString());
            fileMap.put("name", file.getName());
            fileMap.put("type", file.getType());
            String base64Image = Base64.getEncoder().encodeToString(file.getData());
            fileMap.put("imageData", base64Image);
            return fileMap;
        }).collect(Collectors.toList());
    }







}



// newly added--------------
//    public FileEntity saveFile(MultipartFile file, String title, String subtitle, Date postDate, String description) throws IOException {
//        String fileName = file.getOriginalFilename();
//        FileEntity fileEntity = new FileEntity();
//        fileEntity.setName(fileName);
//        fileEntity.setType(file.getContentType());
//        fileEntity.setData(file.getBytes());
//        fileEntity.setNewsTitle(title);
//        fileEntity.setNewsSubtitle(subtitle);
//        fileEntity.setPostDate(postDate);
//        fileEntity.setNewsDescription(description);
//        return fileRepository.save(fileEntity);
//    }
//
//    public Optional<FileEntity> getFile(Long id) {
//        return fileRepository.findById(id);
//    }
//
//    public List<FileEntity> getAllFiles() {
//        return fileRepository.findAll();
//    }
