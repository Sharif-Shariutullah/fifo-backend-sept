package com.example.fifotech.services;

import com.example.fifotech.entity.News;
import com.example.fifotech.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    // create
    public News saveNews(News news) {
        return newsRepository.save(news);
    }


    //get or show
    public List<News> getAllNews() {
        return (List<News>) newsRepository.findAll();
    }

    //delete
    public void deleteNews(Long newsId) {
        newsRepository.deleteById(newsId);
    }


    // edit
    public News getNewsById(Long newsId) {
        return newsRepository.findById(newsId).get();
    }


}
