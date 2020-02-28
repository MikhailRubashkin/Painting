package com.example.painting.repository;

import com.example.painting.pojo.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepo extends JpaRepository<Catalog, Long> {
      Catalog findCatalogById( Long id);
}
