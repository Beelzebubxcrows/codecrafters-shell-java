package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

public class ShellUtils {


    public static void HandleCommandNotFound(String mainCommand){
        System.out.println(mainCommand+": command not found");
    }

    public static void HandledNotFound(String mainCommand){
        System.out.println(mainCommand+": not found");
    }

    
    public static boolean IsFilePresentAtLocation(String filePathString){
        File f = new File(filePathString);
        if(f.exists() && !f.isDirectory()) { 
            return true;
        }
        return false;
    }

    public static boolean FileHasExecutePermissions(String filePath) {
        File f = new File(filePath);
        return f.canExecute();
    }


    public static void ExecuteShellCommand(List<String> command){


        ProcessBuilder processBuilder = new ProcessBuilder(command);

        try {
            // Start the process
            Process process = processBuilder.start();

            // Read the output from the command
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
