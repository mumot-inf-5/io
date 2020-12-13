package put.io.testing.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @Test
    void testAdd() {
        assertEquals(5, calculator.add(3, 2) );
        assertEquals(-30, calculator.add(-12, -18) );
        assertEquals(-9, calculator.add(2, -11) );
        assertEquals(0, calculator.add(0, 0) );
    }

    @Test
    void testMultiply() {
        assertEquals(100, calculator.multiply(10, 10) );
        assertEquals(-8, calculator.multiply(2, -4) );
        assertEquals(0, calculator.multiply(0, 5) );
        assertEquals(25, calculator.multiply(-5, -5) );
    }

    @Test
    void testAddPositiveNumbers() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            assertEquals(1, calculator.addPositiveNumbers(-1, 2) );
        });
    }

    @BeforeEach
    public void setUp(){
        calculator=new Calculator();
    }
    // tak, przestalyby dzialac, poniewaz nowy kalkulator bylby tworzony tylko na poczatku
}