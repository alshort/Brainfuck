package brainfuck;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

public class BrainfuckInterpreter {

	private static final int arraySize = 30000;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("No file to load.");
			System.exit(0);
		}
		
		String input = "";
		
		try {
			BufferedReader fbr = new BufferedReader(new FileReader(args[0]));
			String line = "";
			while ((line = fbr.readLine()) != null) {
				input += line;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		input = input.replaceAll("[^\\[\\]+-.,<>]", "");		
		//System.out.println(input);
	
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
		
		// Create and store the state
		State state = new State(Collections.unmodifiableList(instrs), arraySize, new byte[arraySize], 0, 0);
		
		// Execute the program
		while(state.i < input.length()) {
			Instruction instruction = state.instrs.get(state.i);
			instruction.execute(state);
			
			state.i++;
		}
	}
}
