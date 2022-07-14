package daemonThread;

public class Main extends Thread {
	
	String name;
	
	@Override
	public void run()
	{
		if(Thread.currentThread().isDaemon())
		{
			System.out.println("This is Daemon thread");
		}
		else
		{
			System.out.println("This is User thread");
		}
	}
	
	
	public static void main(String[] args)
	{
		Main t1 = new Main();
		Main t2= new Main();
		
		//t1.start();
		t1.setDaemon(true);
		t1.start();
		
		t2.start();
	}
	
	public synchronized void welcome(String name)
	{
		for(int i=0;i<5;i++)
		{
			try
			{
				System.out.println("Welcome ->"+Thread.currentThread().getName());
				Thread.sleep(300);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println(name);
		}
	}

}
