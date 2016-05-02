package brainfuck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import brainfuck.instructions.CommaInstruction;
import brainfuck.instructions.DotInstruction;
import brainfuck.instructions.GreaterThanInstruction;
import brainfuck.instructions.Instruction;
import brainfuck.instructions.LeftBracketInstruction;
import brainfuck.instructions.LessThanInstruction;
import brainfuck.instructions.MinusInstruction;
import brainfuck.instructions.PlusInstruction;
import brainfuck.instructions.RightBracketInstruction;

public class BrainfuckProgram {

  public final List<Instruction> instructions;
  
  private BrainfuckProgram(List<Instruction> instructions) {
    this.instructions = Collections.unmodifiableList(instructions);
  }
  
  
  public static BrainfuckProgram parse(String input) {
    
    // Remove any non-BF characters
    input = input.replaceAll("[^\\[\\]+-.,<>]", "");
    
    // Parse to list of instruction objects
    List<Instruction> instrs = new ArrayList<Instruction>();

    for (char c : input.toCharArray()) {
      switch (c) {
      case '+':
        instrs.add(new PlusInstruction());
        break;
      case '-':
        instrs.add(new MinusInstruction());
        break;
      case '>':
        instrs.add(new GreaterThanInstruction());
        break;
      case '<':
        instrs.add(new LessThanInstruction());
        break;
      case '.':
        instrs.add(new DotInstruction());
        break;
      case ',':
        instrs.add(new CommaInstruction());
        break;
      case '[':
        instrs.add(new LeftBracketInstruction());
        break;
      case ']':
        instrs.add(new RightBracketInstruction());
        break;
      }
    }
    assert(instrs.size() == input.length());
    return new BrainfuckProgram(instrs);
  }

}
