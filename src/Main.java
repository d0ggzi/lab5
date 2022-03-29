import commands.CollectionManager;

import java.io.*;


public class Main {

    public static void main(String... args) throws IOException {
        MainApp mainapp = new MainApp(new CollectionManager("C:\\Users\\maks-\\GoogleDrive\\programming\\java\\lab5_all\\lab5.1\\src\\test.xml"));
//        MainApp mainapp = new MainApp(new CollectionManager(""));
        mainapp.start();
    }
}

//public class Main {
//    public static void main(String[] args){
//        try {
//            Scanner scan = new Scanner(new File("C:\\Users\\maks-\\GoogleDrive\\programming\\java\\lab5_all\\lab5.1\\src\\test.xml"));
//            while (scan.hasNextLine()) {
//                System.out.println(scan.nextLine());
//            }
//        }
//        catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
//    }
//}