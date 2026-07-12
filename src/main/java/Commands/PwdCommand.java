package Commands;

import java.util.HashMap;

import Utils.Constants;

public class PwdCommand implements ICommand{

    @Override
    public String GetCommandString() {
        return Constants.PWD_COMMAND_STRING;
    }

    @Override
    public boolean ExecuteCommand(String[] args, HashMap<String, ICommand> _commands) {
        

        String currentDirectory =  System.getProperty("user.dir");
        System.out.println(currentDirectory);



        return true;
    }

}
