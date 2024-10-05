package com.example.fifotech.services;

import com.example.fifotech.dto.NewsDto;
import com.example.fifotech.dto.ProductDetailDto;
import com.example.fifotech.entity.JobPosting;
import com.example.fifotech.entity.News;
import com.example.fifotech.repository.NewsRepository;
import com.example.fifotech.utils.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

        // Set the date and time when the news is created
        news.setCreateDate(LocalDate.now());
        news.setCreateTime(LocalTime.now());
        news.setLastUpdated(LocalDateTime.now());






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



    // get news by id

//    public ResponseEntity<NewsDto> getNewsById(@PathVariable Long id) {
//        NewsDto newsDto = newsRepository.findById(id).get();
//        return ResponseEntity.ok(newsDto);
//    }


//    public NewsDto getNewsById(Long id) {
//        return newsRepository.findById(id).get();
//    }


    @Override
    public NewsDto getNewsById(Long id) {
        Optional<News> optionalNews = newsRepository.findById(id);
        if (optionalNews.isPresent()) {
            return optionalNews.get().getDto(); // Convert to NewsDto and return
        }
        return null; // Return null if not found
    }

}
