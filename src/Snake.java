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
}