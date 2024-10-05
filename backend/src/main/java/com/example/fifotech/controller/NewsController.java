package com.example.fifotech.controller;

import com.example.fifotech.dto.NewsDto;
import com.example.fifotech.services.NewsService;
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
public class NewsController {


    @Autowired
    private NewsService newsService;


    //post

    @PostMapping("/postNews")
    public ResponseEntity<NewsDto> addNews(@ModelAttribute NewsDto newsDto) throws IOException {

        NewsDto newsDto1 = newsService.addNews(newsDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newsDto1);
    }


    //show
    @GetMapping("/news")
    public ResponseEntity<List<NewsDto>> getAllNews() {
        List<NewsDto> newsDtos = newsService.getAllNews();
        return ResponseEntity.ok(newsDtos);
    }



    //delete
    @DeleteMapping("/news/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
        boolean deleted = newsService.deleteNews(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }    ;



    @GetMapping("/news/{id}")
    public ResponseEntity<NewsDto> getNewsById(@PathVariable Long id) {
        NewsDto newsDto = newsService.getNewsById(id);
        if (newsDto != null) {
            return ResponseEntity.ok(newsDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}