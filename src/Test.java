import org.junit.Test;
import static org.junit.Assert.*;

public class Test {

    // As we are given 3 examples of this process with the expected result, we can test the whole process at once
    @Test
    public static void acceptanceTest1()
    {
        Snake snake = new Snake(4, 3);

        snake.addPosition(new Position(2, 2));
        snake.addPosition(new Position(3, 2));
        snake.addPosition(new Position(3, 1));
        snake.addPosition(new Position(3, 0));
        snake.addPosition(new Position(2, 0));
        snake.addPosition(new Position(1, 0));
        snake.addPosition(new Position(0, 0));
 
        try{
            Integer numberOfPaths = snake.checkOptions(3);
            assertEquals(7,numberOfPaths);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    @Test
    public static void acceptanceTest2()
    {
        Snake snake = new Snake(2, 3);

        snake.addPosition(new Position(0, 2));
        snake.addPosition(new Position(0, 1));
        snake.addPosition(new Position(0, 0));
        snake.addPosition(new Position(1, 0));
        snake.addPosition(new Position(1, 1));
        snake.addPosition(new Position(1, 2));
 
        try{
            Integer numberOfPaths = snake.checkOptions(10);
            assertEquals(1,numberOfPaths);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    @Test
    public static void acceptanceTest3()
    {
        Snake snake = new Snake(10, 10);

        snake.addPosition(new Position(5, 5));
        snake.addPosition(new Position(5, 4));
        snake.addPosition(new Position(4, 4));
        snake.addPosition(new Position(4, 5));
 
        try{
            Integer numberOfPaths = snake.checkOptions(4);
            assertEquals(81,numberOfPaths);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}
