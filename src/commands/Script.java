package commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;



















import java.nio.file.Paths;
import java.util.*;

public class Script {
    private Command cmd = new Command();

    public void Script(String filepath, CollectionManager manager){
        if (noCycle(filepath)){
            File file = new File(filepath);
            Scanner scanner = null;
            try{
                scanner = new Scanner(file);
                while (scanner.hasNextLine()){
                    String line = scanner.nextLine().trim();
                    if (line.equals("")){
                        continue;
                    }
                    try{
                        String[] userCmd = line.split(" ", 2);
                        cmd.Command(userCmd, manager);
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Ошибка при выполнении, попробуйте снова.");
                        break;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден, попробуйте снова.");
            }
        }

    }

    boolean flag = false;

    public boolean noCycle(String filepath) {
        try {
            HashSet<String> paths = new HashSet<>();
            findAllPathForScript(paths, filepath);
            if (flag) {
                System.out.println("В файле существует цикл, запуск невозможен, попробуйте снова.");
                return false;
            }
            else {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Неправильный аргумент, попробуйте снова.");
        }catch (IOException e){
            System.out.println("Файл не найден или недостаточно прав для запуска, попробуйте снова.");
        }
        return false;
    }


    public void findAllPathForScript(HashSet<String> set, String path) throws IOException {
        set.add(path.toLowerCase(Locale.ROOT));
        LinkedHashSet<String> set1 = new LinkedHashSet<>();
        if (flag){
            return;
        }
        try {
            List<String> allLines = Files.readAllLines(Paths.get(path));
            for (String s : allLines) {
                if (s.contains("execute_script") && s.contains(".txt")) {
                    String[] line = s.split(" ");
                    set1.add(line[1].toLowerCase(Locale.ROOT));
                }
            }
            for (String str : set1) {
                if (!set.contains(str)) {
                    findAllPathForScript(set, str);
                } else {
                    flag = true;
                    return;
                }
            }
        }catch (ConcurrentModificationException e) {
            System.out.print("");
        }
    }
}
