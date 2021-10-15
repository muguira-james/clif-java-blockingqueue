package example.com;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
	 public static void main(String[] args) {

		// bring a queue into existence 
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

        // hand it  into the producer AND consumer.
        // they will manipulate the queue
        new Thread(new Producer(queue)).start();
        
        // you SHOULD NOT manipulate the queue except with queue api calls 
        // like put, poll, ...
        
        new Thread(new Consumer(queue)).start();

        // the queue dies here.
    }
}
