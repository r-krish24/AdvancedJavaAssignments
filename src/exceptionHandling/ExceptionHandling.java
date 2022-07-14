package exceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExceptionHandling {
	
	List<Double> readInputs() throws FileNotFoundException,NumberFormatException
	{
		List<Double> inputs = new ArrayList<Double>();
		File file = new File("C:\\Users\\ramkrishnane\\eclipse-workspace\\AdvanceJavaPractises\\File\\numbs.txt");
		Scanner sc = new Scanner(file);
		
		while (sc.hasNextLine())
			{
				double d = Double.parseDouble(sc.nextLine());
				if(d>=0)
				{
					inputs.add(d);
				}
				else
				{
					throw new ArithmeticException("\\nException Alert !! \\nNumber is negative, Kindly enter positive numbers!"); 
				}
			}
		
		return inputs;
		
	}
	
	double computeDivision(List<Double> inputs)
	{
		double res=0.0d;
		if(inputs.get(1)==0)
		{
			throw new ArithmeticException("\\nException Alert !! \\nDivide by zero is not an appropriate operation!"); 
		}
		else
		{
			res = inputs.get(0)/inputs.get(1);
		}
		return res;
		
	}
}
