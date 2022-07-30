import java.util.List;
import java.util.ArrayList;
class Snake
{
    public ArrayList<Position> positions;
    private Integer lengthX;
    private Integer lengthY;
    
    public Snake(Integer lengthX, Integer lengthY)
    {
        this.positions = new ArrayList<Position>();
        this.lengthX = lengthX;
        this.lengthY = lengthY;
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
            return true;
        }
    }

    public class SnakeException extends Exception
    {
        public SnakeException (String errorMessage)
        {
            super(errorMessage);
        }
    }
}
