package TestLibrary;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LifecycleTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Hello I'm the before all method"); // wykonuje się przed wszystkimi testami - musi być static
    }

    @BeforeEach
    void setup(){
        System.out.println("I am here before each test"); // wykonuje się przed każdym testsem
    }

    @Test
    void firstTest(){

        System.out.println("I am the first test");

    }

    @Test
    void secondTest(){
        System.out.println("I am the second test");
    }

    @Test
    void thirdTest(){
        System.out.println("I am the third test");
    }

    @AfterEach
    void after(){
        System.out.println("I am here after each test"); // wykonuje się po każdym teście
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Hello, I am executed after all tests"); // wykonuje się po wszystkich testach - musi być static
    }
}
