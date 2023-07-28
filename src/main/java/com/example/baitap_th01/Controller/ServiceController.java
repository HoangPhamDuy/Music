package com.example.baitap_th01.Controller;

import com.example.baitap_th01.Service.ServiceProj;
import com.example.baitap_th01.model.Article;
import com.example.baitap_th01.model.Author;
import com.example.baitap_th01.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ServiceController {
    @Autowired
    private ServiceProj serviceProj;
    @GetMapping("/nhactrutinh")
    public List<Article> getArticlesByGenre() {
        return serviceProj.getArticlesByGenre();
    }
    @GetMapping("/nhacvietplus")
    public List<Article> getArticlesByAuthor(){
        return serviceProj.getArticlesByAuthor_name();
    }
    // chưa có cảm nhận
    @GetMapping("/without-reviews")
    public List<Category> getCategoriesWithoutReviews() {
        return serviceProj.getCategoriesWithoutReviews();
    }
    //liệt kê bài viết
    @GetMapping("/details")
    public List<Object[]> getArticleDetails() {
        return serviceProj.getArticleDetails();
    }
    // thể loại nhiều bài nhâts
    @GetMapping("/category_most")
    public Category getCategoryWithMostArticles() {
        return serviceProj.findCategoryWithMostArticles();
    }
    // top2 tgia nhiều bài nhất
    @GetMapping("/author_most")
    public List<Author> getTop2AuthorsWithMostArticles() {
        return serviceProj.getTop2AuthorsWithMostArticles();
    }
    // tìm kiếm theo name
    @GetMapping("/songs_name")
    public List<Article> getArticlesBySongTitleContainingKeywords() {
        return serviceProj.getArticlesBySongTitleContainingKeywords();
    }
    // tìm kiêm theo name và title
    @GetMapping("/songs_nameOrtitle")
    public List<Article> getArticlesBySongTitleOrArticleTitleContainingKeywords(){
        return serviceProj.getArticlesBySongTitleOrArticleTitleContainingKeywords();
    }
}




