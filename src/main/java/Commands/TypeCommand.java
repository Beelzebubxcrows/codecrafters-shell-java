package Commands;

import java.nio.file.Paths;
import java.util.HashMap;

import Utils.Constants;
import Utils.ShellUtils;

public class TypeCommand implements ICommand{

    
    @Override
    public String GetCommandString() {
        return Constants.TYPE_COMMAND_STRING;
    }

    

    @Override
    public boolean ExecuteCommand(String[] args, HashMap<String, ICommand> _commands) {
        
        String commandToKnowTypeOf = args[1];

        if(_commands.containsKey(commandToKnowTypeOf)){
            System.out.println(commandToKnowTypeOf+" is a shell builtin");
            return true;
        }

        if(getCommandFromPath(commandToKnowTypeOf)){
            return true;
        }
        

        ShellUtils.HandledNotFound(commandToKnowTypeOf);
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
