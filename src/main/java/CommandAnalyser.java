import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Commands.EchoCommand;
import Commands.ExitCommand;
import Commands.ICommand;
import Commands.TypeCommand;
import Utils.ShellUtils;

public class CommandAnalyser {

    private HashMap<String, ICommand> _commands;
    
    CommandAnalyser(){
        _commands = new HashMap<>();

        ExitCommand exitCommand = new ExitCommand();
        _commands.put(exitCommand.GetCommandString(), exitCommand);

        EchoCommand echoCommand = new EchoCommand();
        _commands.put(echoCommand.GetCommandString(), echoCommand);

        TypeCommand typeCommand = new TypeCommand();
        _commands.put(typeCommand.GetCommandString(), typeCommand);
    }

    public boolean AnalyseCommand(String commandString){

        String[] commandTokens = commandString.split(" ");

        String mainCommand = commandTokens[0];

        String[] arguments = new String[commandTokens.length-1];
        for(int i = 0; i<arguments.length; i++){
            arguments[i] = commandTokens[i+1];
        }

        for(Map.Entry<String, ICommand> command : _commands.entrySet()){

            ICommand commanExecutor = command.getValue();
            if(commanExecutor.IsCommandValid(mainCommand)){
                return commanExecutor.ExecuteCommand(arguments, _commands);
            }
        }
            
        ShellUtils.HandleCommandNotFound(mainCommand);
        return true;
    
    }

}
