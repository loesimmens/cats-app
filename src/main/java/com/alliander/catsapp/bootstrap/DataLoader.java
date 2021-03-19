package com.alliander.catsapp.bootstrap;

import com.alliander.catsapp.domain.Cat;
import com.alliander.catsapp.repositories.CatRepository;
import com.alliander.catsapp.services.CatService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CatService catService;
    private final CatRepository catRepository;

    public DataLoader(CatService catService, CatRepository catRepository) {
        this.catService = catService;
        this.catRepository = catRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        Cat roos = new Cat();
        roos.setName("Roos");
        roos.setAge(7);
        System.out.println(catService.saveCat(roos));

        Cat douwe = new Cat();
        douwe.setName("Douwe");
        douwe.setAge(6);
        System.out.println(catService.saveCat(douwe));
    }
}
