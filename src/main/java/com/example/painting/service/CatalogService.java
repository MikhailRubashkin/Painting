package com.example.painting.service;

import com.example.painting.pojo.Catalog;
import com.example.painting.repository.CatalogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CatalogService {

    @Autowired
    CatalogRepo catalogRepo;

    @Transactional
    public Catalog findCatalog( Long id) {
        return catalogRepo.findCatalogById (id);
    }

}
