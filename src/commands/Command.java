package commands;

import java.util.LinkedList;
public class Command {
    private LinkedList<String> lastCommands;
    {
        lastCommands = new LinkedList<>();
    }
    public void Command(String[] userCommand, CollectionManager manager) {
        try {
            if (lastCommands.size() == 6) {
                lastCommands.removeFirst();
            }
            lastCommands.addLast(userCommand[0]);
            switch (userCommand[0]) {
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
                case "execute_script":
                    manager.execute_script(userCommand[1], manager);
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
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Отсутствует аргумент. Наберите 'help' для справки.");
        }
    }
}
