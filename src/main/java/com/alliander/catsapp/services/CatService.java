package com.alliander.catsapp.services;

import com.alliander.catsapp.domain.Cat;
import com.alliander.catsapp.repositories.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CatService {
    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public List<Cat> getAllCats(){
        return StreamSupport.stream(catRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Cat getCatById(Long id){
        return catRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public Cat saveCat(Cat cat){
        return catRepository.save(cat);
    }
}
