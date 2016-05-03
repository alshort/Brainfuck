package brainfuck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application {

  @SuppressWarnings("resource")
  public static void main(String[] args) {

    // Argument handling
    if (args.length != 1) {
      System.err.println("ERROR: No file to load.");
      return;
    }
    
    File brainfuckFile = new File(args[0]);
    if (brainfuckFile.isDirectory()) {
      System.err.println("ERROR: Specified file \"" + brainfuckFile.getAbsolutePath() + "\" is a directory.");
      return;
    }
    if (!brainfuckFile.exists()) {
      System.err.println("ERROR: Specified file \"" + brainfuckFile.getAbsolutePath() + "\" does not exist.");
      return;
    }

    // Read the file
    String input = "";

    try {
      BufferedReader fbr = new BufferedReader(new FileReader(brainfuckFile));
      String line = "";
      while ((line = fbr.readLine()) != null) {
        input += line;
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    // Run interpreter and program
    BrainfuckInterpreter interpreter = new BrainfuckInterpreter();    
    BrainfuckProgram program = BrainfuckProgram.parse(input);

    interpreter.run(program);
  }
}