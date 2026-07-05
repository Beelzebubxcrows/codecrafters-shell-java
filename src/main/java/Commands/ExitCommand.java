package Commands;

import java.util.HashMap;

public class ExitCommand implements ICommand{

    private final String COMMAND_STRING = "exit";

    @Override
    public String GetCommandString() {
        return COMMAND_STRING;
    }


    @Override
    public boolean ExecuteCommand(String[] args, HashMap<String, ICommand> _commands) {
        return false;
    }

}
