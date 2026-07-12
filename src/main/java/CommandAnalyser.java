import java.util.HashMap;

import Commands.EchoCommand;
import Commands.ExecutableCommand;
import Commands.ICommand;
import Commands.PwdCommand;
import Commands.TypeCommand;
import Utils.Constants;
import Utils.ShellUtils;

public class CommandAnalyser {

    private HashMap<String, ICommand> _builtInCommands;
    private ExecutableCommand _executeCommand = new ExecutableCommand();

    CommandAnalyser(){
        _builtInCommands = new HashMap<>();

        _builtInCommands.put(Constants.ECHO_COMMAND_STRING, new EchoCommand());

        _builtInCommands.put(Constants.TYPE_COMMAND_STRING, new TypeCommand());

        _builtInCommands.put(Constants.EXIT_COMMAND_STRING, null);

        _builtInCommands.put(Constants.PWD_COMMAND_STRING, new PwdCommand());
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
