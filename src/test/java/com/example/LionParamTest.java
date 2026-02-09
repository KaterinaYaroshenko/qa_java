package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionParamTest {

    private final String sex;
    private final boolean expectedHasMane;

    public LionParamTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getLionData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void shouldHaveManeCheck() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, sex);
        boolean actualHasMane = lion.doesHaveMane();
        Assert.assertEquals(expectedHasMane, actualHasMane);
    }
}
