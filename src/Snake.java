import java.util.ArrayList;

class Snake
{
    public ArrayList<Position> positions;
    private Integer lengthX;
    private Integer lengthY;
    private Integer movementsNumber;
    
    public Snake(Integer lengthX, Integer lengthY)
    {
        this.positions = new ArrayList<Position>();
        this.lengthX = lengthX;
        this.lengthY = lengthY;
        this.movementsNumber = 0;
    }

    public Snake(Snake originalSnake)
    {
        this.positions = originalSnake.positions;
        this.lengthX = originalSnake.lengthX;
        this.lengthY = originalSnake.lengthY;
        this.movementsNumber = originalSnake.movementsNumber;
    }

    public void addPosition(Integer x, Integer y)
    {
        positions.add(new Position(x,y));
    }

    public void addPosition(Position position)
    {
        positions.add(position);
    }

    public Boolean moveLeft() throws Snake.SnakeException
    {
        return move(-1,0);
    }
    public Boolean moveRight() throws Snake.SnakeException
    {
        return move(1,0);
    }
    public Boolean moveUp() throws Snake.SnakeException
    {
        return move(0,-1);
    }
    public Boolean moveDown() throws Snake.SnakeException
    {
        return move(0,1);
    }

    private Boolean move(Integer xMovement, Integer yMovement) throws Snake.SnakeException
    {

        if(xMovement != 0 && yMovement != 0)
        {
            // Both parameters are active, snake can't move diagonally
            throw new SnakeException("Snake can't move diagonally!!");
        }
        else
        {
            // Using directly positions.get(0) keeps the reference so we need a new instance
            Position head = new Position(positions.get(0).x, positions.get(0).y);
    
            if(xMovement > 0)
            {
                // Moves to the right
                if( head.x != lengthX )
                {
                    head.x = head.x + xMovement; 
                }
                else
                {
                    // In the border and tries to move that way
                    return false;
                }
            }
            else if (xMovement < 0)
            {
                // Moves to the left
                if( head.x != 0 )
                {
                    head.x = head.x + xMovement; 
                }
                else
                {
                    // In the border and tries to move that way
                    return false;
                }
            }
    
            if(yMovement > 0)
            {
                // Moves upwards
                if( head.y != lengthY )
                {
                    head.y = head.y + xMovement; 
                }
                else
                {
                    // In the border and tries to move that way
                    return false;
                }
            }
            else if (yMovement < 0)
            {
                // Moves downwards
                if( head.y != 0 )
                {
                    head.y = head.y + yMovement; 
                }
                else
                {
                    // In the border and tries to move that way
                    return false;
                }
            }
    
            positions.add(0, head);
            positions.remove(positions.size()-1);
            movementsNumber++;
            return true;
        }
    }

    public Integer checkOptions(Integer depth) throws Snake.SnakeException
    {
        Boolean halt = false;
        ArrayList<Snake> alternativeSnakes = checkSnakeMoves(this);
        do
        {
            ArrayList<Snake> nextSnakes = new ArrayList<Snake>();
            for(Snake currentSnake : alternativeSnakes)
            {
                nextSnakes.addAll(checkSnakeMoves(currentSnake));
            }
            alternativeSnakes = nextSnakes;
            halt = alternativeSnakes.get(0).checkEnding(depth);
        }while(halt != true);

        return alternativeSnakes.size();
    }

    private ArrayList<Snake> checkSnakeMoves (Snake snake) throws Snake.SnakeException
    {
        ArrayList<Snake> possibleSnakes = new ArrayList<Snake>();
        Snake snakeLeft = new Snake(snake);
        if(snakeLeft.moveLeft())
        {
            possibleSnakes.add(snakeLeft);
        }
        Snake snakeRight = new Snake(snake);
        if(snakeRight.moveRight())
        {
            possibleSnakes.add(snakeRight);
        }
        Snake snakeUp = new Snake(snake);
        if(snakeUp.moveUp())
        {
            possibleSnakes.add(snakeUp);
        }
        Snake snakeDown = new Snake(snake);
        if(snakeDown.moveLeft())
        {
            possibleSnakes.add(snakeDown);
        }
        return possibleSnakes;
    }

    private Boolean checkEnding(Integer depth)
    {
        // All of the snakes are supposed to have moved the same amount of times, if the depth is 3, the value of movementsNumber will be 2 [0->1->2].
        return movementsNumber == depth-1;
    }

    private class SnakeException extends Exception
    {
        public SnakeException (String errorMessage)
        {
            super(errorMessage);
        }
    }
}
