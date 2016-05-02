package brainfuck.instructions;

import brainfuck.BrainfuckProgram;
import brainfuck.State;

public class LessThanInstruction implements Instruction {

  @Override
  public void execute(BrainfuckProgram prog, State s) {
    s.p = s.p > 0 ? s.p - 1 : 0;
  }
}