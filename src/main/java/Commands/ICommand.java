package Commands;

import java.util.HashMap;

public interface ICommand {
    
    public String GetCommandString();
    public boolean ExecuteCommand(String[] args, HashMap<String, ICommand> _commands);

}
