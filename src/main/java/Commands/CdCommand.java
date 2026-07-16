package Commands;
import java.util.HashMap;

import Model.ShellState;
import Utils.Constants;
import Utils.ShellUtils;

public class CdCommand implements ICommand{

    @Override
    public String GetCommandString() {
        return Constants.CD_COMMAND_STRING;
    }

    @Override
    public boolean ExecuteCommand(String[] args, HashMap<String, ICommand> _commands) {
        
        String newWorkingDirectory = args[1];
        
        if(ShellUtils.DoesDirectoryExist(newWorkingDirectory)) {
            ShellState.CurrentDirectory = newWorkingDirectory;
        } else {
            System.out.println("cd: "+newWorkingDirectory+": No such file or directory");
        }

        return true;
    }

}
