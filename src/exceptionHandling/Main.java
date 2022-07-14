package exceptionHandling;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String args[]) {
		
		List<Double> inputs = new ArrayList<Double>();
		ExceptionHandling eh = new ExceptionHandling();
		try 
		{
			inputs = eh.readInputs();
			System.out.println("Size of input file->"+inputs.size());
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("\\nException Alert !! \\nOopsiee! The file seems to missing in the desired location.");
			System.exit(0);
		}
		catch(NumberFormatException n)
		{
			System.out.println("\nException Alert !! \nKindly ensure the file contains valid numbers only.");
			System.exit(0);
		}
		
		try
		{
			if(inputs.size()>2)
			{
				throw new ArrayIndexOutOfBoundsException(); 
			}
			System.out.println("Numbers from the file are ->"+inputs.get(0)+","+inputs.get(1));
			System.out.println("Division of the above two numbers->"+eh.computeDivision(inputs));
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("\nException Alert !! \nIncorrect file contents, File must contain only two numbers");
			System.exit(0);
		}
	}
}
