package com.backendbigdata.repository;

import com.backendbigdata.model.CountryOfOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface COORepository extends JpaRepository<CountryOfOrigin, String> {
    List<CountryOfOrigin> findAll();
}
