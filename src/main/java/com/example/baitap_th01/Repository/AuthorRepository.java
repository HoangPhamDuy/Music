package com.example.baitap_th01.Repository;

import com.example.baitap_th01.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Query(value = "SELECT a.* FROM tacgia a LEFT JOIN baiviet b ON a.ma_tgia = b.ma_tgia GROUP BY a.ma_tgia ORDER BY COUNT(b.ma_bviet) DESC LIMIT 2", nativeQuery = true)
    List<Author> findTop2AuthorsWithMostArticles();
}
