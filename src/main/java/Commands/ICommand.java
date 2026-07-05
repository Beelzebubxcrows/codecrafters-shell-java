package Commands;
public interface ICommand {
    
    public String GetCommandString();
    public boolean IsCommandValid(String command);
    public boolean ExecuteCommand(String[] args);

}
