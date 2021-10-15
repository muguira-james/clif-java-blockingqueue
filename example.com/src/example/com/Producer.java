package example.com;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	// make a space for the queue here but don't initialize it yet.
	// notice it has to be "typed" - in this case as Integer
	private final BlockingQueue<Integer> q;
	
	public void run() {
		try {
			for (int i = 0; i< 10; i++) {
				
				// just put some numbers into it
				System.out.println("[Producer] Put : " + i);
				q.put(i);
				Thread.sleep(5);
			}
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public Producer(BlockingQueue <Integer> queue) {
		//
		// this  constructor will get the REAL LIVE  queue structure from 
		// the caller and set it up for this thread to use
		this.q = queue;
	}
}
