package Commands;

import java.nio.file.Path;
import java.nio.file.Paths;
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

        if(getCommandFromPath(args[0])){
            return true;
        }
        


        ShellUtils.HandledNotFound(args[0]);
        return true;
    }

    private boolean getCommandFromPath(String mainCommand){

        String[] paths = System.getenv("PATH").split(":");

        for(String path : paths){
            String filePath = Paths.get(path,mainCommand).toString();
            boolean isFilePresent = ShellUtils.IsFilePresentAtLocation(filePath);
            if(isFilePresent){
                if(ShellUtils.FileHasExecutePermissions(filePath)){
                    System.out.println(mainCommand+" is "+filePath);
                    return true;
                }
            }


        }


        return false;
    }


    
}
