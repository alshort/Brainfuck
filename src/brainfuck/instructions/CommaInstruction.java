package brainfuck.instructions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import brainfuck.State;

public class CommaInstruction implements Instruction {

  @Override
  public void execute(State s) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
      String consoleInput = br.readLine();
      s.arr[s.p] = consoleInput.getBytes()[0];
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
