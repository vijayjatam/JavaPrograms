package com.kali.kali.jpmorgon;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountdownLatchExample {

	/**
	 * @param args
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executerService = Executors.newFixedThreadPool(2);

		Task task1 = new Task(1, 2);

		Task task2 = new Task(3, 4);

		Task task3 = new Task(2,3);
		Future<Integer> asyncResult3 = executerService.submit(task3);
		Future<Integer> asyncResult1 = executerService.submit(task1);
		Future<Integer> asyncResult2 = executerService.submit(task2);

		System.out.println(" Final output is - " + asyncResult1.get() * asyncResult2.get());
		System.out.println(asyncResult3.get());

		CountDownLatch cdl = new CountDownLatch(2);

		Callable<Integer> cl1 = () -> {
			cdl.countDown();
			return 10 + 20;
		};
		Callable<Integer> cl2 = () -> {
			cdl.countDown();
			return 30 + 40;
		};
		Callable<Integer> cl3 = () -> {
			cdl.countDown();
			return 0 + 10;
		};
		
		Future<Integer> future1 = executerService.submit(cl1);
        Future<Integer> future2 = executerService.submit(cl2);
		Future<Integer> future3 = executerService.submit(cl3);

        try {
            System.out.println(cdl.getCount());
            cdl.await();
            System.out.print(future1.get()*future3.get()*future2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (ExecutionException e) {
            e.printStackTrace();
        }

        //shut down the executor service now
        executerService.shutdown();
	}

	static class Task implements Callable<Integer> {

		Integer val1 = null;
		Integer val2 = null;

		public Task(Integer a, Integer b) {
			this.val1 = a;
			this.val2 = b;
		}

		@Override
		public Integer call() throws Exception {
			return this.val1 + this.val2;
		}

	}

}