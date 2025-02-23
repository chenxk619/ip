package storage;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.util.ArrayList;

import parser.Parse;
import tasks.Task;

public class Storage {
    public static final String FILE_PATH = "duke.txt";
    /**
     * Save the list of items to a txt file
     *
     * @param list arraylist of items to be saved
     * @throws IOException for any issues saving list to txt file
     */
    public static void saveFile(ArrayList<Task> list) throws IOException {
        File myFile = new File(FILE_PATH);
        FileWriter fw = new FileWriter(myFile, false);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Task item : list) {
            bw.write(Parse.formatToFile(item));
            bw.newLine();
        }
        bw.close();
    }

    /**
     * Loads the files into an Arraylist
     *
     * @throws FileNotFoundException if file cannot be found
     */
    public static void loadFile() throws FileNotFoundException {
        File f = new File(FILE_PATH); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            Parse.formatFromFile(s);
        }
    }
}
