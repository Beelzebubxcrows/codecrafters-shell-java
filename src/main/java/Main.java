import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception {

        CommandAnalyser commandAnalyser = new CommandAnalyser();

        System.out.print("$ ");
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = bufferedReader.readLine();
        commandAnalyser.AnalyseCommand(userInput);

    }
}
