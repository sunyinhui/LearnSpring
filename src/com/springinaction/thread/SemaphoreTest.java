package com.springinaction.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *  Semaphore当前在多线程环境下被扩放使用，操作系统的信号量是个很重要的概念，在进程控制方面都有应用。
 *  Java 并发库 的Semaphore 可以很轻松完成信号量控制，Semaphore可以控制某个资源可被同时访问的个数，
 *  通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。
 *  比如在Windows下可以设置共享文件的最大客户端访问个数。
 */

public class SemaphoreTest {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final  Semaphore sp = new Semaphore(3);
		for(int i=0;i<10;i++){
			Runnable runnable = new Runnable(){
					public void run(){
					try {
						sp.acquire();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					System.out.println("线程" + Thread.currentThread().getName() +
							"进入，当前已有" + (3-sp.availablePermits()) + "个并发");
					try {
						Thread.sleep((long)(Math.random()*10000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("进程" + Thread.currentThread().getName() +
							"即将离开");
					sp.release();
					// 下面代码有是有执行不准确，因为其没有和上面的代码合成原
					System.out.println("线程" + Thread.currentThread().getName() +
							"已离开，当前已有" + (3-sp.availablePermits()) + "个并发");
				}
			};
			service.execute(runnable);			
		}
	}

}
