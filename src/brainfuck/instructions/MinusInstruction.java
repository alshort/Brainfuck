package brainfuck.instructions;

import brainfuck.BrainfuckProgram;
import brainfuck.State;

public class MinusInstruction implements Instruction {

  @Override
  public void execute(BrainfuckProgram prog, State s) {
    s.arr[s.p]--;
  }

}
