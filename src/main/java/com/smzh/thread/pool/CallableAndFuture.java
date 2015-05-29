/**
 * @title CallableAndFuture.java
 * @package com.smzh.thread.pool
 * @projectName jdk-sources
 * @author zhenjun.yu
 * @date 2015年5月28日 下午2:09:14
 */
package com.smzh.thread.pool;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author zhenjun.yu
 */
public class CallableAndFuture {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pools = Executors.newFixedThreadPool(5);
		long start=System.currentTimeMillis();
		Future<String> future=pools.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(10000);
				return "<T> Future<T> submit(Callable<T> task)";
			}
		});
	       //1.Runnable通过Future返回结果为空
		Future<?> future2=pools.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println(" Future<?> submit(Runnable task)  ");
				}
			});
		System.out.println("Runnable:" + future2.get());
		System.out.println(future.get());
		System.out.println(System.currentTimeMillis()-start);
		pools.shutdown();
		
		
		/**
		 * CompletionService用于提交一组Callable任务
		 * 其take方法返回已完成的一个Callable任务对应的Future
		 */
		ExecutorService pools2 = Executors.newFixedThreadPool(10);
		CompletionService<Integer> cs=new ExecutorCompletionService<Integer>(pools2);
		for(int i=0;i<10;i++){
			final int taskId=i;
			cs.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					Thread.sleep(new Random().nextInt(5000));
					return taskId;
				}
			});
		}
		for(int i=0;i<11;i++){
			System.out.println(cs.take().get());
		}
		pools2.shutdown();
		
	}
}
