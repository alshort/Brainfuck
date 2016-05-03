package brainfuck;

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
}