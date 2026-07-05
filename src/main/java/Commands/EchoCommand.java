package Commands;

import java.util.HashMap;

public class EchoCommand implements ICommand{


    private final String COMMAND_STRING = "echo";

    @Override
    public String GetCommandString() {
        return COMMAND_STRING;
    }


    @Override
    public boolean IsCommandValid(String command) {
        return command.equals(COMMAND_STRING);
    }

    @Override
    public boolean ExecuteCommand(String[] args, HashMap<String, ICommand> _commands) {
    
        for(String argument : args){
            System.out.print(argument+" ");
        }

        System.out.println();

        return true;
    }

}
