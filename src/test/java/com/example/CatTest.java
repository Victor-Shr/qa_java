package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Cat cat;

    @Mock
    Feline feline;

    @Before
    public void setting() {
        cat = new Cat(feline);
    }

    @Test
    public void checkGetSound() {
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void checkGetFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFood = cat.getFood();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
    }

}
