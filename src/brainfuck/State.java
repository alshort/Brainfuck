package brainfuck;

public class State {

  public final int maxSize;
  public byte[] arr;
  public int p;
  public int i;

  public State(int maxSize, byte[] arr, int p, int i) {
    this.maxSize = maxSize;
    this.arr = arr;
    this.p = p;
    this.i = i;
  }
}