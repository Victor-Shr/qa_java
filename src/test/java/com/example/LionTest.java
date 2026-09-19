package com.example;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    // негативная проверка, expected = Exception.class покрасит тест в зелёный при ошибке, как и должно быть
    @Test(expected = Exception.class)
    public void exceptionWhenInvalidSex() throws Exception {
       Feline feline = Mockito.mock(Feline.class);
       Lion lion = new Lion(feline, "Неверный пол!");
    }

    @Mock
    Feline feline;

    @Test
    public void checkGetKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(feline, "Самка");
        int actualKittens = lion.getKittens();
        Assert.assertEquals(1, actualKittens);
    }

    @Test
    public void checkDoesHaveMane() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void checkGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion(feline, "Самец");
        List<String> actualFood = lion.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }
}
