package com.geekbrfins;

import com.geekbrains.lesson4.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {

    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @ParameterizedTest
    @CsvSource({"3,4,5,6", "3,4,10,0", "3,10,5,0","10,4,5,0"})
    @DisplayName("Позитивые проверки")
    public void rigorousTest() {
        double result = Triangle.sumNumbers(3, 4, 5);
        Assertions.assertEquals(result, 6.0);
    }

}
