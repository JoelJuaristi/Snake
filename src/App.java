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
    }
}
