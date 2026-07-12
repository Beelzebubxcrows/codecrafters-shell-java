import java.util.HashMap;

import Commands.EchoCommand;
import Commands.ExecutableCommand;
import Commands.ICommand;
import Commands.TypeCommand;
import Utils.ShellUtils;

public class CommandAnalyser {

    private HashMap<String, ICommand> _builtInCommands;
    private ExecutableCommand _executeCommand = new ExecutableCommand();

    CommandAnalyser(){
        _builtInCommands = new HashMap<>();

        EchoCommand echoCommand = new EchoCommand();
        _builtInCommands.put(echoCommand.GetCommandString(), echoCommand);

        TypeCommand typeCommand = new TypeCommand();
        _builtInCommands.put(typeCommand.GetCommandString(), typeCommand);
    }

    public void AnalyseCommand(String[] commandTokens){

        String mainCommand = commandTokens[0];

    
        if(_builtInCommands.containsKey(mainCommand)){
            ICommand commanExecutor = _builtInCommands.get(mainCommand);
            commanExecutor.ExecuteCommand(commandTokens, _builtInCommands);
            
            return;
        } 

        
        Boolean wasExecutableFound = _executeCommand.ExecuteCommand(commandTokens, _builtInCommands);
        if(wasExecutableFound){
            return;
        }
        
            
        ShellUtils.HandleCommandNotFound(mainCommand);
    }

}
