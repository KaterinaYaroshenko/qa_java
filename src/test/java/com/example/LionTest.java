package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensReturnsCorrectValue() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expected = 1;
        int actual = lion.getKittens();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFoodReturnsCorrectList() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void lionConstructorThrowsExceptionOnInvalidSex() throws Exception {
        new Lion(feline, "Нечто среднее");
    }
}