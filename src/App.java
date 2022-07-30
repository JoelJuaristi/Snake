public class App 
{
    public static void main(String[] args) throws Exception 
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
            System.out.println(numberOfPaths);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }

        Snake snake2 = new Snake(2, 3);

        snake2.addPosition(new Position(0, 2));
        snake2.addPosition(new Position(0, 1));
        snake2.addPosition(new Position(0, 0));
        snake2.addPosition(new Position(1, 0));
        snake2.addPosition(new Position(1, 1));
        snake2.addPosition(new Position(1, 2));

        try{
            Integer numberOfPaths = snake2.checkOptions(10);
            System.out.println(numberOfPaths);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }

        Snake snake3 = new Snake(10, 10);

        snake3.addPosition(new Position(5, 5));
        snake3.addPosition(new Position(5, 4));
        snake3.addPosition(new Position(4, 4));
        snake3.addPosition(new Position(4, 5));

        try{
            Integer numberOfPaths = snake3.checkOptions(4);
            System.out.println(numberOfPaths);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}
