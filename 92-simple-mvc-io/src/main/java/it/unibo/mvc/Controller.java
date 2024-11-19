package it.unibo.mvc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File currentFile;
    private final static String DEFAULT_FILE = System.getProperty("user.home") + System.getProperty("file.separator") + "output.txt";
    public Controller() {
        this.currentFile = new File(DEFAULT_FILE);
    }
    public File getCurrentFile() {
        return currentFile;
    }
    public void setCurrentFile(final File currentFile) {
        this.currentFile = currentFile;
    }
    public String gePath() {
        return this.currentFile.getPath();
    }
    public void write(final String input) {
        try (final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(this.gePath()), StandardCharsets.UTF_8)){
            outputStreamWriter.write(input);
        } catch (IOException e) {
            System.out.println("error");
        }
    }

}
