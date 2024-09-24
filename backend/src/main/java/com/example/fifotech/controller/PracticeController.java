package com.example.fifotech.controller;


import com.example.fifotech.dto.PracticeDto;
import com.example.fifotech.dto.ProductDto;
import com.example.fifotech.services.PracticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class PracticeController {

    @Autowired
    private PracticeService practiceService;

    //post

    @PostMapping("/practices")
    public ResponseEntity<PracticeDto> addPractice(@ModelAttribute PracticeDto practiceDto) throws IOException {

        PracticeDto practiceDto1 = practiceService.addPractice(practiceDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(practiceDto1);
    }

    //show
    @GetMapping("/practices")
    public ResponseEntity<List<PracticeDto>> getAllPractice() {

        List<PracticeDto> practiceDtos = practiceService.getAllPractice();
        return ResponseEntity.ok(practiceDtos);
    }

    //delete
    @DeleteMapping("/practices/{id}")
    public ResponseEntity<Void> deletePractice(@PathVariable Long id) {
        boolean deleted = practiceService.deletePractice(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }    ;


// update
//    @PutMapping("/practices/{id}")
//    public ResponseEntity<PracticeDto> updatePractice(@PathVariable Long id, @ModelAttribute PracticeDto practiceDto) throws IOException {
//        PracticeDto updatedPractice = practiceService.updatePractice(id, practiceDto);
//        if (updatedPractice != null) {
//            return ResponseEntity.ok(updatedPractice);
//        } else {
//            return ResponseEntity.notFound().build();
//
//        }
//    }


}
