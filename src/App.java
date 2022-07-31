import java.util.Scanner;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        Position coordinates;
        Boolean repeat = false;
        String paramString;
        // We initialize the snake to a void grid so it doesn't throw an error due to being declared inside a try statement
        // We know it's never going to be null after the first do while loop
        Snake snake = new Snake(0,0);
        Scanner scanner = new Scanner(System.in);
        System.out.println("To build a scenario follow the instructions, first the dimensions of the grid will be introduced, then" +
        "the positions filled by the snake, and in the end, the number of movements the snake will have to make");
        do
        {
            System.out.println("Please introduce the dimensions separated with commas, the first one is the x axis, and the second one the y axis. Example: 1,2");
            paramString = scanner.nextLine();
            try
            {
                coordinates = Parser.parsePairOfNumbers(paramString);
                snake = new Snake(coordinates.x, coordinates.y);
                repeat = false;
            }
            catch(Exception ex)
            {
                // If the parsing doesn't go right it means the format is not correct
                repeat = true;
                System.out.println("The format is not correct, please introduce the coordinates as in the example");
            }
        }while (repeat);
        

        System.out.println("The positions filled by the snake will be introduced on by one starting from the head. Example: 1,2");
        do
        {
            System.out.println("To stop introducing positions please type an asterisk \"*\"");
            System.out.println("Please, type the coordinates of the position:");
            paramString = scanner.nextLine();
            try
            {
                if(!paramString.contains("*"))
                {
                    coordinates = Parser.parsePairOfNumbers(paramString);
                    snake.addPosition(coordinates);
                }
                repeat = false;
            }
            catch(Exception ex)
            {
                // If the parsing doesn't go right it means the format is not correct
                repeat = true;
                System.out.println("The format is not correct, please introduce the coordinates as in the example");
            }
        }while(!paramString.contains("*") || repeat);
        
        System.out.println("Please, type the number of movements the snake will have to make:");
        paramString = scanner.nextLine();

        do{
            try{
                Integer numberOfPaths = snake.checkOptions(Integer.valueOf(paramString));
                System.out.println("Number of paths: " +numberOfPaths);
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }while(repeat);
    }
}
