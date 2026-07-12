package Commands;

import java.util.HashMap;

import Utils.Constants;

public class EchoCommand implements ICommand{

    @Override
    public String GetCommandString() {
        return Constants.ECHO_COMMAND_STRING;
    }


    @Override
    public boolean ExecuteCommand(String[] args, HashMap<String, ICommand> _commands) {
    
        for(int index = 1; index<args.length; index++){
            System.out.print(args[index]+" ");
        }

        System.out.println();

        return true;
    }

}
