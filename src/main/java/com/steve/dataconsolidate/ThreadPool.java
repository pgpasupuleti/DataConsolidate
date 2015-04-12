package com.steve.dataconsolidate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;


public class ThreadPool implements ServletContextListener {

	private ThreadPoolExecutor threadPoolExecutor;
	private static ThreadPool threadPool;
	private static boolean initialized;
	
	private Logger log = Logger.getLogger(ThreadPool.class);
	public static ThreadPool getInstance(){
		return threadPool;
	}
	
	public ThreadPool() throws Exception{
		if(initialized){
			throw new Exception(ThreadPool.class + " has already beean initialized");
		}
		log.info("Initializing DCE Server thread pool");
		threadPoolExecutor = new ThreadPoolExecutor(5, 10,
                3600, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
		initialized = true;
		threadPool = this;
	}
	
	public void submitAndForget(Callable<?> callable){
		threadPoolExecutor.submit(callable);
	}
	
	public <T> void submitAndForget(List<? extends Callable<T>> callables) throws InterruptedException{
		threadPoolExecutor.invokeAll(callables);
	}
	
	public Object submitAndGet(Callable<?> callable) throws InterruptedException, ExecutionException{
		Future<?> future = (Future<?>)threadPoolExecutor.submit(callable).get();
		return future.get();
	}
	
	public <T> List<T> submitAndGet(List<? extends Callable<T>> callables) throws InterruptedException, ExecutionException{
		List<Future<T>> futures = threadPoolExecutor.invokeAll(callables);
		List<T> returnedObjects = new ArrayList<T>();
		for (Future<T> future : futures) {
			returnedObjects.add(future.get());
		}
		return returnedObjects;
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("Shutting down the DCE server thread pool");
		threadPoolExecutor.shutdown();
		log.info("DCE server thread pool stopped");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//Do Nothing
		
	}
}
