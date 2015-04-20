package brainfuck;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BrainfuckInterpreter {

	private static final int arraySize = 30000;
	private static byte[] array = new byte[arraySize];
	private static int p = 0, i = 0;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		if (args.length != 1)
		{
			System.out.println("No file to load.");
			System.exit(0);
		}
		
		String input = "";
		
		try
		{
			BufferedReader fbr = new BufferedReader(new FileReader(args[0]));
			String line = "";
			while ((line = fbr.readLine()) != null)
			{
				input += line;
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		System.out.println(input);

		input = input.replaceAll("[^\\[\\]+-.,<>]", "");
		
		System.out.println(input);
	
		while(i < input.length())
		{
			char instr = input.charAt(i);
			
			switch (instr)
			{
			case '+':
				array[p]++;
				break;
			case '-':
				array[p]--;
				break;
			case '>':
				if (p < (arraySize - 1))
				{
					p++;
				}
				break;
			case '<':
				if (p > 0)
				{
					p--;
				}
				break;
			case '.':
				System.out.print((char) (array[p] & 0xFF));
				break;
			case ',':
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				try
				{
					String consoleInput = br.readLine();
					array[p] = consoleInput.getBytes()[0];
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				break;			
			case '[':
				if (array[p] == 0)
				{
					// Skip to corresponding ']'
					int idx = 0;
					int level = 0;
					while (true)
					{
						idx++;
						if (input.charAt(i + idx) == '[')
						{
							level++;
						}
						else if (input.charAt(i + idx) == ']')
						{
							if (level == 0)
							{
								i += idx;
								break;
							}
							else
							{
								level--;
							}
						}
					}
				}
				break;
			case ']':
				if (array[p] != 0)
				{
					// Move backwards in instructions to corresponding '['
					int idx = 0;
					int level = 0;
					while (true)
					{
						idx++;
						if (input.charAt(i - idx) == ']')
						{
							level++;
						}
						else if (input.charAt(i - idx) == '[')
						{
							if (level == 0)
							{
								i -= idx;
								break;
							}
							else
							{
								level--;
							}
						}
					}
				}
				break;
			}
			
			i++;
		}
		
		/*System.out.println();
		for (int i = 0; i < 10; i++)
		{
			System.out.print(array[i] + " - ");
		}*/
	}
}
