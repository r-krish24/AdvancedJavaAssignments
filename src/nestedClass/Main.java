package nestedClass;

 class OuterClass {
	 
	 class InnerClass1
		{
		    String getClassName()
		    {
		    	return "InnerClass1";
		    }
			void printSomething()
			{
				System.out.println("Hello Maveric from InnerClass1 !");
			}
		}
	
	 protected class InnerClass2
		{
		 	String getClassName()
		    {
		    	return "InnerClass2";
		    }
			void printSomething()
			{
				System.out.println("Hello Maveric from InnerClass2 !");
			}
		}
	 static class InnerStaticClass
	 {
		 String getClassName()
		    {
		    	return "InnerStaticClass";
		    }
		 void printSomething()
		 {
			 System.out.println("Hello Maveric from InnerStaticClass !");
		 }
	 }
	 
	 String getClassName()
	    {
	    	return "OuterClass";
	    }
	 void printSomething()
		{
			System.out.println("Hello Maveric from OuterClass !");
		}
	 
	 void outerLocalMethod() //InnerLocalMethodClass Example
	 {
		 class InnerLocalMethodClass
		 {
			 void printSomething()
				{
					System.out.println("Hello Maveric from InnerLocalMethodClass of localMethod !");
				}
			 void printSumofTwo(int x,int y)
			 {
				 System.out.println("Sum of ("+x+", "+y+") -> "+(x+y));
			 }
		 }
		 InnerLocalMethodClass ilmc = new InnerLocalMethodClass();
		 ilmc.printSomething();
		 System.out.println("Hello Maveric from localMethod !");
		 ilmc.printSumofTwo(5, 10);
	 }
}
public class Main
{
	public static void main(String args[]) {
		OuterClass oc = new OuterClass();
		System.out.println(oc.getClassName());
		oc.printSomething();
		
		OuterClass.InnerClass1 ic1 = oc.new InnerClass1();
		System.out.println(ic1.getClassName());
		ic1.printSomething();
		
		OuterClass.InnerClass2 ic2 = oc.new InnerClass2();
		System.out.println(ic2.getClassName());
		ic2.printSomething();
		
		OuterClass.InnerStaticClass isc = new OuterClass.InnerStaticClass(); //direct obj creation for static class
		System.out.println(isc.getClassName());
		isc.printSomething();
		
		OuterClass anonymous = new OuterClass() // Anonymous Class
		{
			String getClassName()
		    {
		    	return "Anonymous";
		    }
			void printSomething()
			{
				System.out.println("Hello Maveric from Anonymous Class !");
			}	
		};
		System.out.println(anonymous.getClassName());
		anonymous.printSomething();
		
		//InnerLocalMethodClass
		oc.outerLocalMethod();
		
	}
		
}

