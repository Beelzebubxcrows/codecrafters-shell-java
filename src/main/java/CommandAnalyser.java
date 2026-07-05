import java.util.ArrayList;
import java.util.List;

import Commands.EchoCommand;
import Commands.ExitCommand;
import Commands.ICommand;

public class CommandAnalyser {

    private List<ICommand> _commands;
    
    CommandAnalyser(){
        _commands = new ArrayList<>();
        _commands.add(new ExitCommand());
        _commands.add(new EchoCommand());
    }

    public boolean AnalyseCommand(String commandString){

        String[] commandTokens = commandString.split(" ");

        String mainCommand = commandTokens[0];

        String[] arguments = new String[commandTokens.length-1];
        for(int i = 0; i<arguments.length; i++){
            arguments[i] = commandTokens[i+1];
        }

        for(ICommand command : _commands){
            if(command.IsCommandValid(mainCommand)){
                return command.ExecuteCommand(arguments);
            }
        }
            
        handleCommandNotFound(mainCommand);
        return true;
    
    }




    private void handleCommandNotFound(String mainCommand){
        System.out.println(mainCommand+": command not found");
    }

}
