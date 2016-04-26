package brainfuck.instructions;

import brainfuck.State;

public class DotInstruction implements Instruction {

  @Override
  public void execute(State s) {
    System.out.print((char) (s.arr[s.p] & 0xFF));
  }
}