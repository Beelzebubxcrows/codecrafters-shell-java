package Commands;

public class TypeCommand implements ICommand{

    private final String COMMAND_STRING = "type";
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
        
        return true;
    }

}
