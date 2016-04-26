package brainfuck.instructions;

import brainfuck.State;

public class MinusInstruction implements Instruction {

  @Override
  public void execute(State s) {
    s.arr[s.p]--;
  }

}
