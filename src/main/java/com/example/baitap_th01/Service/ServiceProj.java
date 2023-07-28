package com.example.baitap_th01.Service;

import com.example.baitap_th01.Repository.ArticleRepository;
import com.example.baitap_th01.Repository.AuthorRepository;
import com.example.baitap_th01.Repository.CategoryRepository;
import com.example.baitap_th01.model.Article;
import com.example.baitap_th01.model.Author;
import com.example.baitap_th01.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProj {
    @Autowired
    private  ArticleRepository articleRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AuthorRepository authorRepository;
    // genre = "Nhạc trữ tình"
    public List<Article> getArticlesByGenre() {
        return articleRepository.findArticlesByGenre();
    }
    // author = "nhacvietplus"
    public List<Article> getArticlesByAuthor_name(){
        return  articleRepository.findArticlesByAuthor_name();
    }
    // chưa có bài viết cảm nhận
    public List<Category> getCategoriesWithoutReviews() {
        return categoryRepository.findCategoriesWithoutReviews();
    }
    // liệt kê bài viết
    public List<Object[]> getArticleDetails() {
        return articleRepository.getArticleDetails();
    }
    //Thể loại nhiều bài nhất
    public Category findCategoryWithMostArticles() {
        return categoryRepository.findCategoryWithMostArticles();
    }
    // top2 tác giả nhiều bài nhất
    public List<Author>getTop2AuthorsWithMostArticles() {
        return authorRepository.findTop2AuthorsWithMostArticles();
    }
    public List<Article> getArticlesBySongTitleContainingKeywords(){
        return  articleRepository.findArticlesBySongTitleContainingKeywords("yêu", "thương", "anh","em");
    }
   public List<Article> getArticlesBySongTitleOrArticleTitleContainingKeywords(){
        return  articleRepository.findArticlesBySongTitleOrArticleTitleContainingKeywords("yêu", "thương", "anh","em");
    }
}
