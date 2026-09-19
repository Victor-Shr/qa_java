package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.List;

public class FelineTest {
    private Feline feline;

    @Before
    public void setting() {
        feline = new Feline();
    }

    @Test
    public void checkEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    public void checkGetFamily() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void checkGetKittensWithoutArg() {
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void checkGetKittensWithArg() {
        Assert.assertEquals(4, feline.getKittens(4));
    }

}
