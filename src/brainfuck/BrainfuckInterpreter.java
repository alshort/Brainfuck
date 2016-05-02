package brainfuck;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import brainfuck.instructions.Instruction;

public class BrainfuckInterpreter {

  private static final int ARRAY_SIZE = 30000;
  
  private State state;
  
  
  public BrainfuckInterpreter() {
    this.state = new State(ARRAY_SIZE, new byte[ARRAY_SIZE], 0, 0);
  }
  
  public void run(BrainfuckProgram program) {
    
    List<Instruction> instrs = program.instructions;
    
    // Execute the program
    while (state.i < instrs.size()) {
      Instruction instruction = instrs.get(state.i);
      instruction.execute(program, state);

      state.i++;
    }
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) {

    if (args.length != 1) {
      System.out.println("No file to load.");
      return;
    }

    String input = "";

    try {
      BufferedReader fbr = new BufferedReader(new FileReader(args[0]));
      String line = "";
      while ((line = fbr.readLine()) != null) {
        input += line;
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    BrainfuckInterpreter interpreter = new BrainfuckInterpreter();    
    BrainfuckProgram program = BrainfuckProgram.parse(input);

    interpreter.run(program);
  }
}
