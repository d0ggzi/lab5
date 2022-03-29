import commands.CollectionManager;
import commands.Command;

import java.io.IOException;
import java.util.*;

public class MainApp  {

    private CollectionManager manager;
    private Command cmd = new Command();

    public MainApp(CollectionManager manager){
        this.manager = manager;
    }

    public void start() throws IOException {
        Scanner scan = new Scanner(System.in);
        while (true){
            String[] userCommand = scan.nextLine().trim().split(" ", 2);
            cmd.Command(userCommand, manager);
        }
    }
}
