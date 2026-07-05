package Commands;
public class ExitCommand implements ICommand{

    @Override
    public boolean IsCommandValid(String command) {
        return command.equals("exit");
    }

    @Override
    public boolean ExecuteCommand() {
        return false;
    }

}
