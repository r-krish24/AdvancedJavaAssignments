package streams;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.*;

public class Main {
	public static void main(String args[])
	  {

	    List<Integer> number = Arrays.asList(2,3,4,5,6);
	    // demonstration of map method
	    System.out.println("Square of all elements in the list:");
	    List<Integer> square = number.stream().map(x -> x*x).collect(Collectors.toList()); 
	    System.out.println(square);
	  
	    List<String> names = Arrays.asList("Java","Spring","HTML");	  
	    // demonstration of filter method
	    System.out.println("List of names starting with only S:");
	    List<String> result = names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());
	    List<String> results = names.stream().map(s->s+s).collect(Collectors.toList());
	    System.out.println(result);
	    System.out.println(results);
	  
	    // demonstration of sorted method
	    System.out.println("Sorted list:");
	    List<String> show = names.stream().sorted().collect(Collectors.toList());
	    System.out.println(show);
	  

	    List<Integer> numbers = Arrays.asList(2,3,4,5,2,5);
	    // collect method returns a set
	    System.out.println("Square Set of list(no repeated valued):");
	    Set<Integer> squareSet = numbers.stream().map(x->x*x).collect(Collectors.toSet());
	    System.out.println(squareSet);
	  
	    // demonstration of forEach method
	    System.out.println("Square of all elements in the list:");
	    number.stream().map(x->x*x).forEach(y->System.out.println(y));
	  
	    // demonstration of reduce method
	    System.out.println("Sum of all even elements in the list:");
	    int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
	    System.out.println(even);
	  }
}
