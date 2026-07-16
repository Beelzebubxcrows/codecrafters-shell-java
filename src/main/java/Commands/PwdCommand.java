package Commands;

import java.util.HashMap;

import Model.ShellState;
import Utils.Constants;

public class PwdCommand implements ICommand{

    @Override
    public String GetCommandString() {
        return Constants.PWD_COMMAND_STRING;
    }

    @Override
    public boolean ExecuteCommand(String[] args, HashMap<String, ICommand> _commands) {
        
        System.out.println(ShellState.CurrentDirectory);

        return true;
    }

}
