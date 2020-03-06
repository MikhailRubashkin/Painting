package com.example.painting.service;

import com.example.painting.pojo.Catalog;
import com.example.painting.repository.CatalogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Service
public class CatalogService {

    @Autowired
    CatalogRepo catalogRepo;

    @Transactional
    public Catalog findCatalog(Long id) {
        return catalogRepo.findCatalogById(id);
    }

    public int randomNumber() {
        while (true) {
            int resultRandom = new Random().nextInt(8);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return resultRandom;
        }
    }
}
