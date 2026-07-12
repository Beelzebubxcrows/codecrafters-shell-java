package Commands;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Utils.ShellUtils;

public class ExecutableCommand implements ICommand{
    
    private final String COMMAND_STRING = "exec";

    @Override
    public String GetCommandString() {
        return COMMAND_STRING;
    }

    @Override
    public boolean ExecuteCommand(String[] args, HashMap<String, ICommand> _commands) {
        
        List<String> args1 = new ArrayList<>();
        for(String s : args){
            args1.add(s);
        }
        ShellUtils.ExecuteShellCommand(args1);

        return true;
        

    } 

    private String getCommandFromPath(String mainCommand){

        String[] paths = System.getenv("PATH").split(":");

        for(String path : paths){
            String filePath = Paths.get(path,mainCommand).toString();
            boolean isFilePresent = ShellUtils.IsFilePresentAtLocation(filePath);
            if(isFilePresent){
                if(ShellUtils.FileHasExecutePermissions(filePath)){
                    return filePath;
                }
            }


        }


        return "";
    }

}
