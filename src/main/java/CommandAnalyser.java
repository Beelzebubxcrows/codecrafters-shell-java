public class CommandAnalyser {


    public void AnalyseCommand(String command){

        String[] commandTokens = command.split(" ");
        String mainCommand = commandTokens[0];

        boolean IsCommandValid = CommandValidator.IsCommandValid(mainCommand);

        if(!IsCommandValid){
            handleCommandNotFound(mainCommand);
            return;
        }
    

    }




    private void handleCommandNotFound(String mainCommand){
        System.out.println(mainCommand+": command not found");
    }

}
