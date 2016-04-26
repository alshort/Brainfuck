package brainfuck.instructions;

import brainfuck.State;

public class LeftBracketInstruction implements Instruction {

  @Override
  public void execute(State s) {
    if (s.arr[s.p] == 0) {
      // Skip to corresponding ']'
      int idx = 0;
      int level = 0;
      while (true) {
        idx++;
        if (s.instrs.get(s.i + idx) instanceof LeftBracketInstruction) {
          level++;
        } else if (s.instrs.get(s.i + idx) instanceof RightBracketInstruction) {
          if (level == 0) {
            s.i += idx;
            break;
          } else {
            level--;
          }
        }
      }
    }
  }
}