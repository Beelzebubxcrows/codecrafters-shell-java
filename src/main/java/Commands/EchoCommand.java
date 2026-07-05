package Commands;

public class EchoCommand implements ICommand{

    @Override
    public boolean IsCommandValid(String command) {
        return command.equals("echo");
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
