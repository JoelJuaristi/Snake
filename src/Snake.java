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

    // TODO this method will be changed to a private method called by four others (moveLeft, moveRight, moveUp, MoveDown)
    public Boolean move(Integer xMovement, Integer yMovement)
    {
        Position head = positions.get(0);

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