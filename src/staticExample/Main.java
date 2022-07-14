package staticExample;

public class Main {
	 int i=10;
	static int j=20;
   public static void main(String args[]) {
   	Main s1 = new Main();
       System.out.println(s1.i);
       System.out.println(s1.j);
       s1.i=100;
       s1.j=200;
       Main s2 = new Main();
       System.out.println(s2.i);
       System.out.println(s2.j);
       s1.i=1000;
       s1.j=2000;
       Main s3 = new Main();
       System.out.println(s3.i);
       System.out.println(s3.j);
   }
}
