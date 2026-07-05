package Commands;

import java.util.HashMap;

public interface ICommand {
    
    public String GetCommandString();
    public boolean IsCommandValid(String command);
    public boolean ExecuteCommand(String[] args, HashMap<String, ICommand> _commands);

}
