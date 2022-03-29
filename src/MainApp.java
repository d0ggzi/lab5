import java.io.IOException;
import java.util.*;

public class MainApp  {

    private CollectionManager manager;
    private LinkedList<String> lastCommands;

    public MainApp(CollectionManager manager){
        this.manager = manager;
    }

    public void start() throws IOException {
        this.lastCommands = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        while (true){
            String[] userCommand = scan.nextLine().trim().split(" ", 2);
            try {
                if (lastCommands.size() == 6){
                    lastCommands.removeFirst();
                }
                lastCommands.addLast(userCommand[0]);
                switch(userCommand[0]){
                    case "help":
                        manager.help();
                        break;
                    case "info":
                        manager.info();
                        break;
                    case "show":
                        manager.show();
                        break;
                    case "add":
                        manager.add();
                        break;
                    case "update":
                        manager.update(Long.parseLong(userCommand[1]));
                        break;
                    case "remove_by_id":
                        manager.remove_by_id(Long.parseLong(userCommand[1]));
                        break;
                    case "clear":
                        manager.clear();
                        break;
                    case "save":
                        manager.save();
                        break;
                    case "exit":
                        System.exit(1);
                    case "add_if_min":
                        manager.add_if_min();
                        break;
                    case "remove_lower":
                        manager.remove_lower();
                    case "history":
                        lastCommands.removeLast();
                        System.out.println(lastCommands);
                        break;
                    case "filter_contains_name":
                        manager.filter_contains_name(userCommand[1]);
                        break;
                    case "filter_greater_than_type":
                        manager.filter_greater_than_type(Integer.parseInt(userCommand[1]));
                        break;
                    case "print_field_descending_type":
                        manager.print_field_descending_type();
                        break;
                    default:
                        lastCommands.removeLast();
                        System.out.println("Неопознанная команда. Наберите 'help' для справки.");
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Отсутствует аргумент. Наберите 'help' для справки.");
            }
        }
    }
}

//TODO фиксить работу с пустой коллекцией, неверный формат и тип аргумента. 