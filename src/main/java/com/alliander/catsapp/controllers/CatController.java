package com.alliander.catsapp.controllers;

import com.alliander.catsapp.domain.Cat;
import com.alliander.catsapp.services.CatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/cats")
@RestController
public class CatController {
    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public List<Cat> getAllCats(){
        return catService.getAllCats();
    }

    @GetMapping("/{id}")
    public Cat getCatWithId(@PathVariable Long id){
        return catService.getCatById(id);
    }
}
