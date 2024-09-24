package com.example.fifotech.services;

import com.example.fifotech.entity.JobPosting;
import com.example.fifotech.entity.Video;
import com.example.fifotech.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;


    //    create
    public Video createNewVideo(Video video) {
        return videoRepository.save(video);
    }

    // show from db to website
    public List<Video> getAllVideo() {
        return (List<Video>) videoRepository.findAll();

    }

    // delete by id
    public void deleteVideo(Integer id) {
        videoRepository.deleteById(id);
    }

    // edit
    public Video getVideoById(Integer id) {
        return videoRepository.findById(id).get();
    }

}
