package com.example.fifotech.services;

import com.example.fifotech.dto.NewsDto;
import com.example.fifotech.entity.News;
import com.example.fifotech.repository.NewsRepository;
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
public class NewsServiceImp implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    //create
    public NewsDto addNews(NewsDto newsDto) throws IOException {

        News news = new News();

        news.setTitle(newsDto.getTitle());
        news.setSubtitle(newsDto.getSubtitle());
        news.setDescription(newsDto.getDescription());
        news.setImg(newsDto.getImg().getBytes());

        System.out.println(Arrays.toString(news.getImg()));
        System.out.println(Arrays.toString(ImageUtils.compressImage(news.getImg())));

        return newsRepository.save(news).getDto();
    }


    //show

    public List<NewsDto> getAllNews() {

        List<News> news = newsRepository.findAll();
        return news.stream().map(News::getDto).collect(Collectors.toList());
    }


    //delete
    public boolean deleteNews(Long id) {
        Optional<News> optionalNews = newsRepository.findById(id);
        if (optionalNews.isPresent()) {
            newsRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
