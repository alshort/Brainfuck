package brainfuck.instructions;

import brainfuck.BrainfuckProgram;
import brainfuck.State;

public class DotInstruction implements Instruction {

  @Override
  public void execute(BrainfuckProgram prog, State s) {
    System.out.print((char) (s.arr[s.p] & 0xFF));
  }
}