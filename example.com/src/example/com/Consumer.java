package example.com;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable  {
	
	// make space for it but don't initialize it yet.
	private final BlockingQueue<Integer> queue;

    @Override
    public void run() {

        try {
            while (true) {
            	
            	// pull each number off as it is ready
            	// take will wait for data, 
            	// blocking this thread until data is ready
                Integer take = queue.take();
                process(take);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    private void process(Integer take) throws InterruptedException {
    	
    	// this is a separate method so  it can throw and exception if something 
    	// goes wrong at run time.
        System.out.println("[Consumer] Take : " + take);
        Thread.sleep(10);
    }

    // get the queue from the caller
    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    
}
