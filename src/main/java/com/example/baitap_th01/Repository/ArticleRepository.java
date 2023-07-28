package com.example.baitap_th01.Repository;

import com.example.baitap_th01.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    @Query("SELECT a FROM Article a JOIN a.category g WHERE g.category_name = 'Nhạc trữ tình'")
    List<Article> findArticlesByGenre();
    @Query("SELECT a FROM Article a JOIN a.author g WHERE g.author_name = 'Nhacvietplus'")
    List<Article> findArticlesByAuthor_name();
    @Query("SELECT a.postId, a.title, a.name, a.author.author_name, a.category.category_name, a.postDate FROM Article a")
    List<Object[]> getArticleDetails();
    @Query("SELECT a FROM Article a WHERE a.name LIKE %:keyword1% OR a.name LIKE %:keyword2% OR a.name LIKE %:keyword3% OR a.name LIKE %:keyword4%")
    List<Article> findArticlesBySongTitleContainingKeywords(String keyword1, String keyword2, String keyword3, String keyword4);
    @Query("SELECT a FROM Article a WHERE a.title LIKE %:keyword1% OR a.name LIKE %:keyword1% OR a.name LIKE %:keyword2%OR a.title LIKE %:keyword2% OR a.name LIKE %:keyword3% OR a.title LIKE %:keyword3% OR  a.title LIKE %:keyword4% OR a.name LIKE %:keyword4%")
    List<Article> findArticlesBySongTitleOrArticleTitleContainingKeywords(String keyword1, String keyword2, String keyword3, String keyword4);
}
