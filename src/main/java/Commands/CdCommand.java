package Commands;
import java.nio.file.Paths;
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
        
        boolean isRelativePath = false;

        String newWorkingDirectory = args[1];
        String[] newWorkingDirectoryTokens = newWorkingDirectory.split("/");


        String[] currentDirectoryTokens = ShellState.CurrentDirectory.split("/");
        int currentDirectoryPointer = currentDirectoryTokens.length-1;

        
        int newWorkingDirectoryPointer = 0;
        for(String token : newWorkingDirectoryTokens){
            
            if(token.isBlank()){
                newWorkingDirectoryPointer++;
            }
            else if(token.equals("..")){
                currentDirectoryPointer--;
                newWorkingDirectoryPointer++;
                isRelativePath = true;
            } 
            else if(token.equals(".")){
                newWorkingDirectoryPointer++;
                isRelativePath = true;
            } 
            else {
                break;
            }
        }
        
        String path = "/";

        if(isRelativePath){
            
            for(int i = 0; i<=currentDirectoryPointer; i++){
                if(currentDirectoryTokens[i].isEmpty()){
                    continue;
                }
                path = Paths.get(path,currentDirectoryTokens[i]).toString();
                
            }
        
            for(int i= newWorkingDirectoryPointer; i<newWorkingDirectoryTokens.length; i++){
            
                if(newWorkingDirectoryTokens[i].isEmpty()){
                    continue;
                }
            
                path = Paths.get(path,newWorkingDirectoryTokens[i]).toString();
                
            }
        } else {
            path = newWorkingDirectory;
            
        }
        
        
        if(ShellUtils.DoesDirectoryExist(path)) {
            ShellState.CurrentDirectory = path;
        } else {
            System.out.println("cd: "+newWorkingDirectory+": No such file or directory");
        }

        return true;
    }

}
