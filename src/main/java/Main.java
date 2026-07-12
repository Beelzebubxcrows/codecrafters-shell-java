import java.io.BufferedReader;
import java.io.InputStreamReader;

import Utils.Constants;


public class Main {

    
    public static void main(String[] args) throws Exception {
        

        CommandAnalyser commandAnalyser = new CommandAnalyser();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            
            System.out.print("$ ");
            String userInput = bufferedReader.readLine();
            
            String[] commandTokens = userInput.split(" ");
            if(commandTokens.length>0 && commandTokens[0].equals(Constants.EXIT_COMMAND_STRING)){
                break;
            }
            
            commandAnalyser.AnalyseCommand(commandTokens);
        }

    }
}
