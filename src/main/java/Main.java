import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    
    public static void main(String[] args) throws Exception {
        

        CommandAnalyser commandAnalyser = new CommandAnalyser();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        boolean shouldLoop = true;
        while(shouldLoop) {
            System.out.print("$ ");
            String userInput = bufferedReader.readLine();
            shouldLoop = commandAnalyser.AnalyseCommand(userInput);
        }

    }
}
