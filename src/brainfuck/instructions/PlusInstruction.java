package brainfuck.instructions;

import brainfuck.State;

public class PlusInstruction implements Instruction {

  @Override
  public void execute(State s) {
    s.arr[s.p]++;
  }

}
