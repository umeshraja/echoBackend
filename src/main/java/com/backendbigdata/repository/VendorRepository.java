package com.backendbigdata.repository;

import com.backendbigdata.dto.VendorWithMostProductsDto;
import com.backendbigdata.dto.response.HighPricedProductVendorDto;
import com.backendbigdata.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, String> {

    @Query(value = "SELECT NEW com.backendbigdata.dto.VendorWithMostProductsDto(v.name, COUNT(v) AS numProducts) FROM Category c, Part p, VendorProductReference vpr, Vendor v WHERE c.cId = :categoryId AND c.cId = p.category.cId AND p.pId = vpr.part.pId AND vpr.vendor.vendNum =  v.vendNum GROUP BY v.name ORDER BY numProducts DESC")
    List<VendorWithMostProductsDto> getVendorProducingMostProducts(@Param("categoryId") Integer categoryId);

    @Query("SELECT NEW com.backendbigdata.dto.response.HighPricedProductVendorDto(v.name, AVG(p.price) AS avgPrice) FROM Part p, VendorProductReference vpr, Vendor v WHERE p.cacit LIKE %:material_name% AND p.price > 0 AND p.pId = vpr.part.pId AND vpr.vendor.vendNum = v.vendNum GROUP BY v.vendNum ORDER BY avgPrice DESC")
    List<HighPricedProductVendorDto> getHighPricedProductVendor(@Param("material_name") String cacit);

    @Query("SELECT DISTINCT(v.name) FROM Category c, Part p, VendorProductReference vpr, Vendor v WHERE c.cId = :categoryId AND c.cId = p.category.cId AND p.pId = vpr.part.pId AND vpr.vendor.vendNum = v.vendNum")
    List<String> getVendorsByProductsCategory(@Param("categoryId") Integer categoryId);
}
