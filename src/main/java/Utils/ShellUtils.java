package Utils;

import java.io.File;

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


}
