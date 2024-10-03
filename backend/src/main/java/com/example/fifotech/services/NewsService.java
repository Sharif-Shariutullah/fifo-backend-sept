package com.example.fifotech.services;

import com.example.fifotech.dto.NewsDto;

import java.io.IOException;
import java.util.List;

public interface NewsService {


    NewsDto addNews(NewsDto newsDto) throws IOException;

    List<NewsDto> getAllNews();

    boolean deleteNews(Long id);


//    NewsDto getNewsById(Long id);

//    NewsDto updateNews(Long id, NewsDto newsDto) throws IOException;




}
