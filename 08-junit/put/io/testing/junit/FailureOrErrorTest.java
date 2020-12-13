package put.io.testing.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FailureOrErrorTest {
    @Test
    public void  test1(){
        assertEquals(2, 1 );
        //failure

    }

    @Test
    public void  test2() throws Exception {
        throw new Exception("Exception message");
        //error
    }

    @Test
    public void test3(){
        try {
            assertEquals(2, 1 );
        }
        catch (AssertionError  e){
            e.printStackTrace();
        }
    }
}
