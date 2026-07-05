import java.util.ArrayList;
import java.util.List;

import Commands.ExitCommand;
import Commands.ICommand;

public class CommandAnalyser {

    private List<ICommand> _commands;
    
    CommandAnalyser(){
        _commands = new ArrayList<>();
        _commands.add(new ExitCommand());
    }

    public boolean AnalyseCommand(String commandString){

        String[] commandTokens = commandString.split(" ");
        String mainCommand = commandTokens[0];

        for(ICommand command : _commands){
            if(command.IsCommandValid(mainCommand)){
                return command.ExecuteCommand();
            }
        }
            
        handleCommandNotFound(mainCommand);
        return true;
    
    }




    private void handleCommandNotFound(String mainCommand){
        System.out.println(mainCommand+": command not found");
    }

}
