package optionalClasses;

import java.util.Optional;

public class Main {
	
	public static void main(String args[])
	{
		Main m = new Main();
		String[] line = new String[25];
		// String word = line[8].toLowerCase();
		//System.out.println("Word->"+word);
		
		Optional<String> posWord = Optional.ofNullable(line[8]);
		
		if(posWord.isPresent())
		{
			String word = line[8].toLowerCase();
			System.out.println(word);
		}
		else
		{
			System.out.println("Line is null");
		}
		
		Integer val1 = null;
		Integer val2 =  new Integer(10);
		
		Optional<Integer> a = Optional.ofNullable(val1);
		Optional<Integer> b = Optional.of(val2);
		
		System.out.println(m.sumOfNumbers(a,b));
	}
	
	public Integer sumOfNumbers(Optional<Integer> a, Optional<Integer> b)
	{
		System.out.println("First Val:"+a.isPresent());
		System.out.println("Second Val:"+b.isPresent());
		
		Integer parm1 = a.orElse(new Integer(15));
		Integer parm2 = b.get();
		
		return parm1+parm2;
		
	}
}

