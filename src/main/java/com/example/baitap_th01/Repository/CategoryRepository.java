package com.example.baitap_th01.Repository;

import com.example.baitap_th01.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("SELECT c FROM Category c WHERE c.category_code NOT IN (SELECT DISTINCT a.category.category_code FROM Article a WHERE a.summary IS NOT NULL)")
    List<Category> findCategoriesWithoutReviews();
    @Query(value = "SELECT c.* FROM theloai c LEFT JOIN baiviet b ON c.ma_tloai = b.ma_tloai GROUP BY c.ma_tloai ORDER BY COUNT(b.ma_bviet) DESC LIMIT 1", nativeQuery = true)
    Category findCategoryWithMostArticles();
}
