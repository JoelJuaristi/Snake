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
                if( head.x != lengthX - 1 )
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
                if( head.y != lengthY - 1 )
                {
                    head.y = head.y + yMovement; 
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

            positions.remove(positions.size()-1);
            if(collisionWithItself(head))
            {
                return false;
            }
            else
            {
                positions.add(0, head);
                
                movementsNumber++;
                return true;
            }
        }
    }

    private Boolean collisionWithItself(Position newHead)
    {
        for(Position currentPosition : positions)
        {
            if(currentPosition.x == newHead.x && currentPosition.y == newHead.y)
            {
                return true;
            }
        }

        return false;
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
            alternativeSnakes.clear();
            for(Snake snakeToCopy : nextSnakes)
            {
                alternativeSnakes.add(duplicateSnake(snakeToCopy));
            }
            halt = alternativeSnakes.get(0).checkEnding(depth);
        }while(halt != true);

        return alternativeSnakes.size();
    }

    private ArrayList<Snake> checkSnakeMoves (Snake snake) throws Snake.SnakeException
    {

        ArrayList<Snake> possibleSnakes = new ArrayList<Snake>();
        Snake snakeLeft = duplicateSnake(snake);
        Snake snakeRight = duplicateSnake(snake);
        Snake snakeUp = duplicateSnake(snake);
        Snake snakeDown = duplicateSnake(snake);
        if(snakeLeft.moveLeft())
        {
            possibleSnakes.add(snakeLeft);
        }
        if(snakeRight.moveRight())
        {
            possibleSnakes.add(snakeRight);
        }
        if(snakeUp.moveUp())
        {
            possibleSnakes.add(snakeUp);
        }
        if(snakeDown.moveDown())
        {
            possibleSnakes.add(snakeDown);
        }
        return possibleSnakes;
    }

    private Snake duplicateSnake(Snake snake)
    {
        Snake copiedSnake = new Snake(snake.lengthX, snake.lengthY);
        for(Integer i=0;i<snake.positions.size();i++)
        {
            copiedSnake.positions.add(new Position(snake.positions.get(i).x, snake.positions.get(i).y));
        }
        copiedSnake.movementsNumber = snake.movementsNumber;
        return copiedSnake;
    }

    private Boolean checkEnding(Integer depth)
    {
        return movementsNumber == depth;
    }

    private class SnakeException extends Exception
    {
        public SnakeException (String errorMessage)
        {
            super(errorMessage);
        }
    }
}
