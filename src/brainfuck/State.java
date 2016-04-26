package brainfuck;

import java.util.List;

import brainfuck.instructions.Instruction;

public class State {

  public final List<Instruction> instrs;
  
  public final int maxSize;
  public byte[] arr;
  public int p;
  public int i;
  
  public State(List<Instruction> instrs, int maxSize, byte[] arr, int p, int i) {
    this.instrs = instrs;
    this.maxSize = maxSize;
    this.arr = arr;
    this.p = p;
    this.i = i;
  }
}