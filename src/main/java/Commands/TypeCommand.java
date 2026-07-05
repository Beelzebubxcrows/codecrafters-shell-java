package Commands;

import java.util.HashMap;
import java.util.Map;

import Utils.ShellUtils;

public class TypeCommand implements ICommand{

    private final String COMMAND_STRING = "type";
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
        
        
        for(Map.Entry<String, ICommand> command : _commands.entrySet()){
            ICommand commandExecutor = command.getValue();
            if(commandExecutor.IsCommandValid(args[0])){
                System.out.println(args[0]+" is a shell builtin");
                return true;
            }
        }


        ShellUtils.HandleCommandNotFound(args[0]);
        return true;
    }

}
