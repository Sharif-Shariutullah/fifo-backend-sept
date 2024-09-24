package com.example.fifotech.services;

import com.example.fifotech.dto.PracticeDto;
import com.example.fifotech.entity.Practice;
import com.example.fifotech.repository.PracticeRepository;
import com.example.fifotech.utils.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PracticeServiceImp implements PracticeService {

    @Autowired
    private PracticeRepository practiceRepository;

    //create
    public PracticeDto addPractice(PracticeDto practiceDto) throws IOException {

        Practice practice = new Practice();

        practice.setTitle(practiceDto.getTitle());
        practice.setSubtitle(practiceDto.getSubtitle());
        practice.setDescription(practiceDto.getDescription());
        practice.setImg(practiceDto.getImg().getBytes());

        System.out.println(Arrays.toString(practice.getImg()));
        System.out.println(Arrays.toString(ImageUtils.compressImage(practice.getImg())));

        return practiceRepository.save(practice).getDto();
    }


//show

    public List<PracticeDto> getAllPractice() {

        List<Practice> practices = practiceRepository.findAll();
        return practices.stream().map(Practice::getDto).collect(Collectors.toList());
    }

//delete


    public boolean deletePractice(Long id) {
        Optional<Practice> optionalPractice = practiceRepository.findById(id);
        if (optionalPractice.isPresent()) {
            practiceRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
