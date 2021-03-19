package com.alliander.catsapp.services;

import com.alliander.catsapp.domain.Cat;
import com.alliander.catsapp.repositories.CatRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
class CatServiceTest {

    @Mock
    CatRepository catRepository;
    @InjectMocks
    CatService catService;

    @Test
    void getAllCats() {
        List<Cat> cats = new ArrayList<>();
        when(catRepository.findAll()).thenReturn(cats);

        assertEquals(cats, catService.getAllCats());
        verify((catRepository), times(1)).findAll();
    }

    @Test
    void getCatById() {
        Cat cat = new Cat();
        Long id = 1L;
        when(catRepository.findById(id)).thenReturn(Optional.of(cat));

        assertEquals(cat, catService.getCatById(id));
        verify((catRepository), times(1)).findById(anyLong());
    }

    @Test
    void saveCat() {
        Cat cat = new Cat();
        when(catRepository.save(any())).thenReturn(cat);

        assertEquals(cat, catService.saveCat(new Cat()));

        verify((catRepository), times(1)).save(any());
    }
}