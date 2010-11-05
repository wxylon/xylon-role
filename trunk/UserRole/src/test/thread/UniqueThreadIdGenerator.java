package test.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class UniqueThreadIdGenerator extends Thread{
	
	private final AtomicInteger uniqueId = new AtomicInteger(0);

    private final ThreadLocal <Integer> uniqueNum = 
	    new ThreadLocal <Integer> () {
	         protected Integer initialValue() {
	            return uniqueId.getAndIncrement();
	         }
    	};
    	
	public void run() {
		super.run();
		for(int i = 0; i < 10 ; i++){
			System.out.println(getName()+":"+getCurrentThreadId());
		}
	}

	public int getCurrentThreadId() {
		uniqueId.incrementAndGet();
        return uniqueId.get();
    }
	
    
    public static void main(String[] args){
    	UniqueThreadIdGenerator generator = new UniqueThreadIdGenerator();
    	generator.start();
    	
    	UniqueThreadIdGenerator generator2 = new UniqueThreadIdGenerator();
    	generator2.start();
    }
}
