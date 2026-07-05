package Commands;

public class EchoCommand implements ICommand{


    private final String COMMAND_STRING = "echo";

    @Override
    public String GetCommandString() {
        return COMMAND_STRING;
    }


    @Override
    public boolean IsCommandValid(String command) {
        return command.equals(COMMAND_STRING);
    }

    @Override
    public boolean ExecuteCommand(String[] args) {
    
        for(String argument : args){
            System.out.print(argument+" ");
        }

        System.out.println();

        return true;
    }

}
