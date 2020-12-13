package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookTest {
    private Customer customer;
    private Audiobook audiobook;
    private AudiobookPriceCalculator calculator;
    // 4 mozliwe sciezki dzialania

    @Test
    public void test1(){
        customer=new Customer("ABC", Customer.LoyaltyLevel.STANDARD,true);
        assertEquals( calculator.calculate(customer, audiobook),0.0);
    }
    @Test
    public void test2(){
        customer=new Customer("ABC", Customer.LoyaltyLevel.SILVER,false);
        calculator.calculate(customer, audiobook);
        assertEquals( calculator.calculate(customer, audiobook),audiobook.getStartingPrice()*0.9);
    }
    @Test
    public void test3(){
        customer=new Customer("ABC", Customer.LoyaltyLevel.GOLD,false);
        calculator.calculate(customer, audiobook);
        assertEquals( calculator.calculate(customer, audiobook),audiobook.getStartingPrice()*0.8);
    }
    @Test
    public void test4(){
        customer=new Customer("ABC", Customer.LoyaltyLevel.STANDARD,false);
        calculator.calculate(customer, audiobook);
        assertEquals( calculator.calculate(customer, audiobook), audiobook.getStartingPrice());
    }

    @BeforeEach
    public void setUp(){
        audiobook=new Audiobook("Start",111);
        calculator=new AudiobookPriceCalculator();
    }

}