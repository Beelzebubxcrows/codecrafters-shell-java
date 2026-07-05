package Commands;

import java.util.HashMap;

import Utils.ShellUtils;

public class TypeCommand implements ICommand{

    private final String COMMAND_STRING = "type";
    @Override
    public String GetCommandString() {
        return COMMAND_STRING;
    }

    

    @Override
    public boolean ExecuteCommand(String[] args, HashMap<String, ICommand> _commands) {
        
        if(_commands.containsKey(args[0])){
            System.out.println(args[0]+" is a shell builtin");
            return true;
        }
        


        ShellUtils.HandledNotFound(args[0]);
        return true;
    }

}
