import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CHMDemo2 extends Thread {
	static ConcurrentHashMap chm = new ConcurrentHashMap();

	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("child thread updating map");
		chm.put(103, "C");

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		chm.put(101, "A");
		chm.put(102, "B");
		CHMDemo2 t1 = new CHMDemo2();
		t1.start();

		Set s = chm.keySet();

		
		  Iterator it = s.iterator(); while (it.hasNext()) { Integer i1 = (Integer)
		  it.next();
		  System.out.println("main Thread Iterating Map and current entry is:" + i1 +
		  " " + chm.get(i1)); Thread.sleep(3000);
		  
		  } System.out.println(chm);
		  
		 
	}

}
