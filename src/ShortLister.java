import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ShortLister {

    public static void main(String[] args) {

        //ArrayList<Filter> sWDetector = new ArrayList<>();
        Filter filter = new ShortWordFilter();

        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");

        chooser.setCurrentDirectory(target.toFile());

        try {
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                target = chooser.getSelectedFile().toPath();

                inFile = new Scanner(target);

                while (inFile.hasNextLine()){
                    line = inFile.nextLine();
                    String[] words = line.split(" "); //Stores each word split by a space
                    for (String word : words){
                        if (filter.accept(word)){
                            System.out.println(word);
                        }
                    }
                }

                System.out.println();



                inFile.close();
            }
            else{
                System.out.println("You must choose a file!");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
