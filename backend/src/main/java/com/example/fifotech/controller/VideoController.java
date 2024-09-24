package com.example.fifotech.controller;

import com.example.fifotech.entity.Video;
import com.example.fifotech.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class VideoController {


    @Autowired
    private VideoService videoService;


    // create
    @PostMapping({"/postNewVideo"})
    public Video addNewVideo(@RequestBody Video video) {
        return videoService.createNewVideo(video);

    }

    // show
    @GetMapping({"/getAllVideo"})
    public List<Video> getAllVideo() {
        return videoService.getAllVideo();
    }

    ;

    // delete
    @DeleteMapping({"/deleteVideo/{id}"})
    public void deleteVideo(@PathVariable("id") Integer id) {
        videoService.deleteVideo(id);
    }

    //edit
    @GetMapping({"/getVideoById/{id}"})
    public Video getVideoById(@PathVariable("id") Integer id) {
        return videoService.getVideoById(id);
    }

    ;
}
