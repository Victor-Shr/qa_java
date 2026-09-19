package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

// в параметризованный тест вынесу проверку пола льва и его гривы, так как там есть ветвление. Исключение сделаю в
// отдельном тесте, так как оно ломает позитивные проверки тут

@RunWith(Parameterized.class)

public class ParameterizedLionTest {
    private final String lionSex;
    private final boolean expectedHasMane;

    public ParameterizedLionTest(String lionSex, boolean expectedHasMane) {
        this.lionSex = lionSex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
            {"Самец", true},
            {"Самка", false}
        });
    }

    @Test
    public void checkManeDependOnSex() throws Exception {
        // создаю мок Feline что бы тест не ходил в класс Feline, а только в класс льва
        Feline felineMock = Mockito.mock(Feline.class);
        Lion lion = new Lion(felineMock, lionSex);
        Assert.assertEquals(expectedHasMane, lion.doesHaveMane());
    }

}
