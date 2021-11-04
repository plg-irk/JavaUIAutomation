package com.geekbrfins.lesson4;

import org.junit.jupiter.api.*;

public class TriangleTest {

    @BeforeAll
    static void beforeMethod() {
        System.out.printf("Выполняется один раз");
    }

    @BeforeEach
    void beforeEachMethod() {
        System.out.printf("Выполняется каждый раз перед тестом");
    }

    @Test
    @DisplayName("Пояснение теста")
    void givenCheckThan(){
        System.out.printf("Тест");
    }


    @AfterEach
    void afterEach(){
        System.out.printf("Выполняется после каждого теста");
    }

    @AfterAll
    static void afterAll(){
        System.out.printf("Выполняется после всех тестов");
    }

}


