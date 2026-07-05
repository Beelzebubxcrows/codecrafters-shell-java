import java.util.HashSet;

public class CommandValidator {

    private static HashSet<String> validCommands = new HashSet<String>();

    public static boolean IsCommandValid(String command){

        return validCommands.contains(command);

    }
}
