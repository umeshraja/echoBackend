package com.backendbigdata.repository;

import com.backendbigdata.dto.response.CategoryWithMostProducts;
import com.backendbigdata.dto.response.PriceStatsDto;
import com.backendbigdata.model.Category;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAll();

    @Query("SELECT NEW com.backendbigdata.dto.response.PriceStatsDto(MIN(p.price), MAX(p.price),AVG(p.price)) FROM Part p, Category c WHERE c.cId = :categoryId AND c.cId = p.category.cId AND p.price > 0")
    PriceStatsDto getPriceStats(@Param("categoryId") Integer categoryId);

    @Query("SELECT NEW com.backendbigdata.dto.response.CategoryWithMostProducts(c.name, COUNT(p) AS numProducts) FROM Part p, Category c WHERE p.category.cId = c.cId GROUP BY c.cId ORDER BY numProducts DESC")
    List<CategoryWithMostProducts> getCategoryWithMostProducts();
}
