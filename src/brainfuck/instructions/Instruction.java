package brainfuck.instructions;

import brainfuck.State;

public interface Instruction {
  void execute(State s);
}
