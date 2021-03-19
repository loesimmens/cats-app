package com.alliander.catsapp.controllers;

import com.alliander.catsapp.domain.Cat;
import com.alliander.catsapp.services.CatService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatControllerTest {

    @Mock
    CatService catService;
    @InjectMocks
    CatController catController;

    @Test
    void getAllCats() {
        List<Cat> cats = new ArrayList<>();
        when(catService.getAllCats()).thenReturn(cats);
        assertEquals(cats, catController.getAllCats());
        verify((catService), times(1)).getAllCats();
    }

    @Test
    void getCatByIdTest(){
        Cat cat = new Cat();
        Long id = 1L;
        when(catService.getCatById(id)).thenReturn(cat);
        assertEquals(cat, catController.getCatWithId(id));
        verify((catService), times(1)).getCatById(anyLong());
    }
}