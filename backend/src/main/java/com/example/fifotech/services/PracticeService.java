package com.example.fifotech.services;

import com.example.fifotech.dto.PracticeDto;

import java.io.IOException;
import java.util.List;

public interface PracticeService {


    PracticeDto addPractice(PracticeDto practiceDto) throws IOException;

    List<PracticeDto> getAllPractice();

    boolean deletePractice(Long id);


//    PracticeDto getPracticeById(Long id);

//    PracticeDto updatePractice(Long id, PracticeDto practiceDto) throws IOException;

}
