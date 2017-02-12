package edu.pse.beast.toolbox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;

public class FileSaver {

    /**
     *
     * @param text the text, in a list where each entry is a line that is to be
     * saved
     * @param file the file where it should be saved. WARNING: it overwrites
     * everything that stood in it before
     */
    public static void writeStringLinesToFile(List<String> text, File file) {

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        PrintWriter writer = null;

        try {
            PrintStream stream = new PrintStream(file);
            writer = new PrintWriter(new OutputStreamWriter(stream, "UTF-8"));
        } catch (FileNotFoundException e) {
            ErrorLogger.log("File not found");
        } catch (UnsupportedEncodingException ex) {
            ErrorLogger.log("Unsuported encoding");
        }

        for (Iterator<String> iterator = text.iterator(); iterator.hasNext();) {
            String line = (String) iterator.next();
            writer.println(line);
        }
        writer.close();
    }

    public static void deleteFromRes(String toDelete) {
        File file = new File("./src/main/resources/c_tempfiles/" + toDelete);
        try {
            Files.delete(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
