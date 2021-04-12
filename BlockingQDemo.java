package com.app;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(10);
		Thread th1 = new Thread(new Producer(bq));
		Thread th2 = new Thread(new Consumer(bq));
		th1.start();
		th2.start();

	}

}

class Producer implements Runnable {

	BlockingQueue<Integer> bq = null;
	private int i = 0;

	public Producer(BlockingQueue<Integer> bq) {
		super();
		this.bq = bq;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				produce(i++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void produce(int i) throws InterruptedException {
		System.out.println("producer Thread produced elements" + i);
		bq.put(i);
		;
		Thread.sleep(100);

	}

}

class Consumer implements Runnable {

	BlockingQueue<Integer> bq = null;
	private int i = 0;

	public Consumer(BlockingQueue<Integer> bq) {
		super();
		this.bq = bq;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Consumer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void Consumer() throws InterruptedException {
		System.out.println("Consumer Thread Consumed element" + bq.take());
		Thread.sleep(100);

	}

}
