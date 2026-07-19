package Commands;
import java.nio.file.Path;
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
        
        String newWorkingDirectory = args[1];
        String[] newWorkingDirectoryTokens = newWorkingDirectory.split("/");


        Path path = Paths.get("");

        
        for(String token : newWorkingDirectoryTokens){
            if(token.equals("..")){       
                if(path.toString().equals(""))         {
                    path = Paths.get(ShellState.CurrentDirectory);
                }
                path = path.getParent();
            } 
            else if(token.equals("~")){
                path = Paths.get(System.getenv("HOME"));
            }
            else if(token.equals(".")){
                if(path.toString().isEmpty()){
                    path = Paths.get(ShellState.CurrentDirectory);
                }
            }
            else {
                if(path.toString().isEmpty()){
                    path = Paths.get("/");
                }
                path = Paths.get(path.toString(), token);
            }
        }
        

        if(ShellUtils.DoesDirectoryExist(path.toString())) {
            ShellState.CurrentDirectory = path.toString();
        } else {
            System.out.println("cd: "+newWorkingDirectory+": No such file or directory");
        }

        return true;
    }

}
