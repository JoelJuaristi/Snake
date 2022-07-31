public class Parser {

    public static Position parsePairOfNumbers(String param)
    {
        String [] values = param.split(",");
        return new Position(Integer.valueOf(values[0]), Integer.valueOf(values[1]));
    }
}
