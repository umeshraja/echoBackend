package com.backendbigdata.repository;

import com.backendbigdata.dto.response.CountryWiseProductsCount;
import com.backendbigdata.dto.response.PartAvgWeight;
import com.backendbigdata.dto.response.PartDescription;
import com.backendbigdata.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<Part, String> {

    @Query("SELECT NEW com.backendbigdata.dto.response.PartAvgWeight(AVG(p.unitWeight)) FROM Part p WHERE p.cacit = :cacit")
    PartAvgWeight getPartAvgWeight(@Param("cacit") String cacit);

    @Query("SELECT (SUM(p.unitWeight) / SUM(p.price)) FROM Part p WHERE p.cacit LIKE %:material_name% AND p.price > 0 AND p.unitWeight > 0")
    Double getPricePerGram(@Param("material_name") String cacit);

    @Query("SELECT p FROM Part p, CountryOfOrigin c WHERE c.cooId = :countryId AND c.cooId = p.countryOfOrigin.cooId")
    List<Part> getProductsByCountry(@Param("countryId") String countryId);

    @Query("SELECT NEW com.backendbigdata.dto.response.CountryWiseProductsCount(c.name, COUNT(p) AS numProducts) FROM CountryOfOrigin c, Part p WHERE c.cooId = p.countryOfOrigin.cooId GROUP BY c.cooId ORDER BY numProducts DESC")
    List<CountryWiseProductsCount> getCountryWiseProductsCount();

    @Query("SELECT NEW com.backendbigdata.dto.response.PartDescription(p.pId, p.description) FROM Part p, Category c WHERE c.cId = :categoryId AND c.cId = p.category.cId")
    List<PartDescription> getPartsByCategory(@Param("categoryId") Integer categoryId);

    @Query("SELECT NEW com.backendbigdata.dto.response.PartDescription(p.pId, p.description) FROM Part p, Category c WHERE c.cId = :categoryId AND c.cId = p.category.cId AND p.countryOfOrigin.cooId = :cooId")
    List<PartDescription> getPartsByCategoryAndCoo(@Param("categoryId") Integer categoryId, @Param("cooId") String cooId);
}
