package com.smzh.thread.t1;

import java.util.Timer;
import java.util.TimerTask;

public class MyThreadTimer {

	public static void main(String[] args) {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("bollodf");
			}
		}, 3000);
	}

}
