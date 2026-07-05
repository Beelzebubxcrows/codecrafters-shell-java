package Commands;
public interface ICommand {
public boolean IsCommandValid(String command);
public boolean ExecuteCommand(String[] args);

}
