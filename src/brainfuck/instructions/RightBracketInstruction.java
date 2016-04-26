package brainfuck.instructions;

import brainfuck.State;

public class RightBracketInstruction implements Instruction {

  @Override
  public void execute(State s) {
    if (s.arr[s.p] != 0) {
      // Move backwards in instructions to corresponding '['
      int idx = 0;
      int level = 0;
      while (true) {
        idx++;
        if (s.instrs.get(s.i - idx) instanceof RightBracketInstruction) {
          level++;
        } else if (s.instrs.get(s.i - idx) instanceof LeftBracketInstruction) {
          if (level == 0) {
            s.i -= idx;
            break;
          } else {
            level--;
          }
        }
      }
    }
  }
}