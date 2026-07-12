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
        
        String filePath = getCommandFromPath(args[0]);System.out.println(filePath);
        if(!filePath.isEmpty()){
            List<String> argumentlist = new ArrayList<>();
            
            for(String str : args){
                argumentlist.add(str);
            }

            ShellUtils.ExecuteShellCommand(argumentlist);
            return true;
        }

        return false;
    } 



    private String getCommandFromPath(String mainCommand){

        System.out.println(System.getenv("PATH")+" "+mainCommand);
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
