import ro.ase.cts.after.classes.CommandLine;
import ro.ase.cts.after.classes.Gui;

public class NewMain {

    public static void main(String[] args){

        Runnable r = ()->{
            Gui gui = new Gui();
        };
        new Thread(r).start();
        CommandLine commandLine = new CommandLine();

    }

}
