package brainfuck.instructions;

import brainfuck.BrainfuckProgram;
import brainfuck.State;

public interface Instruction {
  void execute(BrainfuckProgram prog, State s);
}
