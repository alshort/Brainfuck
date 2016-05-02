package brainfuck.instructions;

import brainfuck.BrainfuckProgram;
import brainfuck.State;

public class GreaterThanInstruction implements Instruction {

  @Override
  public void execute(BrainfuckProgram prog, State s) {
    s.p = s.p < (s.maxSize - 1) ? s.p + 1 : s.maxSize - 1;
  }
}